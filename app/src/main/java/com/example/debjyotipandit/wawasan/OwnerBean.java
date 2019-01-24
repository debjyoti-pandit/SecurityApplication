package com.example.firebaseapplication;

import java.io.Serializable;

public class OwnerBean implements Serializable {
    private String fullName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String password;
    private String flatNumber;
    private String blockNumber;
    private String address;
    private String communityId;
    private String vehicleId;
    private String parkingId;

    public OwnerBean() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public OwnerBean(String fullName, String email, String gender, String phoneNumber, String password, String flatNumber, String blockNumber, String address, String vehicleId, String parkingId) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.flatNumber = flatNumber;
        this.blockNumber = blockNumber;
        this.address = address;
        this.vehicleId = vehicleId;
        this.parkingId = parkingId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
