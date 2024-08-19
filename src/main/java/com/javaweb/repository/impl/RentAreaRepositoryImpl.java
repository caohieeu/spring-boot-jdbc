package com.javaweb.repository.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaweb.dao.MyConnection;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.RentAreaEntity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentAreaRepositoryImpl implements RentAreaRepository{

	@Autowired
	MyConnection conn;
	
	@Override
	public List<RentAreaEntity> findAreaByBuildingId(Long id) {

		List<RentAreaEntity> listRentArea = new ArrayList<>();
		try {
			conn.open();
			
			StringBuilder query = new StringBuilder("SELECT * FROM rentarea r"
					+ " WHERE r.building_id = " + id);
			ResultSet rs = conn.executeQuery(query.toString());
			
			while(rs.next()) {
				RentAreaEntity r = new RentAreaEntity();
				r.setId(rs.getLong("id"));
				r.setValue(rs.getDouble("value"));
				r.setBuilding_id(rs.getLong("building_id"));
				
				listRentArea.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conn.close();
		return listRentArea;
	}

}
