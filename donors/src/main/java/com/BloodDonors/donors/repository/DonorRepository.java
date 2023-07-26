package com.BloodDonors.donors.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.BloodDonors.donors.model.DonorModel;
import com.BloodDonors.donors.pojo.DonorPojo;

public interface DonorRepository extends JpaRepository<DonorModel, Long> {

	DonorModel save(DonorPojo donorPojo);

	DonorModel findByfirstName(String name);

	DonorModel findByid(Long id);

	@Query(value="select * from donor_model WHERE donor_model.blood_group =:key1", nativeQuery=true)
	List<DonorModel> findByBloodGroup(@Param("key1") String bloodGroup); 

	@Query(value ="SELECT donor_model.blood_group FROM donor_model where (date_blood1 > (now() - interval 30 minute))", nativeQuery=true)
	List<String> donorsInLast30Minutes();
	
}