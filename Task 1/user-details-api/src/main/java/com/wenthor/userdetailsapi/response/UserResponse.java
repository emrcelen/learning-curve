package com.wenthor.userdetailsapi.response;

public class UserResponse {
    private String name;
    private String surname;
    private String birthdate;
    private AddressResponse address;

    public UserResponse(String name, String surname, String birthdate, AddressResponse address) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public AddressResponse getAddress() {
        return address;
    }
}
