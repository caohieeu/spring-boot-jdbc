package com.javaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Component;

public interface MyConnection {

	public Connection open();
	
	public void close();
	
	public ResultSet executeQuery(String sql);
	
	public int executeUpdate(String sql);
}
