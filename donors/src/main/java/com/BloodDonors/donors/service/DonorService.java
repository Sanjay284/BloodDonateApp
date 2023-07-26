package com.BloodDonors.donors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BloodDonors.donors.model.DonorModel;
import com.BloodDonors.donors.repository.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository donorRepository;

	public DonorModel saveDonor(DonorModel donorModel) {
		return donorRepository.save(donorModel);
	}
	
	public List<DonorModel> getDonor() {
		return donorRepository.findAll();
	}
	
	public DonorModel getDonorById(Long id, DonorModel donorModel) {
		
		Optional<DonorModel> donorModelById1= this.donorRepository.findById(id);
        if(donorModelById1.isPresent())
        {
        	return donorRepository.findByid(id);
        }else {
        	System.out.println("Donor id is not exist");
        }
        return null;
	}
	
	public DonorModel getDonorByName(String name) {
		return donorRepository.findByfirstName(name);
	}

	public DonorModel updateDonor(long id, DonorModel donorModel) {
		Optional<DonorModel> donorModelById= this.donorRepository.findById(id);
        if(donorModelById.isPresent())
        {
          DonorModel donorData=donorModelById.get();
          donorData.setAddress(donorModel.getAddress());
          donorData.setAge(donorModel.getAge());
          donorData.setContactNumber(donorModel.getContactNumber());
          return this.donorRepository.save(donorData);
        }
      
      return null;
	}

	public void deleteDonor(Long id) {
		donorRepository.deleteById(id);
		System.out.println("Donor id "+ id + " is deleted");
	}
}
