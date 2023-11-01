package org.example.Frontend;

import org.example.Backend.Database.GetInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        Cookie[] cookies = req.getCookies();
        Cookie registerCookie = null;
        if(cookies != null) {
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("username")){
                    registerCookie = cookie;
                }
            }

            if(GetInfo.checkUsername(registerCookie.getValue())){
                dispatcher = req.getRequestDispatcher("/html/main-window.jsp");
                dispatcher.forward(req, resp);
            }else{
                resp.sendRedirect("/register");
            }
        }else{
            resp.sendRedirect("/register");
        }

    }
}
