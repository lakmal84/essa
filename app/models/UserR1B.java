package models;

/**
 * Created by User on 10/17/2016.
 */
public class UserR1B {
    private String uid;
    private String mobile;
    private String otp;
    private String tid;

    public UserR1B() {
    }

    public UserR1B(String uid, String mobile, String otp, String tid) {
        this.uid = uid;
        this.mobile = mobile;
        this.otp = otp;
        this.tid = tid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
