package com.test.model;

import java.io.Serializable;

public class DocumentGenerateRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String firstname;
    private String lastname;
    private String dateofbirth;
    private String gender;
    private String email;
    private String mobileno;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pin;
    
    //need default constructor for JSON Parsing
	public DocumentGenerateRequest()
	{

	}
    
	public DocumentGenerateRequest(String firstname, String lastname, String dateofbirth, String gender, String email,
            String mobileno, String address, String city, String state, String country, String pin) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.email = email;
        this.mobileno = mobileno;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pin = pin;
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

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}