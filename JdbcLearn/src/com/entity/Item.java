package com.entity;

public class Item {
	private int id;// 商品编号
	private double price;// 价格
	private int number;// 数量
	private String picture;// 商品图片
	private String name;// 商品名称
	private String city;// 产地

	public int getId() {
		return id;
	}

	public Item() {
	}

	@Override
	public String toString() {
		return this.getId() + "," + this.getName() + "," + this.getCity() + "," + this.getPrice() + ","
				+ this.getNumber() + "," + this.getPicture();
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
