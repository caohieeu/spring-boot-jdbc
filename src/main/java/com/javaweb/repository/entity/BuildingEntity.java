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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	int basement_number;
	
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
}