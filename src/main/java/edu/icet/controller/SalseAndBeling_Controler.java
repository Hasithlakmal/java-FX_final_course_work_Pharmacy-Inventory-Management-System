package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.dto.AddItem;
import edu.icet.model.dto.Billing_info;
import edu.icet.model.dto.Order;
import edu.icet.services.AdditemServices;
import edu.icet.services.Print_Bill_Services;
import edu.icet.services.SalseAndBelingServicers;
import edu.icet.services.impl.AdditemServicesImpl;
import edu.icet.services.impl.Print_Bill_ServicesImpl;
import edu.icet.services.impl.SalseAndBelingServicersImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SalseAndBeling_Controler implements Initializable {


    private ObservableList<Billing_info> observableListBilng = FXCollections.observableArrayList();

    private AdditemServices additemServices = new AdditemServicesImpl();
    private SalseAndBelingServicers salseAndBelingServicers=new SalseAndBelingServicersImpl();
    private Print_Bill_Services printBillServices=new Print_Bill_ServicesImpl();


    @FXML
    private DatePicker DatePiker;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnCler;

    @FXML
    private JFXButton btnDelte;

    @FXML
    private JFXButton btnPrint;

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
    private Label labelBilingNumb;

    @FXML
    private Label labelNetTotal;

    @FXML
    private TableView<Billing_info> table;

    @FXML
    private JFXTextField textBarcode;

    @FXML
    private JFXTextField textBrand;

    @FXML
    private JFXTextField textName;

    @FXML
    private JFXTextField textPrice;

    @FXML
    private JFXTextField textQuantity;

    private LocalDate LocalDate;

    @FXML
    void btnAddonAction(ActionEvent event) {


        Billing_info billing_info;


        if (textQuantity.getLength() != 0) {



            int updatQyt = Integer.parseInt(textQuantity.getText());


            Double AOneItemOfPrice = 0.0;


            for (AddItem details : additemServices.getallItam()) {

                if (details.getBarcode().equals(textBarcode.getText())) {


                    AOneItemOfPrice = details.getSealing();
                }

            }

            double updatePrice = updatQyt * AOneItemOfPrice;

            for (Billing_info oldInfo : observableListBilng) {

                if (oldInfo.getBarcode().equals(textBarcode.getText())) {


                    updatQyt += oldInfo.getQuantity();
                    //updatePrice = Double.parseDouble(txtPrice.getText()) * updatQyt;
                    updatePrice = Double.parseDouble(String.valueOf(AOneItemOfPrice * updatQyt));
                    billing_info = new Billing_info(


                            textBarcode.getText(),
                            textName.getText(),
                            textBrand.getText(),
                            DatePiker.getValue(),
                            updatQyt,
                            updatePrice


                    );


                    observableListBilng.remove(oldInfo);


                    break;

                }


            }


            billing_info = new Billing_info(


                    textBarcode.getText(),
                    textName.getText(),
                    textBrand.getText(),
                    DatePiker.getValue(),
                    updatQyt,
                    updatePrice


            );
            observableListBilng.add(billing_info);

            loadItamTabale();

            setTotal();

            textBarcode.setText(null);
            textName.setText(null);
            textBrand.setText(null);
            textQuantity.setText(null);
            textPrice.setText(null);
            DatePiker.setValue(null);


            billing_info = null;

        } else {

            JOptionPane.showMessageDialog(null, "Qyt Is Empty , Please Enter the Qyt   !!!!");

        }


    }


    @FXML
    void btnCleronActtion(ActionEvent event) {


        textBarcode.setText(null);
        textName.setText(null);
        textBrand.setText(null);
        textQuantity.setText(null);
        textPrice.setText(null);
        DatePiker.setValue(null);

        observableListBilng.clear();

        setTotal();


    }

    @FXML
    void btnDelteonAction(ActionEvent event) {

        String bacode  = textBarcode.getText();

        boolean remove;

        for (Billing_info billing_info : observableListBilng) {

            if (billing_info.getBarcode().equals(bacode)){

                 remove = observableListBilng.remove(billing_info);

                break;

            }

        }

        if (remove=true){

            loadItamTabale();

            textBarcode.setText(null);
            textName.setText(null);
            textBrand.setText(null);
            textQuantity.setText(null);
            textPrice.setText(null);
            DatePiker.setValue(null);

        }

    }

    @FXML
    void btnPrintonAction(ActionEvent event) {

        boolean printBill = false;

        try {

        Order order = new Order(

                labelBilingNumb.getText(),
                LocalDate,
                Double.parseDouble(labelNetTotal.getText())


        );

             printBill = printBillServices.printBill(order, observableListBilng);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (printBill==true){

            labelBilingNumb.setText(salseAndBelingServicers.setBillNo());
            btnCleronActtion(null);



        }



       // System.out.println(salseAndBelingServicers.setBillNo());

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

        LocalDate = LocalDate.now();

      labelBilingNumb.setText(salseAndBelingServicers.setBillNo());

        columBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        columName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        columExpiryDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue!=null){

                setSelectedRow(newValue);

            }

        });



    }

    private void setSelectedRow(Billing_info newValue) {


        textBarcode.setText(newValue.getBarcode());
        textName.setText(newValue.getName());
        textBrand.setText(newValue.getBrand());
        textQuantity.setText(String.valueOf(newValue.getQuantity()));
        textPrice.setText(String.valueOf(newValue.getPrice()));
        DatePiker.setValue(newValue.getDate());



    }



    @FXML
    void QuntityOnAction(KeyEvent event) {

        Double AOneItemOfPrice = 0.0;


        for (AddItem details : additemServices.getallItam()) {

            if (details.getBarcode().equals(textBarcode.getText())) {


                AOneItemOfPrice = details.getSealing();
            }

        }


        int i = Integer.parseInt(textQuantity.getText());
        double tot=i*AOneItemOfPrice;
        textPrice.setText(String.valueOf(tot));

    }



    public void loadItamTabale() {

        table.setItems(observableListBilng);

    }

    private void setTotal() {

        double total = 0.00;

        for (Billing_info billing_info : observableListBilng) {

            total += billing_info.getPrice();

        }

        labelNetTotal.setText(String.valueOf(total));
    }

    @FXML
    void BarcodeSerchOnAction(KeyEvent event) {

        for (AddItem Item : additemServices.getallItam()) {

            if (Item.getBarcode().equals(textBarcode.getText())) {

                textName.setText(Item.getName());
                textBrand.setText(Item.getBrand());

                textPrice.setText(String.valueOf(Item.getSealing()));
                DatePiker.setValue(Item.getDate());


                ///////////////////////////////////////////////  strat  Auto adding to table




                Billing_info billing_info;

                if (textQuantity.getLength() != 0) {

                    int updatQyt = Integer.parseInt(textQuantity.getText());
                    //   double updatePrice = updatQyt * Double.parseDouble(txtPrice.getText());


                    Double AOneItemOfPrice = 0.0;

                    for (AddItem details : additemServices.getallItam()) {

                        if (details.getBarcode().equals(textBarcode.getText())) {


                            AOneItemOfPrice = details.getSealing();
                        }

                    }

                    double updatePrice = updatQyt * AOneItemOfPrice;

                    for (Billing_info oldInfo : observableListBilng) {

                        if (oldInfo.getBarcode().equals(textBarcode.getText())) {


                            updatQyt += oldInfo.getQuantity();
                            //updatePrice = Double.parseDouble(txtPrice.getText()) * updatQyt;
                            updatePrice = Double.parseDouble(String.valueOf(AOneItemOfPrice * updatQyt));
                            billing_info = new Billing_info(


                                    textBarcode.getText(),
                                    textName.getText(),
                                    textBrand.getText(),
                                    DatePiker.getValue(),
                                    updatQyt,
                                    updatePrice


                            );


                            observableListBilng.remove(oldInfo);


                            break;

                        }


                    }


                    billing_info = new Billing_info(


                            textBarcode.getText(),
                            textName.getText(),
                            textBrand.getText(),
                            DatePiker.getValue(),
                            updatQyt,
                            updatePrice


                    );
                    observableListBilng.add(billing_info);

                    loadItamTabale();

                    setTotal();

                    textBarcode.setText(null);
                    textName.setText(null);
                    textBrand.setText(null);

                    textPrice.setText(null);
                    DatePiker.setValue(null);



                    billing_info = null;

                }



            }


        }


    }


}
