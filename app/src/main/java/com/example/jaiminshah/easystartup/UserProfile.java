package com.example.jaiminshah.easystartup;

public class UserProfile {
    private String userID,firstname,lastname,Email,Phone, Address, college, Major, Job, Company, Description;

    public UserProfile(){}

    public UserProfile(String userID, String firstname, String lastname, String email, String phone, String address, String college, String major, String job, String company, String description) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        Email = email;
        Phone = phone;
        Address = address;
        this.college = college;
        Major = major;
        Job = job;
        Company = company;
        Description = description;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
