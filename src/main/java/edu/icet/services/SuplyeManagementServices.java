package edu.icet.services;

import edu.icet.model.dto.Join_suplyerAndAdditem;
import edu.icet.model.dto.Suply;
import edu.icet.model.dto.TwoOBsavelLists;

public interface SuplyeManagementServices {

    public int additem(Suply item);

    public TwoOBsavelLists<Join_suplyerAndAdditem> getallItam() ;

    public int updateItem(Suply item) ;

    public int deleteItem(String bacode, String name) ;


}
