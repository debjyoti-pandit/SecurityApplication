package com.example.security.beans;

public class OwnerBean {

	private Integer ownerID;
	private String firstname;
	private String lastname;
	private String addressLine1;
	private String addressLine2;
	private Long mobileNumber;
	private Long phoneNumber;
	private String emailID;
	private String gender;
	private String password;
	private String flatNumber;
	private String blockNumber;
	private String parkingNumber;
	private String vehicleNumber1;
	private String vehicleNumber2;
	private Byte profilePicture;

	@Override
	public String toString() {
		return ownerID + firstname + lastname + addressLine1 + addressLine2 + mobileNumber + phoneNumber + emailID
				+ gender + password + flatNumber + blockNumber + parkingNumber + vehicleNumber1 + vehicleNumber2
				+ profilePicture.toString();
	}

	public Integer getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Integer ownerID) {
		this.ownerID = ownerID;
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

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}

	public String getParkingNumber() {
		return parkingNumber;
	}

	public void setParkingNumber(String parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public String getVehicleNumber1() {
		return vehicleNumber1;
	}

	public void setVehicleNumber1(String vehicleNumber1) {
		this.vehicleNumber1 = vehicleNumber1;
	}

	public String getVehicleNumber2() {
		return vehicleNumber2;
	}

	public void setVehicleNumber2(String vehicleNumber2) {
		this.vehicleNumber2 = vehicleNumber2;
	}

	public Byte getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Byte profilePicture) {
		this.profilePicture = profilePicture;
	}

}
