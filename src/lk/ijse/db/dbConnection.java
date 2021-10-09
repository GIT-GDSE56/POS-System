/*
 * Copyright (c)
 * Licensed to MG4ACA
 *
 */

package lk.ijse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author MG4ACA <mg4.aca@gmail.com>
 * @since 10/9/2021
 */
public class dbConnection {
    private static dbConnection dbConnection;
    private static Connection connection;

    private dbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root","mysql");
    }

    public static dbConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection==null) {
            dbConnection= new dbConnection();
        }return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
