package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginControler {

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField txtPassworld;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        System.out.println("hasith");

    }

}