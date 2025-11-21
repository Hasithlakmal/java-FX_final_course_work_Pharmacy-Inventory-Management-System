package edu.icet.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Chack_controler implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String text="FOREIGN KEY(sno) REFERENCES student(sno) ON DELETE CASCADE ON UPDATE CASCADE";


        System.out.println(text.toLowerCase());

    }
}
