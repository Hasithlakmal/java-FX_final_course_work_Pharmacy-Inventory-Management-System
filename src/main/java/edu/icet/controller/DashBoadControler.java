package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoadControler implements Initializable {

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
    }

    public void btnSupler_onAction(ActionEvent actionEvent) {
    }

    public void btn_salse_onAction(ActionEvent actionEvent) {
    }

    public void btn_Expier_On_action(ActionEvent actionEvent) {
    }

    public void btn_Stok_OnActiopn(ActionEvent actionEvent) {
    }

    public void btn_salseReport_onAction(ActionEvent actionEvent) {
    }
}