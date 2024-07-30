package com.javaweb.models;

public class BuildingDTO {
	private Integer id;
	private String name;
	//private Integer district_id;
	private String address;
	private Integer basement_number;
	private Double floor_area;
	private Double rent_cost;
	private String price_description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Integer getDistrict_id() {
//		return district_id;
//	}
//	public void setDistrict_id(Integer district_id) {
//		this.district_id = district_id;
//	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getBasement_number() {
		return basement_number;
	}
	public void setBasement_number(Integer basement_number) {
		this.basement_number = basement_number;
	}
	public Double getFloor_area() {
		return floor_area;
	}
	public void setFloor_area(Double floor_area) {
		this.floor_area = floor_area;
	}
	public Double getRent_cost() {
		return rent_cost;
	}
	public void setRent_cost(Double rent_cost) {
		this.rent_cost = rent_cost;
	}
	public String getPrice_description() {
		return price_description;
	}
	public void setPrice_description(String price_description) {
		this.price_description = price_description;
	}
	
}
