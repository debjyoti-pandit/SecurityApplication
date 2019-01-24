package bean;

public class AdminBean {
    public String name;
    public String address;
    public Long phoneNumber;
    public String email;
    public  String password;
    public String gender;
    public String imageID;
    public String communityID;

    public AdminBean() {
    }

    public AdminBean(String name, String address, Long phoneNumber, String email, String password, String gender, String imageID, String communityID) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.imageID = imageID;
        this.communityID = communityID;
    }

    public String getCommunityID() {
        return communityID;
    }

    public void setCommunityID(String communityID) {
        this.communityID = communityID;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
