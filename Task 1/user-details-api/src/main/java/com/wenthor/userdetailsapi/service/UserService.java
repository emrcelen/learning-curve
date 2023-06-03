package com.wenthor.userdetailsapi.service;

import com.wenthor.userdetailsapi.enums.Country;
import com.wenthor.userdetailsapi.enums.ErrorCodes;
import com.wenthor.userdetailsapi.exception.exceptions.UserNotFoundException;
import com.wenthor.userdetailsapi.model.Address;
import com.wenthor.userdetailsapi.model.User;
import com.wenthor.userdetailsapi.repository.UserRepository;
import com.wenthor.userdetailsapi.request.UserSaveRequest;
import com.wenthor.userdetailsapi.request.converter.UserRequestConverter;
import com.wenthor.userdetailsapi.response.UserResponse;
import com.wenthor.userdetailsapi.response.converter.UserResponseConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;

    public UserService(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    @Transactional
    public UserResponse saveUser(UserSaveRequest request){
        User user = UserRequestConverter.convertToEntity(request);
        Address address = addressService.saveAddress(user.getAddress());
        user.setAddress(address);
        return UserResponseConverter.convertToResponse(userRepository.save(user));
    }

    public List<UserResponse> getAllUser(){
        List<UserResponse> list = UserResponseConverter.convertToResponse(userRepository.findAll());
        if(list.size() > 0)
            return list;
        throw new UserNotFoundException(ErrorCodes.USER_NOT_FOUND_LIST,"Veritabanı üzerinde listelenecek herhangi bir kullanıcı kaydı bulunamadı.");
    }
    public List<UserResponse> getAllUserWithCountry(String shortName){
        List<UserResponse> list = UserResponseConverter.convertToResponse(userRepository.findByAddressCountry(Country.getByShortName(shortName.toUpperCase())));
        if(list.size() > 0)
            return list;
        throw new UserNotFoundException(ErrorCodes.USER_NOT_FOUND_LIST,"Veritabanı üzerinde listelenecek herhangi bir kullanıcı kaydı bulunamadı.");
    }
}
