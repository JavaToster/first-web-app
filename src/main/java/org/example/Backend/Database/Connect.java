package org.example.Backend.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private static final String url = "jdbc:postgresql://localhost:5432/web";
    private static final String user = "postgres";
    private static final String password = "1111";

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
