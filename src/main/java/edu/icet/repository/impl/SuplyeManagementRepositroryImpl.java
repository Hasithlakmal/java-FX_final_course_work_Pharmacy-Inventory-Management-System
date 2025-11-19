package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.Suply;
import edu.icet.repository.SuplyeManagementRepositrory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuplyeManagementRepositroryImpl  implements SuplyeManagementRepositrory {


    @Override
    public int addItem(Suply item) throws SQLException {

        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into supplier  values (?,?,?)");

        preparedStatement.setObject(1, item.getSumlyer());
        preparedStatement.setObject(2, item.getTel_no());
        preparedStatement.setObject(3, item.getBacode());


        return preparedStatement.executeUpdate();
    }

    @Override
    public ResultSet getallItam() throws SQLException {
        PreparedStatement preparedStatement = getconnection().prepareStatement("select * from supplier");
        return preparedStatement.executeQuery();
    }

    @Override
    public int updateItem(Suply item) throws SQLException {
        PreparedStatement preparedStatement = getconnection().prepareStatement(" update  supplier  set  supplier= ? , Tel_No= ?  where barcode= ?  ");

        preparedStatement.setObject(1,item.getSumlyer());
        preparedStatement.setObject(2,item.getTel_no());
        preparedStatement.setObject(3,item.getBacode());

        return preparedStatement.executeUpdate();



    }

    @Override
    public int deleteItem(String bacode) throws SQLException {
        PreparedStatement preparedStatement = getconnection().prepareStatement("delete  from supplier where barcode = ? ");

        preparedStatement.setObject(1, bacode);

        return preparedStatement.executeUpdate();
    }

    private Connection getconnection() throws SQLException {

        return DBConnection.getDBConnection().getConnection();


    }
}
