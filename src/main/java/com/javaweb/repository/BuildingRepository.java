package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.models.request.BuildingRequestDTO;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, List<String> typeCode);
	
	@Transactional
	public void insertBuilding(BuildingRequestDTO buildingRequestDTO);
	
	@Transactional
	public void deleteBuilding(BuildingEntity buildingEntity);
	
	@Transactional
	public void updateBuilding(BuildingEntity buildingEntity);
	
	public BuildingEntity findByName(String name);
}
