package edu.icet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Start extends Application {

    Stage stage1 =new Stage();


    public static  void main(String [] args){

        launch();

    }


    @Override
    public void start(Stage stage) throws Exception {

        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/Login.fxml"))));

       stage1.show();


    }
}
