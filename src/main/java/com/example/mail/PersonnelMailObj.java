package com.example.mail;

/**
 * Created by michael on 22/10/2016.
 */
public class PersonnelMailObj {


    private String firstName;
    private String lastName;
    private String jobDescription;
    private String email;
    private String password;
    private String businessName;

    public PersonnelMailObj(String firstName, String lastName, String email, String password,String jobDescription,String businessName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.jobDescription = jobDescription;
        this.businessName = businessName;
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

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

   /* @Override
    public String toString(){
        return "PersonnelMailObj [firstname=" +firstName+
                ", lastname="+lastName+
                ", password="+password+
                ", jobdescription="+jobDescription+
                ", email="+email+
                ", businessname="+businessName+
                "]";
    }*/


}
