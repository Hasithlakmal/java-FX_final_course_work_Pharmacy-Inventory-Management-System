package edu.icet.repository;

import edu.icet.model.dto.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderRepositrory {


    int addItem(Order order) throws SQLException;
    public ResultSet getallItam() throws SQLException;

}
