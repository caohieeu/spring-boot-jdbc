package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.dao.MyConnection;
import com.javaweb.models.BuildingDTO;
import com.javaweb.models.request.BuildingRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JDBCBuildingRepositoryImpl implements BuildingRepository {

	@Autowired
	MyConnection conn;
	
	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, List<String>typeCode, StringBuilder sql) {
		if(!typeCode.isEmpty()) {
			sql.append(" JOIN buildingrenttype brt "
					+ "ON b.id = brt.building_id "
					+ "JOIN renttype rt "
					+ "ON rt.id = brt.renttype_id");
		}
		
		Long staffId = buildingSearchBuilder.getStaffId();
		if(staffId != null) {
			sql.append(" JOIN assignmentbuilding a ON a.building_id = b.id");
		}
	}
	
	public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
//		for(Map.Entry<String, Object> it : params.entrySet()) {
//			if(!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") &&
//					!it.getKey().startsWith("area") && !it.getKey().startsWith("rentPrice")) {
//				String value = it.getValue().toString();
//					
//				if(NumberUtil.isNumber(value)) {
//					where.append(" AND b." + it.getKey() + " = " + value);
//				}
//				else {
//					where.append(" AND b." + it.getKey() + " LIKE '%" + value + "%'");
//				}
//			}
//		}
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if(!fieldName.equals("staffId") && !fieldName.equals("typeCode") &&
						!fieldName.startsWith("area") && !fieldName.startsWith("rentPrice")) {
					Object value = item.get(buildingSearchBuilder);
						
					if(value != null) {
						if(item.getType().getName().equals(Integer.class) ||
								item.getType().getName().equals(Double.class) ||
								item.getType().getName().equals("java.lang.Long")) {
							where.append(" AND b." + fieldName + " = " + value);
						}
						else {
							where.append(" AND b." + fieldName + " LIKE '%" + value + "%'");
						}
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, List<String>typeCode, StringBuilder sql) {
		if(!typeCode.isEmpty()) { 
			sql.append(" AND rt.code in(" + typeCode.stream().map(it -> "'" + it + "'").collect(Collectors.joining(",")) + ")");
		}
		
		Double rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
		Double rentPriceTo = buildingSearchBuilder.getRentPriceTo();
		if(rentPriceFrom != null || rentPriceTo != null) {
			sql.append(" WHERE EXISTS(SELECT * FROM rentarea r WHERE r.building_id=b.id");
			
			if(rentPriceFrom != null) {
				sql.append(" AND r.value >= " + rentPriceFrom);
			}
			if(rentPriceTo != null) {
				sql.append(" AND r.value <= " + rentPriceTo);
			}
			sql.append(")");
		}
	}
	
	@Override
	public ArrayList<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, List<String> typeCode) {
		StringBuilder query = new StringBuilder("SELECT b.id, b.name, b.street, b.ward, b.district_id, b.basement_number,"
				+ "b.floor_area, b.manager_name, b.manager_phone_number, b.rent_cost, b.service_charge, "
				+ "b.brokerage_fee FROM building b");
		
		joinTable(buildingSearchBuilder, typeCode, query);
		StringBuilder where = new StringBuilder(" WHERE 1=1");
		queryNormal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder, typeCode, where);
		where.append(" GROUP BY b.id");
		query.append(where);
		System.out.println(query);
		ArrayList<BuildingEntity> result = new ArrayList<>(); 
		try {
			conn.open();
			ResultSet rs = conn.executeQuery(query.toString());
			
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getLong("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setStreet(rs.getString("street"));
				//buildingEntity.setDistrict_id(rs.getLong("district_id"));
				buildingEntity.setManager_name(rs.getString("manager_name"));
				buildingEntity.setManager_phone_number(rs.getString("manager_phone_number"));
				buildingEntity.setFloor_area(rs.getDouble("floor_area"));
				//buildingEntity.setEmptyArea(rs.getDouble("emptyArea"));
				buildingEntity.setRent_cost(rs.getDouble("rent_cost"));
				buildingEntity.setService_charge(rs.getDouble("service_charge"));
				buildingEntity.setBrokerage_fee(rs.getDouble("brokerage_fee"));
				
				result.add(buildingEntity);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		conn.close();
		return result;
	}

	@Override
	public void insertBuilding(BuildingRequestDTO buildingRequestDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBuilding(Long buildingId) {
		// TODO Auto-generated method stub
		
	}
	
}
	