package org.example.Backend.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private static final String url = "****";
    private static final String user = "****";
    private static final String password = "****";

    public static Statement getConnection(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
