package com.payroll;


import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static final String dburl=System.getenv("DATABASE_URL");
    public static final String dbUser=System.getenv("DATABASE_USER");
    public static final String dbPass=System.getenv("DATABASE_PASSWORD");


    public static void main(String[] args) {

        try {
            Connection con= DriverManager.getConnection(dburl,dbUser,dbPass);
            boolean isReachable= con.isValid(1);
            System.out.println("Connected to database  is " + (isReachable ? "Successful" : "not Successful"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}