package com.behavioral.pattern.template;

public class App {

	public static void main(String[] args) {
		Algorithm selectionSort = new SelectionSort(new int[] { 1, 2, 3, 4, 5 });
		selectionSort.sort();

		Algorithm bubbleSort = new BubbleSort(new int[] { 1, 2, 3, 4, 5 });
		bubbleSort.sort();
	}
}
