package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.Order;
import edu.icet.repository.OrderRepositrory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositroryImpl  implements OrderRepositrory {


    @Override
    public int addItem(Order order) throws SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into orders  values (?,?,?)");

        preparedStatement.setObject(1,order.getBill_No());
        preparedStatement.setObject(2,order.getDate());
        preparedStatement.setObject(3,order.getNetTotalPrice());

        return preparedStatement.executeUpdate();
    }

    @Override
    public ResultSet getallItam() throws SQLException {
        PreparedStatement preparedStatement = getconnection().prepareStatement("select * from orders");
        return preparedStatement.executeQuery();
    }



    private Connection getconnection() throws SQLException {

        return DBConnection.getDBConnection().getConnection();


    }


}
