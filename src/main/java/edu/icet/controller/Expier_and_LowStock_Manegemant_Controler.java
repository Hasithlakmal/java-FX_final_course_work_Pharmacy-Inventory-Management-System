package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import edu.icet.model.dto.LowAndExpier;
import edu.icet.services.ExpierAndLOwStockServices;
import edu.icet.services.impl.ExpierAndLOwStockServicesImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Expier_and_LowStock_Manegemant_Controler  implements Initializable {


    private ExpierAndLOwStockServices expierAndLOwStockServices=new ExpierAndLOwStockServicesImpl();


    @FXML
    private JFXButton btnRefresh;

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
    private TableView<LowAndExpier> Table;

    @FXML
    private TableColumn<?, ?> columBarcode;

    @FXML
    private TableColumn<?, ?> columBrand;

    @FXML
    private TableColumn<?, ?> columExpiryDate;

    @FXML
    private TableColumn<?, ?> columLowStock;

    @FXML
    private TableColumn<?, ?> columName;

    @FXML
    private TableColumn<?, ?> columQuantity;

    @FXML
    private TableColumn<?, ?> columSupplier;

    @FXML
    private TableColumn<?, ?> columTelNo;

    @FXML
    private Label labelBilingNumber;

    @FXML
    private Label labelNetTotal;


    @FXML
    private TableView<LowAndExpier> table;

    @FXML
    void btnRefreshonAction(ActionEvent event) {

        loadItamTabale();

    }

    @FXML
    void btnSupler_onAction(ActionEvent event) {

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


        columBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        columName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        columSupplier.setCellValueFactory(new PropertyValueFactory<>("spmlyer"));
        columQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columExpiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiyerStatus"));
        columLowStock.setCellValueFactory(new PropertyValueFactory<>("Low_Stock"));
        columTelNo.setCellValueFactory(new PropertyValueFactory<>("tel_no"));

        loadItamTabale();

    }

    public void loadItamTabale() {

        Table.setItems(expierAndLOwStockServices.TableLoadDetails());

    }


}