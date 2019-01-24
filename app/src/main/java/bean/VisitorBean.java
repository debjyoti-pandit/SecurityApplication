package bean;

import java.util.Date;

public class VisitorBean {

    public String ownerId;
    public String visitorName;
    public Date time;
    public Date date;
    public Integer nofPeople;
    public Long mobileNumber;
    public int otpGenerated;

    public VisitorBean() {
    }

    public VisitorBean(String ownerId, String visitorName, Date time, Date date, Integer nofPeople, Long mobileNumber, int otpGenerated) {
        this.ownerId = ownerId;
        this.visitorName = visitorName;
        this.time = time;
        this.date = date;
        this.nofPeople = nofPeople;
        this.mobileNumber = mobileNumber;
        this.otpGenerated = otpGenerated;
    }

    public int getOtpGenerated() {
        return otpGenerated;
    }

    public void setOtpGenerated(int otpGenerated) {
        this.otpGenerated = otpGenerated;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNofPeople() {
        return nofPeople;
    }

    public void setNofPeople(Integer nofPeople) {
        this.nofPeople = nofPeople;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
