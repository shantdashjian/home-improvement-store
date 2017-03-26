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
	private String pass = "home";
	
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
		System.out.println("product");
		String sql = "Select id, name, price, category_id, description FROM product WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@SuppressWarnings("null")
	@Override
	public List<Stock> getInventory() {
	List<Stock> stocks = new ArrayList<>();
//name,price,quantity
		String sql = "SELECT p.id, p.name, p.price, p.category_id, p.description, s.quantity from product p JOIN stock s ON p.id = s.product_id";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product temp = new Product(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)); 
				Stock stock = new Stock(temp,rs.getInt(6));
				stocks.add(stock);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println(stocks);
		return stocks;
	}

	@Override
	public Product addProduct(Product product) {
		Product newProduct = null;

		String sql = "INSERT INTO product (name, price, category)" + " VALUES (?,?,?)";

		String sql2 = "SELECT LAST_INSERT_ID()";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(2, product.getName());
			stmt.setString(3, product.getPrice());
			stmt.setInt(4, product.getCategoryId());

			int uc = stmt.executeUpdate();
			if (uc > 0) {
				ResultSet rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					newProduct.setId(rs.getInt(1));
				}
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newProduct;
	}

	@Override
	public Product editProduct(Product product, Integer quantity) {

		String sql = "UPDATE product SET name = ?,  price = ?, categoryId = ?";

		String sql2 = "SELECT LAST_INSERT_ID()";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, product.getName());
			stmt.setString(2, product.getPrice());
			stmt.setInt(3, product.getCategoryId());

			int uc = stmt.executeUpdate();

			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public String deleteProduct(Integer id) {
		String response = null;
		String sqlDeleteFromStockTable = "DELETE FROM stock WHERE product_id = ?";
		String sqlDeleteFromProductTable = "DELETE FROM product WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sqlDeleteFromStockTable);
			stmt.setInt(1, id);
			int updateCountFromStock = stmt.executeUpdate();
			stmt = conn.prepareStatement(sqlDeleteFromProductTable);
			stmt.setInt(1, id);
			int updateCountFromProduct = stmt.executeUpdate();
			if (updateCountFromStock == 1 && updateCountFromProduct == 1) {
				response = "Product Deleted!";
			} else {
				response = "No Product Found!";
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			response = "Unable to delete PRODUCT for reasons unknown!";
		}
		return response;
	}

	@Override
	public String updateStockById(Integer id, Integer amount) {
		String response = null;
		String sql = "UPDATE product SET quantity = ?";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, amount);

			int uc = stmt.executeUpdate();
			if (uc > 0) {
				response = "Quantity in stock: " + amount;
			}
			else {
				response = "Unable to update inventory!";
			}

			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public int getStockById(Integer id) {
		Integer quantity = 0;

		String sql = "Select quantity FROM stock WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				quantity = rs.getInt(1);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}
}