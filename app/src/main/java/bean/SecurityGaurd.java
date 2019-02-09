package bean;

import java.io.Serializable;

public class SecurityGaurd implements Serializable {
    public String email;
    public String mobile;
    public String name;
    public String password;

    public SecurityGaurd() {
    }

    public SecurityGaurd(String email, String mobile, String name, String password) {
        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
