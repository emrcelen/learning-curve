package com.wenthor.userdetailsapi.controller;

import com.wenthor.userdetailsapi.enums.Country;
import com.wenthor.userdetailsapi.request.UserSaveRequest;
import com.wenthor.userdetailsapi.response.UserResponse;
import com.wenthor.userdetailsapi.response.rest.RestResponse;
import com.wenthor.userdetailsapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Valid UserSaveRequest request){
        return ResponseEntity.status(201).body(RestResponse.create(userService.saveUser(request),"Data başarılı bir şekilde kaydedildi."));
    }
    @GetMapping
    public ResponseEntity getAllUser(){
        List<UserResponse> list = userService.getAllUser();
        return ResponseEntity.ok(RestResponse.of(list,String.format("Veritabanı üzerinde kayıtlı (%d) veriler listelendi.",list.size()), HttpStatus.OK));
    }
    @GetMapping(path = "{country}")
    public ResponseEntity getAllUser(@PathVariable(name = "country")String shortName){
        List<UserResponse> list = userService.getAllUserWithCountry(shortName);
        return ResponseEntity.ok(RestResponse.of(list,String.format("Veritabanı üzerinde kayıtlı (%d) veriler listelendi.",list.size()), HttpStatus.OK));
    }
}
