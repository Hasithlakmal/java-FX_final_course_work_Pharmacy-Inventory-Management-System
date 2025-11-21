package edu.icet.services.impl;

import edu.icet.model.dto.Billing_info;
import edu.icet.model.dto.Order;
import edu.icet.model.dto.OrderDetails;
import edu.icet.repository.OrderDetailsRepository;
import edu.icet.repository.impl.OrderDetailsRepositoryImpl;
import edu.icet.services.OrderDetailServices;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderDetailServicesImpl implements OrderDetailServices {

    private OrderDetailsRepository orderDetailsRepository=new OrderDetailsRepositoryImpl();

    @Override
    public boolean additem(Order order , ObservableList<Billing_info> billingInfos) {

        boolean isAddDetails=false;

        try {

        for (Billing_info billingInfo : billingInfos) {



                isAddDetails = orderDetailsRepository.addItem(new OrderDetails(

                        billingInfo.getBarcode(),
                        order.getBill_No(),
                        billingInfo.getName(),
                        billingInfo.getBrand(),
                        LocalDate.now(),
                        billingInfo.getQuantity(),
                        billingInfo.getPrice())

                );


            if (isAddDetails==false){

                break;
            }



        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAddDetails;
    }

    @Override
    public ResultSet getallItam() {


        try {
            return   orderDetailsRepository.getallItam();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
