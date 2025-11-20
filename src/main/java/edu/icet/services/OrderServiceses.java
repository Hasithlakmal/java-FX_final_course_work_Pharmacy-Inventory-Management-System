package edu.icet.services;

import edu.icet.model.dto.Order;
import javafx.collections.ObservableList;

public interface OrderServiceses {

    int addItem(Order order);
    public ObservableList<Order> getallItam() ;

}
