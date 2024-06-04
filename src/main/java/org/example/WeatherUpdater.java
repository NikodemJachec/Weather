package org.example;

public class WeatherUpdater implements Runnable {
    private WeatherData weatherData;

    public WeatherUpdater(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void run() {
        while (true) {
            weatherData.fetchWeatherData();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}