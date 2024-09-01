package com.javaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.exception.AppException;
import com.javaweb.exception.ErrorCode;
import com.javaweb.models.request.BuildingRequestDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;

@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, List<String> typeCode) {
//		String sql = "FROM BuildingEntity b ";
//		Query query = entityManager.createQuery(sql, BuildingEntity.class);
		
		String sql = "SELECT * FROM building";
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
		return query.getResultList();
	}

	@Override
	public BuildingEntity findByName(String name) {
		try {
			String sql = "SELECT * FROM building where name = :name";
			Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
			query.setParameter("name", name);
			return (BuildingEntity) query.getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional
	public void insertBuilding(BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(buildingRequestDTO.getName());
		buildingEntity.setWard(buildingRequestDTO.getWard());
		buildingEntity.setStreet(buildingRequestDTO.getStreet());
		DistrictEntity districtEntity = new DistrictEntity();
		districtEntity.setId(buildingRequestDTO.getDistrictId());
		buildingEntity.setDistrict(districtEntity);
		buildingEntity.setBasement_number(buildingRequestDTO.getBasement_number());
		buildingEntity.setFloor_area(buildingRequestDTO.getFloor_area());
		entityManager.persist(buildingEntity);
	}

	@Override
	@Transactional
	public void deleteBuilding(BuildingEntity buildingEntity) {
		entityManager.remove(buildingEntity);
	}

	@Override
	@Transactional
	public void updateBuilding(BuildingEntity buildingEntity) {
		entityManager.merge(buildingEntity);
	}
	
}
