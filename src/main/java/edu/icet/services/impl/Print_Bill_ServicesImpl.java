package edu.icet.services.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.Billing_info;
import edu.icet.model.dto.Order;
import edu.icet.services.AdditemServices;
import edu.icet.services.OrderDetailServices;
import edu.icet.services.OrderServiceses;
import edu.icet.services.Print_Bill_Services;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

public class Print_Bill_ServicesImpl implements Print_Bill_Services {

  private OrderServiceses orderServiceses=new OrderServicesesImpl();
  private OrderDetailServices orderDetailServices=new OrderDetailServicesImpl();
  private AdditemServices additemServices=new AdditemServicesImpl();


    public boolean printBill(Order order, ObservableList<Billing_info> billingInfos) throws SQLException {

        Connection connection = DBConnection.getDBConnection().getConnection();

        boolean isUpdateItamQuty=false;

        try {

            connection.setAutoCommit(false);


            int plaseOrder = orderServiceses.addItem(order);

        if (plaseOrder > 0) {

            boolean isAdditem = orderDetailServices.additem(order, billingInfos);

            if (isAdditem) {

                 isUpdateItamQuty = additemServices.updateQuantityItam(billingInfos);

                if (isUpdateItamQuty) {

                    connection.commit();

                }
            }

        }

        } catch (SQLException e) {

            connection.rollback();

            throw new RuntimeException(e);
        }

        finally {

            connection.setAutoCommit(true);

        }

       return isUpdateItamQuty;

    }




}
