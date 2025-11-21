package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoadControler implements Initializable {

    private Stage stage1 =new Stage();
    private Stage stage2 =new Stage();
    private Stage stage3 =new Stage();
    private Stage stage4 =new Stage();
    private Stage stage5 =new Stage();
    private Stage stage6 =new Stage();

    @FXML
    private LineChart<?, ?> MonthliyIncomChart;

    @FXML
    private LineChart<?, ?> anualIncomeChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        XYChart.Series  series=new XYChart.Series();

        series.getData().add(new XYChart.Data<>("1",20000));
        series.getData().add(new XYChart.Data<>("2",10000));
        series.getData().add(new XYChart.Data<>("3",80000));
        series.getData().add(new XYChart.Data<>("4",30000));
        series.getData().add(new XYChart.Data<>("5",400000));
        series.getData().add(new XYChart.Data<>("6",40000));
        series.getData().add(new XYChart.Data<>("7",5000));
        series.getData().add(new XYChart.Data<>("8",70000));
        series.getData().add(new XYChart.Data<>("9",500000));
        series.getData().add(new XYChart.Data<>("10",600000));
        series.getData().add(new XYChart.Data<>("11",900000));
        series.getData().add(new XYChart.Data<>("12",600000));

        anualIncomeChart.getData().add(series);

        XYChart.Series  series1=new XYChart.Series();

        series1.getData().add(new XYChart.Data<>("1",5000));
        series1.getData().add(new XYChart.Data<>("2",1000));
        series1.getData().add(new XYChart.Data<>("3",8000));
        series1.getData().add(new XYChart.Data<>("4",3000));

        MonthliyIncomChart.getData().add(series1);

    }

    public void btn_addon_action(ActionEvent actionEvent) {

        try {
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/Add_medicines.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage1.show();

    }

    public void btnSupler_onAction(ActionEvent actionEvent) {

        try {
            stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/SuplyeManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage2.show();
    }

    public void btn_salse_onAction(ActionEvent actionEvent) {

        try {
            stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/SalseAndBeling.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage3.show();

    }

    public void btn_Expier_On_action(ActionEvent actionEvent) {
        try {
            stage4.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/ExpierAndLowStock.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage4.show();

    }

    public void btn_Stok_OnActiopn(ActionEvent actionEvent) {

        try {
            stage5.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/StorckSummary.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage5.show();

    }

    public void btn_salseReport_onAction(ActionEvent actionEvent) {

        try {
            stage6.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/Sales_Report.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage6.show();

    }
}