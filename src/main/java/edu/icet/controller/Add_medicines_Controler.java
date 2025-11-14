package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.dto.AddItem;
import edu.icet.services.AdditemServices;
import edu.icet.services.impl.AdditemServicesImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Add_medicines_Controler implements Initializable {


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
    private TableColumn<?, ?> columBrand;

    @FXML
    private TableColumn<?, ?> columExpiryDate;

    @FXML
    private TableColumn<?, ?> columName;

    @FXML
    private TableColumn<?, ?> columPrice;

    @FXML
    private TableColumn<?, ?> columQuantity;

    @FXML
    private TableColumn<?, ?> columSelingPrice;

    @FXML
    private TableView<AddItem> tableAddMedi;


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

            loadItamTabale();
            clerText();

        }


    }

    public void btnUpdateonAction(ActionEvent actionEvent) {

        int b = additemServices.updateItem(new AddItem(

                textBarcode.getText(),
                textName.getText(),
                taxtBrand.getText(),
                expierDate.getValue(),
                Integer.parseInt(textQyt.getText()),
                Double.parseDouble(textPice.getText()),
                Double.parseDouble(textFeildSalingPrices.getText())


        ));
        if (b > 0) {
            loadItamTabale();
        }

    }

    public void btnDelteonAction(ActionEvent actionEvent) {

        int i = additemServices.deleteItem(textBarcode.getText(), textName.getText());

        if (i>0){

            clerText();
            loadItamTabale();

        }

    }

    public void btnCleronActtion(ActionEvent actionEvent) {


        textBarcode.setText(null);
        textName.setText(null);
        taxtBrand.setText(null);
        expierDate.setValue(null);
        textQyt.setText(null);
        textPice.setText(null);
        textFeildSalingPrices.setText(null);


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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        columName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        columExpiryDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columSelingPrice.setCellValueFactory(new PropertyValueFactory<>("sealing"));

//        tblViewItem.getSelectionModel().selectedItemProperty().addListener((((observableValue, oldValue, newValue) -> {
//            if(null!=newValue){
//                setSelectedItem((Item) newValue);
//            }
//        })));


        tableAddMedi.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue!=null){

                setSelectedRow(newValue);

            }

        });

        loadItamTabale();


    }

    private void setSelectedRow(AddItem newValue) {

        textBarcode.setText(newValue.getBarcode());
        textName.setText(newValue.getName());
        taxtBrand.setText(newValue.getBrand());
        expierDate.setValue(newValue.getDate());
        textQyt.setText(String.valueOf(newValue.getQuantity()));
        textPice.setText(String.valueOf(newValue.getPrice()));
        textFeildSalingPrices.setText(String.valueOf(newValue.getSealing()));

    }

    public void  loadItamTabale(){

        tableAddMedi.setItems(additemServices.getallItam());

    }



}

