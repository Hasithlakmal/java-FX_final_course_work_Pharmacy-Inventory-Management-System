package edu.icet.services;

import edu.icet.model.dto.Billing_info;
import edu.icet.model.dto.Order;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface Print_Bill_Services {

    public boolean printBill(Order order , ObservableList<Billing_info> billingInfos)  throws SQLException;

}
