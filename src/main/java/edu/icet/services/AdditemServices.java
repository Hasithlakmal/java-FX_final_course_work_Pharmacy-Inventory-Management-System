package edu.icet.services;

import edu.icet.model.dto.AddItem;
import edu.icet.model.dto.Billing_info;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public interface AdditemServices {

    public int additem(AddItem item);

    public ObservableList<AddItem> getallItam() ;

    public int updateItem(AddItem item) ;

    public int deleteItem(String bacode, String name) ;

    ResultSet getSelectedItam(String bacode) ;

    boolean updateQuantityItam(ObservableList<Billing_info> billingInfos);


}
