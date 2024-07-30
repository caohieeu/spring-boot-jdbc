package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.models.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findAll(String name, Long districtId) {
		List<BuildingDTO> listBuilding = new ArrayList<>();
		List<BuildingEntity> items = buildingRepository.findAll(name, districtId);
		for(BuildingEntity item : items) {
			BuildingDTO building = new BuildingDTO();
			building.setId(item.getId());
			building.setName(item.getName());
			building.setAddress(item.getStreet() + ", " + item.getWard());
			building.setFloor_area(item.getFloor_area());
			building.setRent_cost(item.getRent_cost());
			building.setPrice_description(item.getPrice_description());
			
			listBuilding.add(building);
		}
		return listBuilding;
	}

}
