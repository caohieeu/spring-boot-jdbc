package com.javaweb.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaweb.dao.MyConnection;
import com.javaweb.repository.DisctrictRepository;
import com.javaweb.repository.entity.DistrictEntity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DistrictRepositoryImpl {

//	@Autowired
//	MyConnection conn;
//	
//	@Override
//	public DistrictEntity findNameById(Long id) {
//		
//		DistrictEntity districtEntity = new DistrictEntity();
//		try {
//			conn.open();
//			
//			StringBuilder query = new StringBuilder("SELECT * FROM district WHERE id=" + id);
//			
//			ResultSet rs = conn.executeQuery(query.toString());
//			
//			while(rs.next()) {
//				districtEntity.setId(rs.getLong("id"));
//				districtEntity.setName(rs.getString("name"));
//				districtEntity.setCode(rs.getString("code"));
//			}
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
//		
//		conn.close();
//		return districtEntity;
//	}
	
}
