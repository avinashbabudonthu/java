package com.cerebro.ocp;

import java.util.ArrayList;
import java.util.List;

public class SortProcessor {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();

		Sort sort = new InsertionSort();
		sort.sort(numbers);

		sort = new SelectionSort();
		sort.sort(numbers);

		sort = new MergeSort();
		sort.sort(numbers);
	}

}