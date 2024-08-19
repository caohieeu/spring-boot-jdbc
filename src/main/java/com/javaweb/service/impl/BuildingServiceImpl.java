package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.models.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DisctrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	
	@Override
	public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		List<BuildingDTO> listBuilding = new ArrayList<>();
		List<BuildingEntity> items = buildingRepository.findAll(
				buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode), typeCode
		);
		for(BuildingEntity item : items) { 
			BuildingDTO building = buildingDTOConverter.toBuildingDTO(item);
			
			listBuilding.add(building);
		}
		return listBuilding;
	}

}
