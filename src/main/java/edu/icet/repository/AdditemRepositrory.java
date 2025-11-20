package edu.icet.repository;

import edu.icet.model.dto.AddItem;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AdditemRepositrory {

    int addItem(AddItem item) throws SQLException;

    public ResultSet getallItam() throws SQLException;

    public int updateItem(AddItem item) throws SQLException;

    public int deleteItem(String bacode, String name) throws SQLException;

    ResultSet getSelectedItam(String bacode) throws SQLException;

    boolean updateQuantityItam(String bacode ,int quantity) throws SQLException;
}
