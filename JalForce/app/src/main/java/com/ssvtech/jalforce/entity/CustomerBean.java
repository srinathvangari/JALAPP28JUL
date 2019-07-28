package com.ssvtech.jalforce.entity;

public class CustomerBean implements java.io.Serializable{

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Integer id;

    private String firstName;

    private String lastName;

    private String mobileNo;

    private String address;

    public Integer getPendingCans() {
        return pendingCans;
    }

    public void setPendingCans(Integer pendingCans) {
        this.pendingCans = pendingCans;
    }

    private Integer pendingCans;
}
