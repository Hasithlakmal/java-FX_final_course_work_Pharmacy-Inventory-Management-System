package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.AddItem;
import edu.icet.repository.AdditemRepositrory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdditemRepositroryImpl implements AdditemRepositrory {


    @Override
    public int addItem(AddItem item) throws SQLException {

        System.out.println(item);

        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into additem  values (?,?,?,?,?,?,?)");

        preparedStatement.setObject(1, item.getBarcode());
        preparedStatement.setObject(2, item.getName());
        preparedStatement.setObject(3, item.getBrand());
        preparedStatement.setObject(4, item.getDate());
        preparedStatement.setObject(5, item.getQuantity());
        preparedStatement.setObject(6, item.getPrice());
        preparedStatement.setObject(7, item.getSealing());

        return preparedStatement.executeUpdate();


    }


    public ResultSet getallItam() throws SQLException {

        PreparedStatement preparedStatement = getconnection().prepareStatement("select * from additem");
        return preparedStatement.executeQuery();

    }

    public int deleteItem(String bacode, String name) throws SQLException {

        PreparedStatement preparedStatement = getconnection().prepareStatement("delete  from additem where barcode = ? or name = ? ");

        preparedStatement.setObject(1, bacode);
        preparedStatement.setObject(2, name);

        return preparedStatement.executeUpdate();


    }

    public int updateItem(AddItem item) throws SQLException {

        PreparedStatement preparedStatement = getconnection().prepareStatement(" update  additem additem  set  barcode= ? , name= ? , brand= ? ,ExpierDate= ? ,qyt= ? ,price = ? , salingPrice = ?  where barcode= ? or name = ? ");

        preparedStatement.setObject(1,item.getBarcode());
        preparedStatement.setObject(2,item.getName());
        preparedStatement.setObject(3,item.getBrand());
        preparedStatement.setObject(4,item.getDate());
        preparedStatement.setObject(5,item.getQuantity());
        preparedStatement.setObject(6,item.getPrice());
        preparedStatement.setObject(7,item.getSealing());
        preparedStatement.setObject(8,item.getBarcode());
        preparedStatement.setObject(9,item.getName());

        return preparedStatement.executeUpdate();



    }


    private Connection getconnection() throws SQLException {
        
        return DBConnection.getDBConnection().getConnection();
        
        
    }




}
