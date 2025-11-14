package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.dto.AddItem;
import edu.icet.model.dto.ok;
import edu.icet.services.AdditemServices;
import edu.icet.services.impl.AdditemServicesImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Add_medicines_Controler implements Initializable {


    ObservableList<ok> observableList = FXCollections.observableArrayList();

    AdditemServices additemServices= new AdditemServicesImpl();

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
    private JFXTextField taxtBrand;

    @FXML
    private JFXTextField textBarcode;


    @FXML
    private DatePicker expierDate;


    @FXML
    private JFXTextField textName;

    @FXML
    private JFXTextField textPice;

    @FXML
    private JFXTextField textQyt;


    @FXML
    private JFXTextField textFeildSalingPrices;



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


        int additem = additemServices.additem(new AddItem(

                textBarcode.getText(),
                textName.getText(),
                taxtBrand.getText(),
                expierDate.getValue(),
                Integer.parseInt(textQyt.getText()),
                Double.parseDouble(textPice.getText()),
                Double.parseDouble(textFeildSalingPrices.getText())


        ));


        if(additem>0){

            clerText();

        }


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


    public void clerText() {

        textBarcode.setText(null);
        textName.setText(null);
        taxtBrand.setText(null);
        expierDate.setValue(null);
        textQyt.setText(null);
        textPice.setText(null);
        textFeildSalingPrices.setText(null);



    }


}

