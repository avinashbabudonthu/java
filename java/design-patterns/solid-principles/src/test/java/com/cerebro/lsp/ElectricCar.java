package com.cerebro.lsp;

public class ElectricCar extends Vehicle {

	@Override
	protected void speedUp() {
		System.out.println("speeding up");
	}

	@Override
	public void fuel() {
		System.out.println("charging");
	}

}
