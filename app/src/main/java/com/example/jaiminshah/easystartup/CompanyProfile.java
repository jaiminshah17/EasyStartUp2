package com.example.jaiminshah.easystartup;

public class CompanyProfile {
    private String userID, companyName, position, comDescription;

    public CompanyProfile() {
    }

    public CompanyProfile(String userID,String companyName, String position, String comDescription) {
        this.userID = userID;
        this.companyName = companyName;
        this.position = position;
        this.comDescription = comDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getComDescription() {
        return comDescription;
    }

    public void setComDescription(String comDescription) {
        this.comDescription = comDescription;
    }
}
