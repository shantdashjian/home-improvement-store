package com.sd.homeimprovementstore.data;

import java.util.List;

public interface HomeDAO {

	List<Product> getInventory();
	Product getProductById(Integer id);
	Product addProduct(Product product);
	Product editProduct(Product product);
	String deleteProduct(Integer id);
	int getStockById(Integer id);
	String updateStockById(Integer id, Integer amount);
}
