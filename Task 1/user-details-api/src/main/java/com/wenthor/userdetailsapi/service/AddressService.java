package com.wenthor.userdetailsapi.service;

import com.wenthor.userdetailsapi.model.Address;
import com.wenthor.userdetailsapi.repository.AddressRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
}
