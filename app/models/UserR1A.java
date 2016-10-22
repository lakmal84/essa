package models;

/**
 * Created by User on 10/17/2016.
 */
public class UserR1A {
    private String name;
    private String uid;
    private String mobile;
    private String nationality;
    private String salutation;
    private String email;
    private String dob;
    private String tid;

    public UserR1A() {
    }

    public UserR1A(String name, String uid, String mobile, String nationality, String salutation, String email, String dob, String tid) {
        this.name = name;
        this.uid = uid;
        this.mobile = mobile;
        this.nationality = nationality;
        this.salutation = salutation;
        this.email = email;
        this.dob = dob;
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
