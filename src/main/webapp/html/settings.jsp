<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.Backend.Database.GetInfo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Settings</title>
    <link rel="stylesheet" href=../css/settings.css>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    String username  = null;
    for(Cookie cookie: cookies){
        if(cookie.getName().equals("username")){
            username = cookie.getValue();
            break;
        }
    }

    String firstname = GetInfo.getNames(username)[0];
    String lastname = GetInfo.getNames(username)[1];
%>
<div class="container">
    <div class="form-group">
        <label>Username</label>
        <h3><%= username %></h3>
    </div>
    <div class="form-group">
        <label>Name</label>
        <h3><%= firstname %></h3>
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <h3><%= lastname %></h3>
    </div>
</div>
<div class="buttons">
    <div>
        <button class="danger" onclick="toDelete()">Delete account</button>
    </div>
    <div>
        <button class="danger" onclick="toChangeName()">Change name</button>
    </div>
    <div>
        <button class="danger" onclick="toChangeLastname()">Change last name</button>
    </div>
</div>
<div class="back-button">
    <button class="danger-back" onclick="toOut()">Back</button>
</div>
<script src="../js/settings.js"></script>
</body>
</html>