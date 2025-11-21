package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import edu.icet.services.SealesReportServices;
import edu.icet.services.impl.SealesReportServicesImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SealesReportControler implements Initializable {


    private SealesReportServices sealesReportServices=new SealesReportServicesImpl();

    @FXML
    private JFXButton btnPrint;

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
    private Label lableDate;

    @FXML
    private Label labelBilingNumber;

    @FXML
    private Label labelNetTotal;

    @FXML
    private PieChart piChart;

    @FXML
    private TableView<?> tableAddMedi;

    @FXML
    void btnRefreshonAction(ActionEvent event) {

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

        lableDate.setText(String.valueOf(LocalDate.now()));


        String phrase ="date";
        String upperCasePhrase = phrase.toUpperCase(); // "SALES REPORTS"
        System.out.println(upperCasePhrase);


        // Create a list to hold PieChart.Data objects
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Profit", 20000),
                new PieChart.Data("Cost", 10000),
                new PieChart.Data("Sales", 80000)

        );

        double total = 0;
        for (PieChart.Data data : pieChartData) {
            System.out.println("hi "+data);
            total += data.getPieValue();
        }

        for (PieChart.Data data : pieChartData) {
            double percentage = (data.getPieValue() / total) * 100;
            data.setName(data.getName() + String.format(" %.1f%%", percentage));
        }



// Optionally, you can set a title
        piChart.setTitle("Annual Income Distribution");

// Add the pieChart to your scene or layout pane

        piChart.getData().addAll(pieChartData);

    }


    @FXML
    void btnPrintonAction(ActionEvent event) {

       sealesReportServices.getAllInfo();

    }


}
