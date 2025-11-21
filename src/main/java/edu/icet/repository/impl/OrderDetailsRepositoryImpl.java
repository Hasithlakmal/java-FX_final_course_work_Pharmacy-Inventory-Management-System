package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.OrderDetails;
import edu.icet.repository.OrderDetailsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {
    @Override
    public boolean addItem(OrderDetails orderDetails) throws SQLException {

        PreparedStatement preparedStatement = getconnection().prepareStatement("insert into order_details  values (?,?,?,?,?,?,?)");

        preparedStatement.setObject(1, orderDetails.getBarcode());
        preparedStatement.setObject(2, orderDetails.getBill_no());
        preparedStatement.setObject(3, orderDetails.getName());
        preparedStatement.setObject(4, orderDetails.getBrand());
        preparedStatement.setObject(5, orderDetails.getDate());
        preparedStatement.setObject(6, orderDetails.getQuantity());
        preparedStatement.setObject(7, orderDetails.getTotal_price());

        int i = preparedStatement.executeUpdate();

        return i==0 ? false : true;

    }

    @Override
    public ResultSet getallItam() throws SQLException {

        PreparedStatement preparedStatement = getconnection().prepareStatement("select * from order_details");
        return preparedStatement.executeQuery();

    }

    private Connection getconnection() throws SQLException {

        return DBConnection.getDBConnection().getConnection();


    }

}
