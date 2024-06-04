package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentWeatherDisplay implements Display, Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println("CURRENT WEATHER DATA " + formattedDateTime);
        System.out.println("Current temperature: " + temperature + "℃");
        System.out.println("Current humidity: " + humidity + "%");
        System.out.println("Current pressure: " + pressure + "hPa");
        System.out.println("\n");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }
}
