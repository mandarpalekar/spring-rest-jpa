package com.example.demo.springrestjpa.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Embedded
    private Name name;
    
    private String initials;

    private String title;

    @Embedded
    private Address address;

    private String sex;

    private String maritalStatus;

    @Min(0)
    @Max(100)
    private Long creditRating;

    private boolean isNABCustomer;

    public Customer(Long id, Name name, String initials, String title, Address address, String sex, String maritalStatus, Long creditRating, boolean isNABCustomer) {
        this.id = id;
        this.name = name;
        this.initials = initials;
        this.title = title;
        this.address = address;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.creditRating = creditRating;
        this.isNABCustomer = isNABCustomer;
    }  

    public Customer() {

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the creditRating
     */
    public Long getCreditRating() {
        return creditRating;
    }

    /**
     * @param creditRating the creditRating to set
     */
    public void setCreditRating(Long creditRating) {
        this.creditRating = creditRating;
    }

    /**
     * @return the isNABCustomer
     */
    public boolean isNABCustomer() {
        return isNABCustomer;
    }

    /**
     * @param isNABCustomer the isNABCustomer to set
     */
    public void setNABCustomer(boolean isNABCustomer) {
        this.isNABCustomer = isNABCustomer;
    }
}
