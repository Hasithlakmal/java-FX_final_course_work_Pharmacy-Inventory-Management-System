package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import edu.icet.model.dto.ok;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Add_medicines_Controler implements Initializable {


    ObservableList<ok> observableList = FXCollections.observableArrayList();


    @FXML
    private JFXButton btnSupler;

    @FXML
    private JFXButton btn_Expier;

    @FXML
    private JFXButton btn_Stok;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_salse;

    @FXML
    private JFXButton btn_salseReport;

    @FXML
    private TableColumn<?, ?> columBarcode;


    @FXML
    private TableColumn<?, ?> columName;

    @FXML
    private TableView<ok> tableAddMedi;

    @FXML
    void btnSupler_onAction(ActionEvent event) {

    }

    @FXML
    void btn_Expier_On_action(ActionEvent event) {

    }

    @FXML
    void btn_Stok_OnActiopn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void btn_addon_action(ActionEvent actionEvent) {
    }

    public void btn_salseReport_onAction(ActionEvent actionEvent) {
    }

    public void btn_salse_onAction(ActionEvent actionEvent) {
    }

    public void btnAddonAction(ActionEvent actionEvent) {
        System.out.println("Add");
    }

    public void btnUpdateonAction(ActionEvent actionEvent) {

        System.out.println("update");

    }

    public void btnDelteonAction(ActionEvent actionEvent) {

        System.out.println("delete");
    }

    public void btnCleronActtion(ActionEvent actionEvent) {

        System.out.println("cler");
    }
}

