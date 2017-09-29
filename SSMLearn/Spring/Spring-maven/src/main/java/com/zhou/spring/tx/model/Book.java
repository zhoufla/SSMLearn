package com.zhou.spring.tx.model;

public class Book {
	private String bookId;
	private double price;
	private String name;
	
	public Book() {
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", price=" + price + ", name=" + name + "]";
	}

}
