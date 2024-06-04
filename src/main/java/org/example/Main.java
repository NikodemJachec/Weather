package org.example;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData("Wrocław");
        CurrentWeatherDisplay currentWeatherDisplay = new CurrentWeatherDisplay();
        weatherData.registerObserver(currentWeatherDisplay);

        Thread weatherUpdaterThread = new Thread(new WeatherUpdater(weatherData));
        weatherUpdaterThread.start();

        while (true) {
            currentWeatherDisplay.display();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}