package com.example.security.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "admin")
@GenericGenerator(name = "pkgen", strategy = "increment")
public class AdminEntity {

	@Id
	@GeneratedValue(generator = "pkgen")
	private Integer adminID;
	private String firstname;
	private String lastname;
	private String addressLine1;
	private String addressLine2;
	private Long mobileNumber;
	private Long phoneNumber;
	private String emailID;
	private String gender;
	private String password;
	private Byte profilePicture;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "societyID", unique = true)
	private SocietyEntity societyEntity;

	
	@Override
	public String toString() {
		return adminID + firstname + lastname + addressLine1 + addressLine2 + mobileNumber + phoneNumber + emailID
				+ gender + password + profilePicture.toString() + societyEntity.toString();
	}

	public Integer getAdminID() {
		return adminID;
	}
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Byte profilePicture) {
		this.profilePicture = profilePicture;
	}

	public SocietyEntity getSocietyEntity() {
		return societyEntity;
	}

	public void setSocietyEntity(SocietyEntity societyEntity) {
		this.societyEntity = societyEntity;
	}
	
}
