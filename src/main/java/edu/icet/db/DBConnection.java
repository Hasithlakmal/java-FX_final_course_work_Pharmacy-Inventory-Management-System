package edu.icet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static  DBConnection  installDBConection;
    private final Connection connection;

    public DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pamacy","root","1236788");
    }

    public  Connection getConnection(){

        return  connection;

    }


    public static DBConnection  getDBConnection() throws SQLException {

        if (installDBConection==null){

            installDBConection=new DBConnection();

        }

        return installDBConection;

    }


}
