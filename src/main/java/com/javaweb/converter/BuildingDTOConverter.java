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
	private ModelMapper modelMapper;
	
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		List<RentAreaEntity> listArea = item.getListRentArea();
		String strArea = listArea.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		 
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		building.setRentarea(strArea);
		building.setAddress(item.getStreet() + ", " + item.getWard() + ", " + item.getDistrict().getName());
		
		return building;
	}
}
