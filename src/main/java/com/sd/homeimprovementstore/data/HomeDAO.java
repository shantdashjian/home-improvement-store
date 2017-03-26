package com.sd.homeimprovementstore.data;

import java.util.List;

public interface HomeDAO {

	List<Stock> getInventory();
	Product getProductById(Integer id);
	Product addProduct(Product product, Stock stock);
	Product editProduct(Product product, Integer quantity);
	String deleteProduct(Integer id);
	int getStockById(Integer id);
	String updateStockById(Integer id, Integer amount);
	List<Category> getCategories();
}
