package com.javaweb.models.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingRequestDTO {
	String name;
	String ward;
	String street;
	Long districtId;
	int basement_number;
	Double floor_area;
}
