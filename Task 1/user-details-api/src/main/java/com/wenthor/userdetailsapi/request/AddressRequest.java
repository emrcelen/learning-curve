package com.wenthor.userdetailsapi.request;

import com.wenthor.userdetailsapi.enums.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AddressRequest {
    @NotNull(message = "Please enter a street.")
    @NotEmpty(message = "This street field is required.")
    private String street;
    @NotNull(message = "Please enter a number.")
    private int number;
    @NotNull(message = "Please enter a postcode.")
    private int postcode;
    @NotNull(message = "Please enter a place.")
    @NotEmpty(message = "This place field is required.")
    private String place;
    @NotNull(message = "Please enter a country.")
    private Country country;

    public AddressRequest(String street, int number, int postcode, String place, Country country) {
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
