package com.wenthor.userdetailsapi.response.converter;

import com.wenthor.userdetailsapi.model.Address;
import com.wenthor.userdetailsapi.response.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public final class AddressResponseConverter {

    protected static AddressResponse convertToResponse(Address address){
        return new AddressResponse(
                address.getStreet(),
                address.getNumber(),
                address.getPostcode(),
                address.getPlace(),
                address.getCountry().getShortName()
        );
    }
}
