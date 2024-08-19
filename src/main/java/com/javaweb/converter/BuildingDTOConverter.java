package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.javaweb.models.BuildingDTO;
import com.javaweb.repository.DisctrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DisctrictRepository disctrictRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		DistrictEntity disctrict = disctrictRepository.findNameById(item.getDistrict_id());
		List<RentAreaEntity> listArea = rentAreaRepository.findAreaByBuildingId(item.getId());
		String strArea = listArea.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		 
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		building.setAddress(item.getStreet() + ", " + item.getWard() + ", " + disctrict.getName());
		
		return building;
	}
}
