package com.payroll.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbService {

    public static final String dbUrl = System.getenv("DATABASE_URL");
    public static final String dbUser = System.getenv("DATABASE_USER");
    public static final String dbPass = System.getenv("DATABASE_PASSWORD");


    public static  Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        boolean isReachable = con.isValid(1);
        System.out.println("Connected to database  is " + (isReachable ? "Successful" : "not Successful"));
        return con;
    }
}
