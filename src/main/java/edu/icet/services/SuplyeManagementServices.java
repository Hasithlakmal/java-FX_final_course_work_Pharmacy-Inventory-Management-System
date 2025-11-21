package edu.icet.services;

import edu.icet.model.dto.Join_suplyerAndAdditem;
import edu.icet.model.dto.Suply;
import javafx.collections.ObservableList;

public interface SuplyeManagementServices {

    public int additem(Suply item);

    public ObservableList<Join_suplyerAndAdditem> regesterSuplayes() ; ;

    public int updateItem(Suply item) ;

    public int deleteItem(String bacode) ;

    public ObservableList<Join_suplyerAndAdditem> getUnRegisterSuplers();

    public ObservableList<Suply> getAll();
}
