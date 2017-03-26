package com.sd.homeimprovementstore.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HomeDAODBImpl implements HomeDAO {
	private static String url = "jdbc:mysql://localhost:3306/homeimprovementstore";
	private String user = "homeUser";
	private String password = "home";

	public HomeDAODBImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}

	@Override
	public Product getProductById(Integer id) {
		Product product = null;
		String sql = "SELECT id, name, price, category_id, description "
					+ "FROM product WHERE id = ?";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				product = new Product(resultSet.getInt(1), resultSet.getString(2)
							, resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Stock> getInventory() {
		List<Stock> stocks = new ArrayList<>();
		String sql = "SELECT p.id, p.name, p.price, p.category_id, p.description"
				+ ", s.quantity FROM product p JOIN stock s ON p.id = s.product_id";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Product tempProduct = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4),
						resultSet.getString(5));
				Stock tempStock = new Stock(tempProduct, resultSet.getInt(6));
				stocks.add(tempStock);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stocks;
	}

	@Override
	public Product addProduct(Product product, Stock stock) {		
		Product newProduct = null;
		String sqlToInsertProduct = "INSERT INTO product (name, price, category_id, description)" 
						+ " VALUES (?,?,?,?)";
		String sqlToInsertStock = "INSERT INTO stock (product_id, quantity) VALUES (?,?)";
		String sqlToGetId = "SELECT LAST_INSERT_ID()";

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sqlToInsertProduct);

			statement.setString(1, product.getName());
			statement.setString(2, product.getPrice());
			statement.setInt(3, product.getCategoryId());
			statement.setString(4, product.getDescription());
			int updateCount = statement.executeUpdate();
			statement = connection.prepareStatement(sqlToGetId);			
			if (updateCount == 1) {
				ResultSet resultSet = statement.executeQuery(sqlToGetId);
				if (resultSet.next()) {
					newProduct = product;
					newProduct.setId(resultSet.getInt(1));
				}
				statement = connection.prepareStatement(sqlToInsertStock);
				statement.setInt(1, product.getId());
				statement.setInt(2, stock.getQuantity());
				statement.executeUpdate();
				resultSet.close();
			}
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newProduct;
	}
	
	@Override
	public Product editProduct(Product product, Stock stock) {
		Product updatedProduct = null;
		String sqlToUpdateProduct = "UPDATE product set name=?, price=?, category_id=?"
						+ ", description=? WHERE id=?"; 			

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sqlToUpdateProduct);

			statement.setString(1, product.getName());
			statement.setString(2, product.getPrice());
			statement.setInt(3, product.getCategoryId());
			statement.setString(4, product.getDescription());
			statement.setInt(5, product.getId());
			
			int updateCount = statement.executeUpdate();			
			if (updateCount == 1) {				
				updatedProduct = product;
				updateStockById(product.getId(), stock.getQuantity());
			}
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return updatedProduct;
	}

	@Override
	public String deleteProduct(Integer id) {
		String response = null;
		String sqlDeleteFromStockTable = "DELETE FROM stock WHERE product_id = ?";
		String sqlDeleteFromProductTable = "DELETE FROM product WHERE id = ?";

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sqlDeleteFromStockTable);
			statement.setInt(1, id);
			int updateCountFromStock = statement.executeUpdate();
			statement = connection.prepareStatement(sqlDeleteFromProductTable);
			statement.setInt(1, id);
			int updateCountFromProduct = statement.executeUpdate();
			if (updateCountFromStock == 1 && updateCountFromProduct == 1) {
				response = "Product Deleted!";
			} else {
				response = "No Product Found!";
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			response = "Unable to delete PRODUCT for reasons unknown!";
		}
		return response;
	}

	@Override
	public boolean updateStockById(Integer id, Integer quantity) {
		boolean result = false;
		String sql = "UPDATE stock set quantity=? WHERE product_id=?";

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, quantity);
			statement.setInt(2, id);

			int updateCount = statement.executeUpdate();
			if (updateCount == 1) {
				result = true;
			} else {
				result = false;
			}

			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Stock getStockById(Integer id) {
		Stock stock = new Stock();
		String sql = "SELECT quantity FROM stock WHERE product_id = ?";

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				stock.setQuantity(resultSet.getInt(1));
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stock;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<>();
		String sql = "SELECT category.id, category.name, category.description "
				+ "FROM category";

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				categories.add(category);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
}