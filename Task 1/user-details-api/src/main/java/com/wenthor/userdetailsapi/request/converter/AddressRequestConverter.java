package com.wenthor.userdetailsapi.request.converter;

import com.wenthor.userdetailsapi.model.Address;
import com.wenthor.userdetailsapi.request.AddressRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public final class AddressRequestConverter {

    protected static Address convertToEntity(AddressRequest request){
        return new Address(
                request.getStreet(),
                request.getNumber(),
                request.getPostcode(),
                request.getPlace(),
                request.getCountry()
        );
    }

}
