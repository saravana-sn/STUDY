package com.saravana.mvcwebdemo.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RegistrationForm {

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotBlank(message = "Country is required")
    private String country;

    @Past(message = "Date of Birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Specify the date format
    private Date dob;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Tell it now!")
    @Min(value = 1, message = "I know It's not 0 or less")
    @Max(value = 1000000, message = "Not for millionaires.")
    private double annualIncome;

    // Getters and Setters
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public double getAnnualIncome() {
        return annualIncome;
    }
    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }
}