package edu.icet.services;

import edu.icet.model.dto.Join_suplyerAndAdditem;
import edu.icet.model.dto.Suply;
import javafx.collections.ObservableList;

public interface SuplyeManagementServices {

    public int additem(Suply item);

    public ObservableList<Join_suplyerAndAdditem> getallItam() ;

    public int updateItem(Suply item) ;

    public int deleteItem(String bacode, String name) ;


}
