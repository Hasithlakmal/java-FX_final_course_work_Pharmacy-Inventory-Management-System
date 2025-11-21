package edu.icet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Start extends Application {

    Stage stage1 =new Stage();
    Stage stage2 =new Stage();
    Stage stage3 =new Stage();

    public static  void main(String [] args){

        launch();

    }


    @Override
    public void start(Stage stage) throws Exception {

        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/SalseAndBeling.fxml"))));
        stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/Add_medicines.fxml"))));
        stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/Sales_Report.fxml"))));

       stage1.show();
        stage2.show();
        stage3.show();

    }
}
