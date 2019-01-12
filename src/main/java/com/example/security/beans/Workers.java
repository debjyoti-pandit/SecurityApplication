package com.example.security.beans;

public class Workers {
	
	private Integer workerID;
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
	private WorkerRole workerRole;
	private String previousWorkingDetails;
	private Integer salary;
	private Boolean monthly;
	private String uniqueCode;
	
	
	
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public Integer getWorkerID() {
		return workerID;
	}
	public void setWorkerID(Integer workerID) {
		this.workerID = workerID;
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
	public WorkerRole getWorkerRole() {
		return workerRole;
	}
	public void setWorkerRole(WorkerRole workerRole) {
		this.workerRole = workerRole;
	}
	public String getPreviousWorkingDetails() {
		return previousWorkingDetails;
	}
	public void setPreviousWorkingDetails(String previousWorkingDetails) {
		this.previousWorkingDetails = previousWorkingDetails;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Boolean getMonthly() {
		return monthly;
	}
	public void setMonthly(Boolean monthly) {
		this.monthly = monthly;
	}
	
	
}
