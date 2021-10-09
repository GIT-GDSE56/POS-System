/*
 * Copyright (c)
 * Licensed to MG4ACA
 *
 */

package lk.ijse.utils;

import lk.ijse.db.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MG4ACA <mg4.aca@gmail.com>
 * @since 10/9/2021
 */
public class CrudUtils {
    private static PreparedStatement getPreparedStatement(String sql, Object... data) throws SQLException, ClassNotFoundException {
        Connection connection = dbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        for (int i = 0; i < data.length; i++) {
            stm.setObject(i+1,data[i]);
        }
        return stm;
    }

    public static boolean executeUpdate(String sql, Object... data) throws Exception {
        return getPreparedStatement(sql, data).executeUpdate()>0;
    }

    public static ResultSet executeQuarry(String sql, Object... data) throws Exception {
        return getPreparedStatement(sql, data).executeQuery();
    }
}
