package edu.icet.services.impl;

import edu.icet.model.dto.Order;
import edu.icet.services.OrderServiceses;
import edu.icet.services.SalseAndBelingServicers;
import javafx.collections.ObservableList;

public class SalseAndBelingServicersImpl implements SalseAndBelingServicers {

    private OrderServiceses orderServiceses = new OrderServicesesImpl();

    @Override
    public String setBillNo() {

        ObservableList<Order> observableList = orderServiceses.getallItam();

        if (observableList.size() == 0) {

            return "001";

        }

        String lastId = observableList.getLast().getBill_No().substring(0, 3);
        int lasid_No = Integer.parseInt(lastId.substring(1));
        return String.format("%03d", lasid_No + 1);

    }


}
