package com.behavioral.pattern.template;

public abstract class Algorithm {

	protected int[] nums;

	public Algorithm(int[] nums) {
		this.nums = nums;
	}

	protected abstract void initialize();

	protected abstract void sorting();

	protected abstract void print();

	// template pattern
	public void sort() {
		initialize();
		sorting();
		print();
	}
}