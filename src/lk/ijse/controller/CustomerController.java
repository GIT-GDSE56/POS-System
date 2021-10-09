/*
 * Copyright (c)
 * Licensed to MG4ACA
 *
 */

package lk.ijse.controller;

import lk.ijse.model.Customer;
import lk.ijse.utils.CrudUtils;

/**
 * @author MG4ACA <mg4.aca@gmail.com>
 * @since 10/9/2021
 */
public class CustomerController {
    public boolean addCustomer(Customer customer) throws Exception {
        return CrudUtils.executeUpdate(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }

    public void searchCustomer() {
    }

    public void updateCustomer() {
    }

    public void deleteCustomer() {
    }
}
