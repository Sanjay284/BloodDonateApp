package com.BloodDonors.donors.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.BloodDonors.donors.model.DonorModel;
import com.BloodDonors.donors.repository.DonorRepository;
import com.BloodDonors.donors.service.DonorService;

@RestController
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	@Autowired
	private DonorRepository donorRepository;
	
	@PostMapping("/saveNewDonor")
	public DonorModel saveDonor(@RequestBody DonorModel donorModel) {
		return donorService.saveDonor(donorModel);
	}
	
	@GetMapping("/getAllDonor")
	public List<DonorModel> getDonor()  {
		return donorService.getDonor();
	}
	
	@GetMapping("/getDonorById/{id}")
	public DonorModel getDonorById(@PathVariable Long id) {
		return donorService.getDonorById(id, null);
	}
	@GetMapping("/getDonorByName/{name}")
	public DonorModel getDonorByName(@PathVariable String name) {
		return donorService.getDonorByName(name);
	}
	
	@GetMapping("/filterDonorByBloodGroup/{blood_Group}")
	@ResponseBody
	public List<DonorModel> donorByBloodGroup(@PathVariable("blood_Group") String bloodGroup) {
	    return donorRepository.findByBloodGroup(bloodGroup);
	}
	
	@PutMapping("/updateDonorById/{id}")
	public DonorModel updateDonor(@PathVariable ("id") long id, @RequestBody DonorModel donorModel) {
		return this.donorService.updateDonor(id, donorModel);
	}
	
	@DeleteMapping("/deleteDonorById/{id}")
	public void deleteDonor(@PathVariable Long id) {
		donorService.deleteDonor(id);
	}
	
	@Scheduled(cron = "*/15 * * * * *")
    public List<String> donorsInLast30Minutes() {
		List<String> donorsAddedInLast30Minutes = donorRepository.donorsInLast30Minutes();
		System.out.println("We have " + donorsAddedInLast30Minutes + " donors added in last 30 Minutes.");
		return donorsAddedInLast30Minutes;
    }
	
}