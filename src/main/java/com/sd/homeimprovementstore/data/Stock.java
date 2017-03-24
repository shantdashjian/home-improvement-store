package com.sd.homeimprovementstore.data;

public class Stock {
private Product product;
private Integer quantity;

public Stock(){}


public Stock(Product product, Integer quantity) {
	super();
	this.product = product;
	this.quantity = quantity;
}


public Product getProduct() {
	return product;
}


public void setProduct(Product product) {
	this.product = product;
}


public Integer getQuantity() {
	return quantity;
}


public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}



}
