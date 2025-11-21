package edu.icet.services.impl;

import edu.icet.model.dto.Join_suplyerAndAdditem;
import edu.icet.model.dto.LowAndExpier;
import edu.icet.services.AdditemServices;
import edu.icet.services.ExpierAndLOwStockServices;
import edu.icet.services.SuplyeManagementServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ExpierAndLOwStockServicesImpl implements ExpierAndLOwStockServices {

    private AdditemServices additemServices= new AdditemServicesImpl();
    private SuplyeManagementServices suplyeManagementServices =new SuplyeManagementServicesImpl();
    


    private String date = "";

    private int LowNumber = 5;


    @Override
    public ObservableList<LowAndExpier> TableLoadDetails(){

        ObservableList<LowAndExpier> lowAndExpiers=FXCollections.observableArrayList();
        ObservableList<Join_suplyerAndAdditem> combinedList = FXCollections.observableArrayList();

        combinedList.addAll(suplyeManagementServices.regesterSuplayes());
        combinedList.addAll(suplyeManagementServices.getUnRegisterSuplers());

        for (Join_suplyerAndAdditem exAndLo : combinedList) {

            lowAndExpiers.add(new LowAndExpier(

                    exAndLo.getBarcode(),
                    exAndLo.getName(),
                    exAndLo.getBrand(),
                    exAndLo.getSumlyer(),
                    exAndLo.getQuantity(),
                    ChakExperStatus(String.valueOf(exAndLo.getDate())),
                    ChakLowStockStatus(exAndLo.getQuantity()),
                    exAndLo.getTel_no()

            ));

        }

        return lowAndExpiers;

    }





  private String ChakExperStatus(String localDate) {

        String dateStr = localDate;
        String ExpierDate = dateStr.replace("-", "");
        int intExpierDate = Integer.parseInt(ExpierDate);


        int intTOday =setDateString();

        String ExP = "";

        if (intExpierDate - intTOday == 0) {

            ExP = "Expired";

        } else if (intExpierDate - intTOday < 0) {

            ExP = "EXP " + (intExpierDate - intTOday) + "Day ago";


        } else if (intExpierDate - intTOday > 0) {

            ExP = "EXP With In " + (intExpierDate - intTOday) + "Day";

        }


        return ExP;

    }


    private String ChakLowStockStatus(int Quty) {

        return Quty>LowNumber ? ""+Quty : "Low_Stock";
    }


    private int setDateString(){

        String dateStr =String.valueOf(LocalDate.now());
        String Today = dateStr.replace("-", "");

        return Integer.parseInt(Today);


    }


}
