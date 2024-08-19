package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "building")
public class BuildingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String name;
	
	@Column
	String ward;
	
	@Column
	String street;
	
	@Column
	String structure;
	
	@Column
	String basement_number;
	
	@Column
	Double floor_area;
	
	@Column
	Double rent_cost;
	
	@Column
	String price_description;
	
	@Column
	Double service_charge;
	
	@Column
	Double car_fee;
	
	@Column
	Double motor_fee;
	
	@Column
	Double overtime_fee;
	
	@Column
	Double electricity_fee;
	
	@Column
	Double deposit;
	
	@Column
	Double payment;
	
	@Column
	Long rental_term;
	
	@Column
	Long decoration_time;
	
	@Column
	String manager_name;
	
	@Column
	String manager_phone_number;
	
	@Column
	Double emptyArea;
	
	@Column
	Double brokerage_fee;
	
	@Column
	String note;
	
	@ManyToOne
	@JoinColumn(name = "district_id")
	DistrictEntity district;
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	List<RentAreaEntity> listRentArea = new ArrayList<>();

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

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getBasement_number() {
		return basement_number;
	}

	public void setBasement_number(String basement_number) {
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

	public Double getService_charge() {
		return service_charge;
	}

	public void setService_charge(Double service_charge) {
		this.service_charge = service_charge;
	}

	public Double getCar_fee() {
		return car_fee;
	}

	public void setCar_fee(Double car_fee) {
		this.car_fee = car_fee;
	}

	public Double getMotor_fee() {
		return motor_fee;
	}

	public void setMotor_fee(Double motor_fee) {
		this.motor_fee = motor_fee;
	}

	public Double getOvertime_fee() {
		return overtime_fee;
	}

	public void setOvertime_fee(Double overtime_fee) {
		this.overtime_fee = overtime_fee;
	}

	public Double getElectricity_fee() {
		return electricity_fee;
	}

	public void setElectricity_fee(Double electricity_fee) {
		this.electricity_fee = electricity_fee;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Long getRental_term() {
		return rental_term;
	}

	public void setRental_term(Long rental_term) {
		this.rental_term = rental_term;
	}

	public Long getDecoration_time() {
		return decoration_time;
	}

	public void setDecoration_time(Long decoration_time) {
		this.decoration_time = decoration_time;
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

	public Double getEmptyArea() {
		return emptyArea;
	}

	public void setEmptyArea(Double emptyArea) {
		this.emptyArea = emptyArea;
	}

	public Double getBrokerage_fee() {
		return brokerage_fee;
	}

	public void setBrokerage_fee(Double brokerage_fee) {
		this.brokerage_fee = brokerage_fee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public List<RentAreaEntity> getListRentArea() {
		return listRentArea;
	}

	public void setListRentArea(List<RentAreaEntity> listRentArea) {
		this.listRentArea = listRentArea;
	}
	
}