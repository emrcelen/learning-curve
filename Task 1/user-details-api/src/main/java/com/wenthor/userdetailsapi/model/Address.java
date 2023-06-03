package com.wenthor.userdetailsapi.model;

import com.wenthor.userdetailsapi.enums.Country;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String street;
    @Column(name = "building_number", nullable = false)
    private int number;
    @Column(nullable = false)
    private int postcode;
    @Column(nullable = false)
    private String place;
    @Enumerated(EnumType.STRING)
    private Country country;

    public Address() {
    }

    public Address(String street, int number, int postcode, String place, Country country) {
        this.street = street;
        this.number = number;
        this.postcode = postcode;
        this.place = place;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }
    public int getNumber() {
        return number;
    }
    public int getPostcode() {
        return postcode;
    }
    public String getPlace() {
        return place;
    }
    public Country getCountry() {
        return country;
    }
}
