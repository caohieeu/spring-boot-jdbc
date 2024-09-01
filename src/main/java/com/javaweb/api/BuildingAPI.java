package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.exception.FieldRequiredException;
import com.javaweb.models.Building;
import com.javaweb.models.BuildingDTO;
import com.javaweb.models.ErrorResponseDTO;
import com.javaweb.models.request.BuildingRequestDTO;
import com.javaweb.models.response.ApiResponse;
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
				@RequestParam Map<String, Object> params,
				@RequestParam(value = "typeCode", required = false) List<String> typeCode
			) {
		return buildingService.findAll(params, typeCode);
	}
	
	@PostMapping("/building")
	public ResponseEntity<?> createBuilding (
				@RequestBody BuildingRequestDTO buildingRequestDTO
			) {
		buildingService.insertBuilding(buildingRequestDTO);
		return ResponseEntity.ok().body("Created");
	}
	
	@PutMapping("/building")
	public ResponseEntity<?> updateBuilding (
				@RequestBody BuildingRequestDTO BuildingRequestDTO
			) {
		buildingService.updateBuilding(BuildingRequestDTO);
		return ResponseEntity.ok().body("Updated");
	}
	
	@DeleteMapping("/building/delete/{buildingId}")
	public ResponseEntity<?> deleteBuilding(
				@PathVariable("buildingId") Long buildingId
			) {
		
		buildingService.deleteBuilding(buildingId);
		return ResponseEntity.ok().body("Deleted");
	}
}
