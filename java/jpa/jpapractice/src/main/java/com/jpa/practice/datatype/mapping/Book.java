package com.jpa.practice.datatype.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_BOOK")
public class Book {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "unit_cost")
	private Double unitCost;

	@Column(name = "isbn")
	private String isbn;

	public Book(Long id, String title, String description, Double unitCost, String isbn) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.isbn = isbn;
	}

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", unitCost=" + unitCost + ", isbn="
				+ isbn + "]";
	}

}