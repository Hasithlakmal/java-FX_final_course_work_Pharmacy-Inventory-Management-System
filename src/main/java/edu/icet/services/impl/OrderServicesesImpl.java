package edu.icet.services.impl;

import edu.icet.model.dto.Order;
import edu.icet.repository.OrderRepositrory;
import edu.icet.repository.impl.OrderRepositroryImpl;
import edu.icet.services.OrderServiceses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderServicesesImpl implements OrderServiceses {

    OrderRepositrory orderRepositrory = new OrderRepositroryImpl();

    @Override
    public int addItem(Order order) {
        try {
          return   orderRepositrory.addItem(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<Order> getallItam() {


        ObservableList<Order> observableList = FXCollections.observableArrayList();

        ResultSet resultSet = null;
        try {
            resultSet = orderRepositrory.getallItam();


            while (resultSet.next()) {

                observableList.add(new Order(

                        resultSet.getString("bill_no"),
                        LocalDate.parse(resultSet.getString("Date")),
                        Double.parseDouble(resultSet.getString("total_Price"))

                ));


            }

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

        return observableList;
    }




}
