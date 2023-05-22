package com.behavioral.pattern.template;

public class SelectionSort extends Algorithm {

	public SelectionSort(int[] nums) {
		super(nums);
	}

	@Override
	protected void initialize() {
		System.out.println("initialize selection sort");
	}

	@Override
	protected void sorting() {
		System.out.println("sorting using selection sort");
	}

	@Override
	protected void print() {
		System.out.println("selection printing nums");
	}

}
