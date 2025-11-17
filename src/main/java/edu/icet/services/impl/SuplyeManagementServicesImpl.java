package edu.icet.services.impl;

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

    SuplyeManagementRepositrory suplyeManagementRepositrory=new SuplyeManagementRepositroryImpl();
    AdditemServices additemServices=new AdditemServicesImpl();


    @Override
    public int additem(Suply item) {
        try {

            return suplyeManagementRepositrory.addItem(item);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public ObservableList<Join_suplyerAndAdditem> getallItam() {


        ObservableList<Join_suplyerAndAdditem> observableList=FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try {
            resultSet = suplyeManagementRepositrory.getallItam();



            while (resultSet.next()){

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
    public int deleteItem(String bacode, String name) {
        try {

            if (bacode == null) {

                return suplyeManagementRepositrory.deleteItem(null, name);

            } else if (name == null) {

                return suplyeManagementRepositrory.deleteItem(bacode, null);

            } else if (bacode != null && name != null) {

                return suplyeManagementRepositrory.deleteItem(bacode, null);

            } else {

                return 0;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
