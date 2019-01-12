package com.example.demo.springrestjpa.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Address
 */
@Embeddable
public class Address {

    @NotNull
    private String unitNumber;

    @NotNull    
    private String streetName;

    @NotNull   
    private String suburb;

    @NotNull
    private String state;

    @NotNull
    private String country;

    @NotNull
    private String pinCode;

    public Address(String unitNumber, String streetName, String suburb, String state, String country, String pinCode) {
        this.unitNumber = unitNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }


    public Address() {
    }

     /**
     * @return the unitNumber
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * @param unitNumber the unitNumber to set
     */
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
   

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the suburb
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * @param suburb the suburb to set
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the pinCode
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * @param pinCode the pinCode to set
     */
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }   
}