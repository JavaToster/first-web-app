package org.example.Backend.Weather;

public class Test {
    public static void main(String[] args) {
        System.out.println(GetWeather.toRequest("efjiewjfk").length() == 0);
        System.out.println(GetWeather.toRequest("Moscow"));
    }
}
