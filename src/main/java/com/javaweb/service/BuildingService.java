package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.models.BuildingDTO;
import com.javaweb.models.request.BuildingRequestDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode);
	
	void insertBuilding(BuildingRequestDTO buildingRequestDTO);
	
	void deleteBuilding(Long buildingId);
	
	void updateBuilding(BuildingRequestDTO buildingRequestDTO);
}
