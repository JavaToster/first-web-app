package org.example.Backend.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetInfo {

    private static Statement statement = Connect.getConnection();

    public static boolean checkUsername(String username){
        try{
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS answer FROM users WHERE username = '"+username+"'");
            int count = 0;
            while(resultSet.next()){
                count = resultSet.getInt("answer");
            }

            if(count != 0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkPassword(String username, String password){
        try{
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS answer FROM users WHERE username = '"+username+"' AND password = '"+password+"'");
            int count = 0;
            while(resultSet.next()){
                count = resultSet.getInt("answer");
            }

            if(count != 0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public static String[] getNames(String username){
        try{
            ResultSet resultSet = statement.executeQuery("SELECT username, firstname, lastname FROM users WHERE username = '"+username+"'");

            String firstname = null;
            String lastname = null;
            while(resultSet.next()){
                firstname = resultSet.getString("firstname");
                lastname = resultSet.getString("lastname");
            }

            return new String[]{firstname, lastname};
        }catch (SQLException e){return null;}
    }
}
