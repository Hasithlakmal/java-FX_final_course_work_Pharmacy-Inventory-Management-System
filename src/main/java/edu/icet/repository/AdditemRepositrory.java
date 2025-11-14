package edu.icet.repository;

import edu.icet.model.dto.AddItem;

import java.sql.SQLException;

public interface AdditemRepositrory {

    int addItem(AddItem item) throws SQLException;

}
