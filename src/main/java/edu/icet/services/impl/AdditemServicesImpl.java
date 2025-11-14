package edu.icet.services.impl;

import edu.icet.model.dto.AddItem;
import edu.icet.repository.AdditemRepositrory;
import edu.icet.repository.impl.AdditemRepositroryImpl;
import edu.icet.services.AdditemServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdditemServicesImpl implements AdditemServices {


  private   AdditemRepositrory additemRepositrory=new AdditemRepositroryImpl();


    @Override
    public int additem(AddItem item) {

        try {

            return additemRepositrory.addItem(item);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList <AddItem> getallItam()  {

        ObservableList <AddItem> observableList= FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try {
            resultSet = additemRepositrory.getallItam();


        while (resultSet.next()){

            observableList.add(new AddItem(

                    resultSet.getString("barcode"),
                    resultSet.getString("name"),
                    resultSet.getString("brand"),
                    LocalDate.parse(resultSet.getString("ExpierDate")),
                    Integer.parseInt(resultSet.getString("qyt")),
                    Double.parseDouble(resultSet.getString("price")),
                    Double.parseDouble(resultSet.getString("salingPrice"))

            ));



        }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return observableList;

    }

    @Override
    public int updateItem(AddItem item) {
        try {
            return additemRepositrory.updateItem(item);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteItem(String bacode, String name) {

        try {

            if (bacode == null) {

                return additemRepositrory.deleteItem(null, name);

            } else if (name == null) {

                return additemRepositrory.deleteItem(bacode, null);

            } else if (bacode != null && name != null) {

                return additemRepositrory.deleteItem(bacode, null);

            } else {

                return 0;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
