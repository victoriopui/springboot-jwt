package com.test.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 2847592847592847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User details
    @Column(name = "firstname", nullable = false)
	private String firstname;
    
    @Column(name = "lastname", nullable = false)
    private String lastname;
    
    @Column(name = "dateofbirth")
    private String dateofbirth;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "mobileno")
    private String mobileno;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;
    
    // Pin for user authentication, on production this should be hashed
    @Column(name = "pin", nullable = false)
    private String pin;

    // Password field for user authentication, currently is hashed from pin
    @Column(name = "password", nullable = false)
    private String password;
    
    //need default constructor for JSON Parsing
	public UserModel()
	{

	}

	public UserModel(String firstname, String lastname, String dateofbirth, String gender, String email,
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}