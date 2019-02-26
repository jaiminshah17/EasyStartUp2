package com.example.jaiminshah.easystartup;

public class UserProfile {
    private String firstname;
    private String lastname;
    private String college;
    private String userID;

    public UserProfile(){}

    public UserProfile(String userID, String firstname, String lastname, String college ) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.college = college;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
