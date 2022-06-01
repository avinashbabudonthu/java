package com.behavioral.pattern.template;

public class BubbleSort extends Algorithm {

	public BubbleSort(int[] nums) {
		super(nums);
	}

	@Override
	protected void initialize() {
		System.out.println("initialize Bubble sort");
	}

	@Override
	protected void sorting() {
		System.out.println("sorting using Bubble sort");
	}

	@Override
	protected void print() {
		System.out.println("Bubble printing nums");
	}

}
