package com.cerebro.lsp;

public class PetrolCar extends Vehicle {

	@Override
	protected void speedUp() {
		System.out.println("speeding up");
	}

	@Override
	public void fuel() {
		System.out.println("fueling");
	}

}
