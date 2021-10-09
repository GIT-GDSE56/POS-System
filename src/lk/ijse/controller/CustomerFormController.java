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
        try {
            Customer customer = controller.searchCustomer(txtID.getText());
            if (customer!=null){
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtContact.setText(String.valueOf(customer.getSalary()));
            }else{
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
}

    public void updateCustomerOnAction(ActionEvent actionEvent) {
        Customer c1 = new Customer(
                txtID.getText(), txtName.getText(), txtAddress.getText()
                , Double.parseDouble(txtContact.getText())
        );
        try {
            boolean b = controller.updateCustomer(c1);
            if (b) {
                new Alert(Alert.AlertType.INFORMATION, "Success").show();

            }else{
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomerOnAction(ActionEvent actionEvent) {
        try {
            boolean b = controller.deleteCustomer(txtID.getText());
            if (b) {
                new Alert(Alert.AlertType.INFORMATION, "Success").show();

            }else{
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
