package edu.icet.services.impl;

import edu.icet.model.dto.Suply;
import edu.icet.repository.SuplyeManagementRepositrory;
import edu.icet.repository.impl.SuplyeManagementRepositroryImpl;
import edu.icet.services.SuplyeManagementServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuplyeManagementServicesImpl implements SuplyeManagementServices {

    SuplyeManagementRepositrory suplyeManagementRepositrory=new SuplyeManagementRepositroryImpl();


    @Override
    public int additem(Suply item) {
        try {

            return suplyeManagementRepositrory.addItem(item);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public ObservableList<Suply> getallItam() {
        ObservableList <Suply> observableList= FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try {
            resultSet = suplyeManagementRepositrory.getallItam();


            while (resultSet.next()){

                observableList.add(new Suply(

                        resultSet.getNString("supplier"),
                        resultSet.getNString("Tel_No"),
                        resultSet.getNString("barcode")


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
