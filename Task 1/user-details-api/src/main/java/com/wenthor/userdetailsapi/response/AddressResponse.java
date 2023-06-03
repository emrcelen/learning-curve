package com.wenthor.userdetailsapi.response;

public class AddressResponse {
    private String street;
    private int number;
    private int postcode;
    private String place;
    private String country;

    public AddressResponse(String street, int number, int postcode, String place, String country) {
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
    public String getCountry() {
        return country;
    }
}
