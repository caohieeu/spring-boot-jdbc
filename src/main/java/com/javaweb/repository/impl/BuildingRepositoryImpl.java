package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/building";
	private static final String USER = "root";
	private static String PASS = "123123az";
	
	@Override
	public ArrayList<BuildingEntity> findAll(String name, Long districtId) {
		StringBuilder query = new StringBuilder("SELECT * FROM building b WHERE 1 = 1");
		
		if(name != null && !name.equals("")) {
			query.append(" AND name like '%" + name + "%'");
		}
		
		if(districtId != null) {
			query.append(" AND district_id = " + districtId);
		}
		
		ArrayList<BuildingEntity> result = new ArrayList<>(); 
		try(
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query.toString());
				) {
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getInt("id"));
				buildingEntity.setName(rs.getString("name"));
				//buildingEntity.setDistrict_id(rs.getInt("district_id"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setBasement_number(rs.getInt("basement_number"));
				buildingEntity.setFloor_area(rs.getDouble("floor_area"));
				buildingEntity.setRent_cost(rs.getDouble("rent_cost"));
				buildingEntity.setPrice_description(rs.getString("price_description"));
				
				result.add(buildingEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return result;
	}
	
}
	