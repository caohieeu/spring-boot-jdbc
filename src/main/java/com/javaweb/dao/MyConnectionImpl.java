package com.javaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyConnectionImpl implements MyConnection{

	static final String DB_URL = "jdbc:mysql://localhost:3306/building";
	static final String USER = "root";
	static String PASS = "123123az";
	Connection conn;
	
	@Override
	public Connection open() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	@Override
	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public int executeUpdate(String sql) {
		int res = -1;
		try {
			Statement stm = conn.createStatement();
			res = stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
