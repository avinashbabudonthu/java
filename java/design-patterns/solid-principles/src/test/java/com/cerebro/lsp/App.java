package com.cerebro.lsp;

public class App {

	public static void main(String[] args) {
		Vehicle v = new ElectricCar();
		v.speedUp();
		v.fuel();

		v = new PetrolCar();
		v.speedUp();
		v.fuel();
	}
}
