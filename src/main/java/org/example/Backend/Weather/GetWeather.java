package org.example.Backend.Weather;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetWeather {
    public static String[] getInfoAboutWeather(String city){
        String[] info = new String[5];

        String json = toRequest(city);
        if(json == null){
            return null;
        }
        double lat = getLat(json);
        double lon = getLon(json);

        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=4b072aca9d9c9e8283d917b1912b1e93");
            URLConnection conn = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while((line = reader.readLine()) != null){
                content.append(line + "\n");
            }

            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        JSONObject object = new JSONObject(content.toString());
        String main = object.getJSONArray("weather").getJSONObject(0).getString("main");
        float temp = object.getJSONObject("main").getFloat("temp");
        float feelsLikeTemp = object.getJSONObject("main").getFloat("feels_like");
        float wind_speed = object.getJSONObject("wind").getFloat("speed");
        info[0] = main;
        info[1] = ""+Math.round(temp-274);
        info[2] = ""+Math.round(feelsLikeTemp-274);
        info[3] = ""+Math.round(wind_speed);
        info[4] = object.getString("name");

        return info;
    }

    public static double getLat(String json){
        JSONObject object = new JSONObject(json);

        return object.getDouble("lat");
    }

    public static double getLon(String json){
        JSONObject object = new JSONObject(json);

        return object.getDouble("lon");
    }
    public static String toRequest(String city){
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+"&appid=4b072aca9d9c9e8283d917b1912b1e93");
            URLConnection conn = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while((line = reader.readLine()) != null){
                content.append(line + "\n");
            }

            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        if(content.toString().substring(1, content.toString().length()-2).length() == 0){
            return null;
        }
        return content.toString().substring(1, content.toString().length()-2);
    }
}
