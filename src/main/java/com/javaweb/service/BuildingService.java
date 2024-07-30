package com.javaweb.service;

import java.util.List;

import com.javaweb.models.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(String name, Long districtId);
}
