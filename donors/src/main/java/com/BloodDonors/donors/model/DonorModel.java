package com.BloodDonors.donors.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "donor_model")
public class DonorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	@NotNull(message = "First Name Can not ne Null")
	@Size(min = 3, message = "First name must be 3 characters or more")
	private String firstName;

	@Size(min = 3, message = "Last name must be 3 characters or more")
	private String lastName;
	
	@Column(name="gender")
	@NotNull(message = "Gender Can not ne Null")
	private String gender;
	
	@Column(name="age")
	@NotNull(message = "Age Can not ne Null")
	private Integer age;
	
	@Column(name="bloodGroup")
	@NotNull(message = "Blood Group Can not ne Null")
	@Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Please Add valid Blood Group")
	private String bloodGroup;
	
	@Column(name="email")
	@NotNull(message = "Email Can not ne Null")
	@Email
	private String email;
	
	@Column(name="contactNumber")
	@NotNull(message = "Contact Number Can not ne Null")
	private Integer contactNumber;
	
	@Column(name="city")
	@NotNull(message = "City Can not ne Null")
	private String city;
	
	@Column(name="address")
	@NotNull(message = "Address Can not ne Null")
	private String address;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="date_blood1", nullable = false)
	//@NotNull(message = "Date Can not ne Null")
	public Date date_blood1;
	
	@PrePersist
	private void onCreate() {
		date_blood1 = new Date();
	}
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getdate_blood1() {
		return date_blood1;
	}
	public void setdate_blood1(Date date_blood1) {
		this.date_blood1 = date_blood1;
	}
	

}
