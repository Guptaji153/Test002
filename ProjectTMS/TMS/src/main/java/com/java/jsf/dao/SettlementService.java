package com.java.jsf.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.ejb.Expenses;
import com.java.ejb.GroupsMember;
import com.java.jsf.model.SettlementResult;

public class SettlementService {

    private SessionFactory sessionFactory;

    public SettlementService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println("SettlementService initialized with sessionFactory: " + sessionFactory);
    }

    public SettlementResult settlement(int groupId) {
        int adminId = 12;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        SettlementResult result = new SettlementResult();

        try {
            tx = session.beginTransaction();

            // Total amount collected
            Query q1 = session.createQuery("SELECT SUM(m.amountCollected) FROM GroupsMember m WHERE m.groupId = :gid");
            q1.setParameter("gid", groupId);
            Double totalCollected = (Double) q1.uniqueResult();
            if (totalCollected == null) totalCollected = 0.0;

            // Member count
            Query q2 = session.createQuery("SELECT COUNT(m.id) FROM GroupsMember m WHERE m.groupId = :gid");
            q2.setParameter("gid", groupId);
            Long memberCount = (Long) q2.uniqueResult();
            if (memberCount == null || memberCount == 0) memberCount = 1L; // avoid divide-by-zero

            // Total expenses
            Query q3 = session.createQuery("SELECT SUM(e.amount) FROM Expenses e WHERE e.groupId = :gid");
            q3.setParameter("gid", groupId);
            Double totalExpenses = (Double) q3.uniqueResult();
            if (totalExpenses == null) totalExpenses = 0.0;

            // Balance per person
            double balancePerPerson = (totalExpenses - totalCollected) / memberCount;

            // Admin refund
            Query q4 = session.createQuery(
                "SELECT SUM(e.amount) FROM Expenses e WHERE e.groupId = :gid AND e.paidBy = :adminId"
            );
            q4.setParameter("gid", groupId);
            q4.setParameter("adminId", adminId);
            Double adminPaid = (Double) q4.uniqueResult();
            if (adminPaid == null) adminPaid = 0.0;
            double adminRefund = (adminPaid - 80000) - balancePerPerson;

            // Set result fields
            result.setGroupId(groupId);
            result.setTotalCollected(totalCollected);
            result.setTotalExpenses(totalExpenses);
            result.setMemberCount(memberCount.intValue());
            result.setBalancePerPerson(balancePerPerson);
            result.setAdminRefundAmount(adminRefund);
            result.setAdminId(adminId);
            result.setSettlementDate(new Date());

            // Save to DB
            session.save(result);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }
}
