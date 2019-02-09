package bean;

public class FoodDeliveryBean {

    public String orderNumber;
    public String orderVendor;
    public String deliveryOption;
    public String inTime;
    public String inDate;

    public FoodDeliveryBean() {
    }

    public FoodDeliveryBean(String orderNumber, String orderVendor, String deliveryOption, String inTime, String inDate) {
        this.orderNumber = orderNumber;
        this.orderVendor = orderVendor;
        this.deliveryOption = deliveryOption;
        this.inTime = inTime;
        this.inDate = inDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderVendor() {
        return orderVendor;
    }

    public void setOrderVendor(String orderVendor) {
        this.orderVendor = orderVendor;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }
}
