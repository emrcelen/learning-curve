package com.wenthor.userdetailsapi.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class UserSaveRequest {
    @NotNull(message = "Please enter a name.")
    @NotEmpty(message = "This name field is required.")
    private String name;
    @NotNull(message = "Please enter a surname.")
    @NotEmpty(message = "This surname field is required.")
    private String surname;
    @Past(message = "Birthdate should be in the past.")
    private LocalDate birthdate;
    @Valid
    private AddressRequest addressRequest;

    public UserSaveRequest(String name, String surname, LocalDate birthdate, AddressRequest addressRequest) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.addressRequest = addressRequest;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

}
