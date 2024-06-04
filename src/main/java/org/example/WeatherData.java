package org.example;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;

    private List<Observer> observers = new ArrayList<>();
    private String city;

    public WeatherData(String city) {
        this.city = city;
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void fetchWeatherData() {
        try {
            JsonObject weatherData = WeatherApiClient.getWeatherData(city);
            JsonObject main = weatherData.getAsJsonObject("main");
            synchronized (this) {
                temperature = main.get("temp").getAsFloat();
                humidity = main.get("humidity").getAsFloat();
                pressure = main.get("pressure").getAsFloat();
            }
            notifyObserver();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", observers=" + observers +
                '}';
    }
}