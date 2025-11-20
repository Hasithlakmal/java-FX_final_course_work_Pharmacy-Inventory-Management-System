package edu.icet.services;

import edu.icet.model.dto.Billing_info;
import edu.icet.model.dto.Order;
import javafx.collections.ObservableList;

public interface OrderDetailServices {

    public boolean additem(Order order , ObservableList<Billing_info> billingInfos);
}
