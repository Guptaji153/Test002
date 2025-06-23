package com.java.serv;

import java.sql.Connection;

import com.java.serv.conection.ConnectionHelper;

public class DbTest {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionHelper.getConnection();
            System.out.println("Connection successful!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
