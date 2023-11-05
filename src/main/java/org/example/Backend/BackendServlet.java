package org.example.Backend;

import org.apache.commons.io.IOUtils;
import org.example.Backend.Database.GetInfo;
import org.example.Backend.Database.Updates;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BackendServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = IOUtils.toString(req.getInputStream(), "UTF-8");
        PrintWriter out = resp.getWriter();

        JSONObject object = new JSONObject(data);
        String type = object.getString("type");
        //1. registration
        //2. loginning
        //3. delete account
        //4. new name
        //5. new surname
        if(type.equals("1")){
            String username = object.getString("username");
            if (GetInfo.checkUsername(username)) {
                object = new JSONObject().put("state", 200);
                object.put("username", "true");
            } else {
                String firstname = object.getString("firstname");
                String lastname = object.getString("lastname");
                String phone = object.getString("phone");
                String password = object.getString("password");
                Updates.singUp(username, firstname, lastname, phone, password);
                object = new JSONObject();
                object.put("state", 200);
                object.put("username", "false");
            }
        }else if(type.equals("2")){
            String username = object.getString("username");
            String password = object.getString("password");
            if(GetInfo.checkUsername(username) & GetInfo.checkPassword(username, password)){
                object = new JSONObject();
                object.put("state", 200);
                object.put("username", "true");
                object.put("password", "true");
            }else if(GetInfo.checkUsername(username)){
                object = new JSONObject();
                object.put("username", "true");
                object.put("password", "false");
            }else{
                object = new JSONObject();
                object.put("username", "false");
                object.put("password", "false");
            }
        }else if(type.equals("3")){
            object.put("state", 200);
            String username = object.getString("username");
            Updates.deleteAccount(username);
        }else if(type.equals("4")){
            String username = object.getString("username");
            String newFirstname = object.getString("new-firstname");
            if(GetInfo.checkUsername(username)){
                object = new JSONObject();
                object.put("state", 200);
                Updates.changeName(username, newFirstname);
            }else{
                object = new JSONObject();
                object.put("state", 500);
            }
        }else if(type.equals("5")){
            String username = object.getString("username");
            String newLastname = object.getString("new-lastname");
            if(GetInfo.checkUsername(username)){
                object = new JSONObject();
                object.put("state", 200);
                Updates.changeLastname(username, newLastname);
            }else{
                object = new JSONObject();
                object.put("state", 500);
            }
        }
        out.println(object.toString());
        out.flush();
        out.close();
    }
}
