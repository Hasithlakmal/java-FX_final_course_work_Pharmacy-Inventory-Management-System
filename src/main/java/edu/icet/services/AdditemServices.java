package edu.icet.services;

import edu.icet.model.dto.AddItem;
import javafx.collections.ObservableList;

public interface AdditemServices {

    public int additem(AddItem item);

    public ObservableList<AddItem> getallItam() ;

    public int updateItem(AddItem item) ;

    public int deleteItem(String bacode, String name) ;

}
