package com.behavioral.pattern.observer;

public class App {

	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		WeatherObserver weatherObserver = new WeatherObserver(weatherStation);
		weatherStation.setValue1(100);
		weatherStation.setValue2(200);
		weatherStation.setValue3(300);
	}
}
