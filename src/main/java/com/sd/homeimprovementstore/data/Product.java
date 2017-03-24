package com.sd.homeimprovementstore.data;

public class Product {
	private Integer id;
	private String name;
	private String price;
	private Integer categoryId;
	
	public Product () {
		
	}

	public Product(Integer id, String name, String price, Integer categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", categoryId=" + categoryId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategory(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
}