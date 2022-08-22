package com.university.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    String url = "jdbc:mysql://localhost:3306/university_db";
    String user = "admin";
    String password = "admin@123";
    String driver = "com.mysql.jdbc.Driver";
    Connection connection;

    private static final DbConnection instance = new DbConnection();

    private DbConnection(){}

    public static DbConnection getInstance(){ return instance;}


    public Connection getDbConnection() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is Successful to the database" + url);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {

        if(connection != null) {
            try {
                connection.close();
                System.out.println("Connection is Closed to the database" + url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
