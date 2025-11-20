package edu.icet.repository;

import edu.icet.model.dto.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDetailsRepository {

    boolean addItem(OrderDetails orderDetails) throws SQLException;
    public ResultSet getallItam() throws SQLException;


}
