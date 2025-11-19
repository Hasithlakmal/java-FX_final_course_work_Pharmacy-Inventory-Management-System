package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.dto.Join_suplyerAndAdditem;
import edu.icet.model.dto.Suply;
import edu.icet.services.AdditemServices;
import edu.icet.services.SuplyeManagementServices;
import edu.icet.services.impl.AdditemServicesImpl;
import edu.icet.services.impl.SuplyeManagementServicesImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.ResourceBundle;

public class SuplyeManagement_Controler implements Initializable {


    SuplyeManagementServices suplyeManagementServices=new SuplyeManagementServicesImpl();
    AdditemServices additemServices=new AdditemServicesImpl();


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
    private TableColumn<?, ?> columExpiryDate;

    @FXML
    private TableColumn<?, ?> columName;

    @FXML
    private TableColumn<?, ?> columQuantity;

    @FXML
    private TableColumn<?, ?> columSupplier;

    @FXML
    private TableColumn<?, ?> columTel_No;
    @FXML
    private TableView<Join_suplyerAndAdditem> table;


    @FXML
    private JFXTextField textBarcode;

    @FXML
    private JFXTextField textBrand;

    @FXML
    private JFXTextField textQuantity;

    @FXML
    private JFXTextField textSupplier;

    @FXML
    private JFXTextField textTel;

    @FXML
    private DatePicker DatePiker;

    @FXML
    void btnAddonAction(ActionEvent event) {

        ObservableList<Join_suplyerAndAdditem> regesterSuplayes = suplyeManagementServices.regesterSuplayes();

        if (isEmptyObservelListCheker(regesterSuplayes)){

            int additem = suplyeManagementServices.additem(new Suply(

                    textSupplier.getText(),
                    textTel.getText(),
                    textBarcode.getText()
            ));

            if(additem>0){

                loadItamTabale();
                btnCleronActtion(null);


            }

        }else {

            for (Join_suplyerAndAdditem regesterSuplyerss :regesterSuplayes) {

                if (!regesterSuplyerss.getBarcode().equals(textBarcode.getText())){

                    int additem = suplyeManagementServices.additem(new Suply(

                            textSupplier.getText(),
                            textTel.getText(),
                            textBarcode.getText()
                    ));

                    if(additem>0){

                        loadItamTabale();
                        btnCleronActtion(null);


                    }

                }

            }




        }


    }

    @FXML
    void btnCleronActtion(ActionEvent event) {


        textBarcode.setText(null);
        textBrand.setText(null);
        DatePiker.setValue(null);
        textQuantity.setText(null);
        textSupplier.setText(null);
        textTel.setText(null);


    }

    @FXML
    void btnDelteonAction(ActionEvent event) {


        int i = suplyeManagementServices.deleteItem(textBarcode.getText());

        if (i>0){

            btnCleronActtion(null);
            loadItamTabale();

        }


    }

    @FXML
    void btnSupler_onAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateonAction(ActionEvent event) {

        int i = suplyeManagementServices.updateItem(new Suply(

                textSupplier.getText(),
                textTel.getText(),
                textBarcode.getText()

        ));

        if (i>0){

            btnCleronActtion(null);
            loadItamTabale();

        }

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

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        columBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        columName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        columSupplier.setCellValueFactory(new PropertyValueFactory<>("sumlyer"));
        columQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columExpiryDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columTel_No.setCellValueFactory(new PropertyValueFactory<>("tel_no"));


        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue!=null){

                setSelectedRow(newValue);

            }

        });





        loadItamTabale();


    }

    private void setSelectedRow(Join_suplyerAndAdditem newValue) {

        textBarcode.setText(newValue.getBarcode());
        textBrand.setText(newValue.getBrand());
        DatePiker.setValue(newValue.getDate());
        textQuantity.setText(String.valueOf(newValue.getQuantity()));
        textSupplier.setText(newValue.getSumlyer());
        textTel.setText(newValue.getTel_no());


    }


    public void loadItamTabale() {

        ObservableList<Join_suplyerAndAdditem> combinedList = FXCollections.observableArrayList();

        combinedList.addAll(suplyeManagementServices.regesterSuplayes());
        combinedList.addAll(suplyeManagementServices.getUnRegisterSuplers());

        table.setItems(combinedList);


    }

    private boolean isEmptyObservelListCheker(ObservableList list) {
        return list.size() == 0;
    }



    @FXML
    void BarcodeSerchOnAction(KeyEvent event) {

        btnCleronActtion(null);

        String text = textBarcode.getText();

        for ( Join_suplyerAndAdditem  joinSuplyerAndAdditem  : suplyeManagementServices.regesterSuplayes()) {

            if (joinSuplyerAndAdditem.getBarcode().equals(text)){


                textBrand.setText(joinSuplyerAndAdditem.getBrand());
                DatePiker.setValue(joinSuplyerAndAdditem.getDate());
                textQuantity.setText(String.valueOf(joinSuplyerAndAdditem.getQuantity()));
                textSupplier.setText(joinSuplyerAndAdditem.getSumlyer());
                textTel.setText(joinSuplyerAndAdditem.getTel_no());


            }else {



                for (Join_suplyerAndAdditem Item : suplyeManagementServices.getUnRegisterSuplers()) {

                    if (Item.getBarcode().equals(text)){


                        textBrand.setText(Item.getBrand());
                        DatePiker.setValue(Item.getDate());
                        textQuantity.setText(String.valueOf(Item.getQuantity()));
                        textSupplier.setText(null);
                        textTel.setText(null);



                    }



                }

            }


        }




    }




}
