package edu.icet.services.impl;

import edu.icet.model.dto.AddItem;
import edu.icet.repository.AdditemRepositrory;
import edu.icet.repository.impl.AdditemRepositroryImpl;
import edu.icet.services.AdditemServices;

import java.sql.SQLException;

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
}
