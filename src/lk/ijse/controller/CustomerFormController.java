/*
 * Copyright (c)
 * Licensed to MG4ACA
 *
 */

package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.model.Customer;

/**
 * @author MG4ACA <mg4.aca@gmail.com>
 * @since 10/9/2021
 */
public class CustomerFormController {

    public TextField txtID;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    private CustomerController controller=new CustomerController();

    public void addCustomerOnAction(ActionEvent actionEvent) {
        try {
            boolean b = controller.addCustomer(new Customer(txtID.getText(), txtName.getText(), txtAddress.getText(), Double.parseDouble(txtContact.getText())));
            if (b) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Added").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Customer Not Added").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchCustomerOnAction(ActionEvent actionEvent) {
    }

    public void updateCustomerOnAction(ActionEvent actionEvent) {
    }

    public void deleteCustomerOnAction(ActionEvent actionEvent) {
    }
}
