package edu.icet.repository;

import edu.icet.model.dto.Suply;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SuplyeManagementRepositrory {

    int addItem(Suply item) throws SQLException;

    public ResultSet getallItam() throws SQLException;

    public int updateItem(Suply item) throws SQLException;

    public int deleteItem(String bacode, String name) throws SQLException;

}
