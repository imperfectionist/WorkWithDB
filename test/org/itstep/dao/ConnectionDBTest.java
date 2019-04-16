package org.itstep.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ConnectionDBTest {

	@Test
	void testGetConnection() {
		Connection connection = ConnectionDB.getConnection();
		assertNotNull(connection);
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
