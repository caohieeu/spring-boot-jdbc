package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
		
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder
				.Builder()
				.setName(MapUtil.getObject(params, "name", String.class))
				.setFloor_area(MapUtil.getObject(params, "floor_area", Double.class))
				.setWard(MapUtil.getObject(params, "ward", String.class))
				.setDistrictId(MapUtil.getObject(params, "district_id", Long.class))
				.setBasement_number(MapUtil.getObject(params, "basement_number", Integer.class))
				.setTypeCode(typeCode)
				.setManagerName(MapUtil.getObject(params, "managerName", String.class))
				.setManagerPhoneNumber(MapUtil.getObject(params, "managerPhoneNumber", String.class))
				.setRentPriceFrom(MapUtil.getObject(params, "rentPriceFrom", Double.class))
				.setRentPriceTo(MapUtil.getObject(params, "rentPriceTo", Double.class))
				.setAreaFrom(MapUtil.getObject(params, "areaFrom", Double.class))
				.setAreaTo(MapUtil.getObject(params, "areaTo", Double.class))
				.setStaffId(MapUtil.getObject(params, "staffId", Long.class))
				.build();
		
		return buildingSearchBuilder;
	}
}
