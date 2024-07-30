package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.exception.FieldRequiredException;
import com.javaweb.models.Building;
import com.javaweb.models.BuildingDTO;
import com.javaweb.models.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

@RestController
@RequestMapping("/api/v1")
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	void validate(Building building) {
		if(building.getName() == null || building.getName().equals("") ||
				building.getFloor() == null) {
			throw new FieldRequiredException("Name or floor is null!");
		}
	}
	
	@GetMapping("/building")
	public List<BuildingDTO> getBuilding(
				@RequestParam(value="name", required = false) String name,
				@RequestParam(value="districtId", required = false) Long districtId,
				@RequestParam(value = "typeCode", required = false) List<String> typeCode
			) {
		return buildingService.findAll(name, districtId);
	}
}
