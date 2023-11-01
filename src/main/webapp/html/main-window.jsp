<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="org.example.Backend.Weather.GetWeather" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Погода</title>
    <link rel="stylesheet" href="../css/main-window.css">
</head>
<body>
<header>
    <div class="header-left">
        <input type="text" id="city-input" placeholder="Input city">
        <button id="search-btn" onclick="toSearch()">Search</button>
        <div id="message"></div>
    </div>
    <div class="header-right">
        <% Cookie[] cookies = request.getCookies();
        String username = null;
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("username")){
                username = cookie.getValue();
                break;
            }
        }
        %>
        <label><%=username%></label>
       <!-- <h5 type="text" id="username"><%=username%></h5> -->
       <span class="spacer"></span>
       <button id="logout-btn" onclick="toOut()">Log Out</button>
       <button id="settings-btn" onclick="toSettings()">Settings</button>
    </div>
</header>
<main>
    <%
        String city = request.getParameter("city");
        String[] info = null;
        if(city == null){
            info = GetWeather.getInfoAboutWeather("Moscow");
        }else if(city.equals("")){
            info = GetWeather.getInfoAboutWeather("Moscow");
        }else{
            info = GetWeather.getInfoAboutWeather(city);
        }
    %>
    <h1 id="city-name"><%=info[4]%></h1>
    <div class="weather-info">
        <div class="info-item">
            <h2>Temperature:</h2>
            <div id="temperature"><%=info[1]+"°C"%></div>
        </div>
        <div class="info-item">
            <h2>Feels like:</h2>
            <div id="humidity"><%=info[2]+"°C" %></div>
        </div>
        <div class="info-item">
            <h2>Weather:</h2>
            <div id="description"><%=info[0]%></div>
        </div>
        <div class="info-item">
            <h2>Wind:</h2>
            <div id="pressure"><%= info[3] +"m/s"%></div>
        </div>
    </div>
</main>
<script src="../js/main-windows.js"></script>
</body>
</html>

