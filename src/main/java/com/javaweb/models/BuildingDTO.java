package com.javaweb.models;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingDTO {
	Long id;
	String name;
	String address;
	String manager_name;
	String manager_phone_number;
	Double floor_area;
	String rentarea;
	Double empty_area;
	Double rent_cost;
	Double service_charge;
	Double brokerage_fee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_phone_number() {
		return manager_phone_number;
	}
	public void setManager_phone_number(String manager_phone_number) {
		this.manager_phone_number = manager_phone_number;
	}
	public Double getFloor_area() {
		return floor_area;
	}
	public void setFloor_area(Double floor_area) {
		this.floor_area = floor_area;
	}
	public String getRentarea() {
		return rentarea;
	}
	public void setRentarea(String rentarea) {
		this.rentarea = rentarea;
	}
	public Double getEmpty_area() {
		return empty_area;
	}
	public void setEmpty_area(Double empty_area) {
		this.empty_area = empty_area;
	}
	public Double getRent_cost() {
		return rent_cost;
	}
	public void setRent_cost(Double rent_cost) {
		this.rent_cost = rent_cost;
	}
	public Double getService_charge() {
		return service_charge;
	}
	public void setService_charge(Double service_charge) {
		this.service_charge = service_charge;
	}
	public Double getBrokerage_fee() {
		return brokerage_fee;
	}
	public void setBrokerage_fee(Double brokerage_fee) {
		this.brokerage_fee = brokerage_fee;
	}
	
}
