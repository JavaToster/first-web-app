package org.example.Backend.Database;

import java.sql.SQLException;
import java.sql.Statement;

public class Updates {
    private static final Statement statement = Connect.getConnection();

    public static void singUp(String username, String firstname, String lastname, String phone, String password){
        toExecute("INSERT INTO users(username, firstname, lastname, phone, password) VALUES ('"+username+"', '"+firstname+"', '"+lastname+"', "+phone+", '"+password+"')");
    }

    public static void changeName(String username, String newFirstame){
        toExecuteUpdate("UPDATE users SET firstname = '"+newFirstame+"' WHERE username = '"+username+"'");
    }

    public static void changeLastname(String username, String newLastname){
        toExecuteUpdate("UPDATE users SET lastname = '"+newLastname+"' WHERE username = '"+username+"'");
    }

    public static void deleteAccount(String username){
        toExecute("DELETE FROM users WHERE username='"+username+"'");
    }

    public static void toExecute(String sql){
        try{
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void toExecuteUpdate(String sql){
        try{
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
