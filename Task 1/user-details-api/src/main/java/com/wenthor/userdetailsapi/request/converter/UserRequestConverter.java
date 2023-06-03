package com.wenthor.userdetailsapi.request.converter;

import com.wenthor.userdetailsapi.model.User;
import com.wenthor.userdetailsapi.request.UserSaveRequest;
import org.springframework.stereotype.Component;

@Component
public final class UserRequestConverter {

    public static User convertToEntity(UserSaveRequest request){
        return new User(
                request.getName(),
                request.getSurname(),
                request.getBirthdate(),
                AddressRequestConverter.convertToEntity(request.getAddressRequest())
        );
    }
}
