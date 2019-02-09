package com.example.security.beans;

public class SocietyBean {

	private Integer societyID;
	private String societyName;
	private String addressLine1;
	private String addressLine2;
	private Long mobileNumber;
	private Long phoneNumber;
	private Integer noOfFlats;
	private Integer noOfEntryGates;
	private Integer noOFExitGates;

	@Override
	public String toString() {
		return societyID + societyName + addressLine1 + addressLine2 + mobileNumber + phoneNumber + noOfEntryGates
				+ noOFExitGates + noOfFlats;
	}

	public Integer getSocietyID() {
		return societyID;
	}

	public void setSocietyID(Integer societyID) {
		this.societyID = societyID;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
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

	public Integer getNoOfFlats() {
		return noOfFlats;
	}

	public void setNoOfFlats(Integer noOfFlats) {
		this.noOfFlats = noOfFlats;
	}

	public Integer getNoOfEntryGates() {
		return noOfEntryGates;
	}

	public void setNoOfEntryGates(Integer noOfEntryGates) {
		this.noOfEntryGates = noOfEntryGates;
	}

	public Integer getNoOFExitGates() {
		return noOFExitGates;
	}

	public void setNoOFExitGates(Integer noOFExitGates) {
		this.noOFExitGates = noOFExitGates;
	}

}
