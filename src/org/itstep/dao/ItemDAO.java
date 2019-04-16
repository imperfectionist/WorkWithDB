package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.itstep.model.Item;

public class ItemDAO {
	
	public static void create(Item item) {
		
		try (Connection connection = ConnectionDB.getConnection()) {
			
			String sql = "INSERT INTO items (asin, name, url, img_url, price, init_price) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, item.getAsin());
			statement.setString(2, item.getName());
			statement.setString(3, item.getItemUrl());
			statement.setString(4, item.getImgUrl());
			statement.setInt(5, item.getPrice());
			statement.setInt(6, item.getInitPrice());
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Item find(Integer id) {
		
		try (Connection connection = ConnectionDB.getConnection()) {
			
			String sql = "SELECT * FROM items WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet rSet = statement.executeQuery();
			
			while(rSet.next()) {
				Item item = new Item();
				item.setId(rSet.getInt("id"));
				item.setAsin(rSet.getString("asin"));
				item.setItemUrl(rSet.getString("url"));
				item.setImgUrl(rSet.getString("img_url"));
				item.setPrice(rSet.getInt("price"));
				item.setInitPrice(rSet.getInt("init_price"));
				return item;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void update(Item item) {
		
		try (Connection connection = ConnectionDB.getConnection()) {
			
			String sql = "UPDATE items SET asin = ?, name = ?, url = ?, img_url = ?, price = ?, init_price = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, item.getAsin());
			statement.setString(2, item.getName());
			statement.setString(3, item.getItemUrl());
			statement.setString(4, item.getImgUrl());
			statement.setInt(5, item.getPrice());
			statement.setInt(6, item.getInitPrice());
			statement.setInt(7, item.getId());
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void delete(Integer id) {
		try (Connection connection = ConnectionDB.getConnection()) {
			
			String sql = "DELETE items WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
