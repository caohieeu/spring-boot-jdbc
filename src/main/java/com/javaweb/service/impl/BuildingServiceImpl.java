package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.exception.AppException;
import com.javaweb.exception.ErrorCode;
import com.javaweb.models.BuildingDTO;
import com.javaweb.models.request.BuildingRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DisctrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.service.BuildingService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	BuildingRepository buildingRepository;
	@Autowired
	BuildingDTOConverter buildingDTOConverter;
	@Autowired
	BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@PersistenceContext
	EntityManager entityManager;
	
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
	
	@Override
	public void insertBuilding(BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = buildingRepository.findByName(buildingRequestDTO.getName());
		
		if(buildingEntity != null) {
			throw new AppException(ErrorCode.BUILDING_CONFLICT);
		}
		
		buildingRepository.insertBuilding(buildingRequestDTO);
	}

	@Override
	public void deleteBuilding(Long buildingId) {
		BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, buildingId);
		
		if(buildingEntity == null) {
			throw new AppException(ErrorCode.BUILDING_NOT_FOUND);
		}
		
		buildingRepository.deleteBuilding(buildingEntity);
	}

	@Override
	public void updateBuilding(BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = buildingRepository.findByName(buildingRequestDTO.getName());
		
		if(buildingEntity == null) {
			throw new AppException(ErrorCode.BUILDING_NOT_FOUND);
		}
		
		DistrictEntity districtEntity = new DistrictEntity();
		districtEntity.setId(buildingRequestDTO.getDistrictId());
		BuildingEntity buildingUpdate = BuildingEntity.builder()
				.id(buildingEntity.getId())
				.name(buildingRequestDTO.getName())
				.ward(buildingRequestDTO.getWard())
				.street(buildingRequestDTO.getStreet())
				.district(districtEntity)
				.basement_number(buildingRequestDTO.getBasement_number())
				.floor_area(buildingRequestDTO.getFloor_area())
				.build();
				
		buildingRepository.updateBuilding(buildingUpdate);
	}
}
