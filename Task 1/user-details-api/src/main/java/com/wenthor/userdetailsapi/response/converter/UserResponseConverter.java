package com.wenthor.userdetailsapi.response.converter;

import com.wenthor.userdetailsapi.model.User;
import com.wenthor.userdetailsapi.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public final class UserResponseConverter {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static UserResponse convertToResponse(User user){
        return new UserResponse(
                user.getName(),
                user.getSurname(),
                formatter.format(user.getBirthdate()),
                AddressResponseConverter.convertToResponse(user.getAddress())
        );
    }
    public static List<UserResponse> convertToResponse(List<User> users){
        return users.stream()
                .map(user -> convertToResponse(user))
                .collect(Collectors.toList());
    }
}
