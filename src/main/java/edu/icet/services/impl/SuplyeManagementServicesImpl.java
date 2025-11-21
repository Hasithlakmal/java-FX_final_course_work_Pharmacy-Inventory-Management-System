package edu.icet.services.impl;

import edu.icet.model.dto.AddItem;
import edu.icet.model.dto.Join_suplyerAndAdditem;
import edu.icet.model.dto.Suply;
import edu.icet.repository.SuplyeManagementRepositrory;
import edu.icet.repository.impl.SuplyeManagementRepositroryImpl;
import edu.icet.services.AdditemServices;
import edu.icet.services.SuplyeManagementServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SuplyeManagementServicesImpl implements SuplyeManagementServices {

    SuplyeManagementRepositrory suplyeManagementRepositrory = new SuplyeManagementRepositroryImpl();
    AdditemServices additemServices = new AdditemServicesImpl();


    @Override
    public int additem(Suply item) {
        try {

            return suplyeManagementRepositrory.addItem(item);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Join_suplyerAndAdditem> regesterSuplayes() {


        ObservableList<Join_suplyerAndAdditem> observableList = FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try {
            resultSet = suplyeManagementRepositrory.getallItam();


            while (resultSet.next()) {

                ResultSet barcode = additemServices.getSelectedItam(resultSet.getString("barcode"));

                barcode.next();

                observableList.add(new Join_suplyerAndAdditem(

                        barcode.getString("barcode"),
                        barcode.getString("name"),
                        barcode.getString("brand"),
                        LocalDate.parse(barcode.getString("ExpierDate")),
                        Integer.parseInt(barcode.getString("qyt")),
                        Double.parseDouble(barcode.getString("price")),
                        Double.parseDouble(barcode.getString("salingPrice")),

                        resultSet.getNString("supplier"),
                        resultSet.getString("Tel_No")


                ));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return observableList;
    }

    @Override
    public int updateItem(Suply item) {
        try {
            return suplyeManagementRepositrory.updateItem(item);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteItem(String bacode) {
        int i;
        try {

            i = suplyeManagementRepositrory.deleteItem(bacode);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return i;

    }

    @Override
    public ObservableList<Join_suplyerAndAdditem> getUnRegisterSuplers() {

        // never don't this  ,one methode doing multiy task  becouse ad  some method not working example this methode
        // if you  create this  method  in getallItam() method . it's not working , becouse as one time  tiger two
        // method  from  repositrory  therefore  this method will not be woking  , i speend  to undurstand  this  40 hours


        ObservableList<Join_suplyerAndAdditem> unRegisterSuplers = FXCollections.observableArrayList();
        ObservableList<AddItem> items = additemServices.getallItam();
        ObservableList<Join_suplyerAndAdditem> regsterItam = regesterSuplayes();


        try {


            for (int i = 0; i < regsterItam.size() + 1; i++) {

                for (int j = 0; j < items.size() + 1; j++) {

                    if (items.get(j).getBarcode().equals(regsterItam.get(i).getBarcode())) {

                        items.remove(j);
                        break;

                    }


                }

            }


        } catch (RuntimeException ex) {


        }


        for (AddItem item : items) {

            unRegisterSuplers.add(new Join_suplyerAndAdditem(


                    item.getBarcode(),
                    item.getName(),
                    item.getBrand(),
                    item.getDate(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getSealing(),

                    "Not Registered",
                    "Not Registered"


            ));


        }


        return unRegisterSuplers;


    }

    @Override
    public ObservableList<Suply> getAll(){

        ObservableList<Suply>suplies =FXCollections.observableArrayList();

        try {
            ResultSet resultSet = suplyeManagementRepositrory.getallItam();

            while (resultSet.next()){

                suplies.add(new Suply(

                        resultSet.getString("supplier"),
                        resultSet.getString("Tel_No"),
                        resultSet.getString("barcode")

                ));



            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return suplies;

    }


}
