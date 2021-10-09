/*
 * Copyright (c)
 * Licensed to MG4ACA
 *
 */

package lk.ijse.controller;

import lk.ijse.model.Customer;
import lk.ijse.utils.CrudUtils;

import java.sql.ResultSet;

/**
 * @author MG4ACA <mg4.aca@gmail.com>
 * @since 10/9/2021
 */
public class CustomerController {
    public boolean addCustomer(Customer customer) throws Exception {
        return CrudUtils.executeUpdate("NSERT INTO Customer VALUES (?,?,?,?)", customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }

    public Customer searchCustomer(String Id) throws Exception {
        ResultSet rst = CrudUtils.executeQuarry("SELECT * FROM Customer WHERE id=?", Id);
        if (rst.next()) {
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4)
            );
        }
        return null;

    }

    public boolean updateCustomer(Customer c) throws Exception {
        return CrudUtils.executeUpdate("UPDATE Customer SET name=?, address=?, salary=? WHERE id=?", c.getName(),c.getAddress(),c.getSalary(), c.getId());

    }

    public boolean deleteCustomer(String id) throws Exception {
        return CrudUtils.executeUpdate("DELETE FROM Customer WHERE id=?", id);
    }
}
