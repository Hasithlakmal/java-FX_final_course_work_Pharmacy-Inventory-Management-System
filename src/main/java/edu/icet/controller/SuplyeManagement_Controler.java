package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import edu.icet.dto.ok;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SuplyeManagement_Controler implements Initializable {


    ObservableList<ok> observableList = FXCollections.observableArrayList();

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnCler;

    @FXML
    private JFXButton btnDelte;

    @FXML
    private JFXButton btnSupler;

    @FXML
    private JFXButton btnUpdate;

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
    private TableColumn<?, ?> columBrand;

    @FXML
    private TableColumn<?, ?> columName;

    @FXML
    private TableColumn<?, ?> columName11;

    @FXML
    private TableColumn<?, ?> columPrice;

    @FXML
    private TableColumn<?, ?> columQuantity;

    @FXML
    private TableColumn<?, ?> columSelingPrice;

    @FXML
    private TableView<ok> tableAddMedi;

    @FXML
    void btnAddonAction(ActionEvent event) {

    }

    @FXML
    void btnCleronActtion(ActionEvent event) {

    }

    @FXML
    void btnDelteonAction(ActionEvent event) {

    }

    @FXML
    void btnSupler_onAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateonAction(ActionEvent event) {

    }

    @FXML
    void btn_Expier_On_action(ActionEvent event) {

    }

    @FXML
    void btn_Stok_OnActiopn(ActionEvent event) {

    }

    @FXML
    void btn_addon_action(ActionEvent event) {

    }

    @FXML
    void btn_salseReport_onAction(ActionEvent event) {

    }

    @FXML
    void btn_salse_onAction(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columBarcode.setCellValueFactory(new PropertyValueFactory<>("name"));
        columName.setCellValueFactory(new PropertyValueFactory<>("number"));


        for (int i = 0; i < 100; i++) {

            ok o = new ok("hasith", i);


            observableList.add(o);

            tableAddMedi.setItems(observableList);
        }


    }

}
