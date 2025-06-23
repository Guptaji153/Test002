package com.java.jsf.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.java.jsf.model.Asset;
import com.java.jsf.util.SessionHelper;

public class AssetDaoImpl implements AssetDao {
	SessionFactory sessionFactory;
	Session session;
	@Override
	public List<Asset> showAsset() {
		    sessionFactory = SessionHelper.getConnection();
	        session = sessionFactory.openSession();
	        Query query = session.getNamedQuery("showAsset");
	        List<Asset> assetList = query.list();
	        session.close();
	        return assetList;
	}
	@Override
	public String addAsset(Asset asset) {
		// TODO Auto-generated method stub
		sessionFactory = SessionHelper.getConnection();
	    session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.save(asset);
	    session.getTransaction().commit();
	    session.close();
	    return "showAsset.jsf?faces-redirect=true";
		
	}

	@Override
	public List<Asset> getAssetByName(Asset asset) {
	    Session session = null;
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        session = sessionFactory.openSession();

	        // Use a LIKE query for partial matches
	        String hql = "FROM Asset a WHERE a.name LIKE :assetName";
	        Query query = session.createQuery(hql);
	        query.setParameter("assetName", "%" + asset.getName() + "%");

	        return query.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

}
