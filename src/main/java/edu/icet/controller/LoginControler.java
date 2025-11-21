package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginControler {


    Stage stage1 =new Stage();

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField txtPassworld;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/DashBoad.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage1.show();

    }

}