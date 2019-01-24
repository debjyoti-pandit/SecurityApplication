package bean;

public class CommunityBean {

    public String societyName;
    public String addressLine1;
    public String addressLine2;
    public Long phoneNumber;
    public Integer noOfFlats;
    public Integer noOfEntryGates;
    public Integer noOFExitGates;

    public CommunityBean() {
    }

    public CommunityBean(String societyName, String addressLine1, String addressLine2, Long phoneNumber, Integer noOfFlats, Integer noOfEntryGates, Integer noOFExitGates) {
        this.societyName = societyName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.phoneNumber = phoneNumber;
        this.noOfFlats = noOfFlats;
        this.noOfEntryGates = noOfEntryGates;
        this.noOFExitGates = noOFExitGates;
    }

    @Override
    public String toString() {
        return societyName + addressLine1 + addressLine2 + phoneNumber + noOfEntryGates
                + noOFExitGates + noOfFlats;
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
