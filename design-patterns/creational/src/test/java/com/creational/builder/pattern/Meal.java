package com.creational.builder.pattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public double getPrice() {
		return items.stream().mapToDouble(Item::price).sum();
	}

	public void display() {
		items.stream().forEach(item -> System.out
				.println("name=" + item.name() + ", packing=" + item.packing().pack() + ", price=" + item.price()));
	}
}