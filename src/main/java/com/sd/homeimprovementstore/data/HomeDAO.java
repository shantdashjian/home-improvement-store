package com.sd.homeimprovementstore.data;

import java.util.List;

public interface HomeDAO {

	List<Stock> getInventory();
	Product getProductById(Integer id);
	Product addProduct(Product product, Stock stock);
	Product editProduct(Product product, Stock stock);
	String deleteProduct(Integer id);
	Stock getStockById(Integer id);
	boolean updateStockById(Integer id, Integer amount);
	List<Category> getCategories();
}
