package edu.icet.services.impl;

import edu.icet.model.dto.OrderDetails;
import edu.icet.model.dto.sealseReport;
import edu.icet.services.AdditemServices;
import edu.icet.services.OrderDetailServices;
import edu.icet.services.SealesReportServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SealesReportServicesImpl implements SealesReportServices {


    private OrderDetailServices orderDetailServices=new OrderDetailServicesImpl();
    private AdditemServices additemServices =new AdditemServicesImpl();

    @Override
    public ObservableList<sealseReport> getAllInfo() {

        ObservableList<sealseReport> selseReport= FXCollections.observableArrayList();
        ObservableList<OrderDetails> selseReport1= FXCollections.observableArrayList();

        ResultSet resultSet = orderDetailServices.getallItam();
        ResultSet resultSet1 = orderDetailServices.getallItam();


        try {

            while (resultSet.next()) {

                for (OrderDetails details : selseReport1) {

                    if (!resultSet.getString("barcode").equals(details.getBarcode())){


                        if (resultSet.getString("Date").equals(LocalDate.now())){  // to day  date cheker

                            OrderDetails detailsNew = null;

                            while (resultSet1.next()){

                                if (resultSet1.getString("barcode").equals(resultSet.getString("barcode"))) {   // same bacode gather

                                    int quty=0;
                                    double price=0.0;

                                    quty += Integer.parseInt(resultSet1.getString("qyt"));
                                    price += Double.parseDouble(resultSet1.getString("total_price"));


                                    details = new OrderDetails(

                                            resultSet.getString("barcode"),
                                            resultSet.getString("bill_no"), // bacode is not want , but i have no time
                                            resultSet.getString("name"),
                                            resultSet.getString("brand"),
                                            LocalDate.parse(resultSet.getString("Date")),
                                            quty,
                                            price



                                    );


                                }

                            }

                            selseReport1.add(detailsNew);


                        }



                    }

                }


//                selseReport.add(new sealseReport(
//
//                        resultSet.getString("barcode"),
//                        resultSet.getString("name"),
//                        resultSet.getString(""),
//
//                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println(selseReport1);


        return null;


    }




}
