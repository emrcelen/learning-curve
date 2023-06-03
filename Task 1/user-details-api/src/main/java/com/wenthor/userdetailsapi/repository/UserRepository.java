package com.wenthor.userdetailsapi.repository;

import com.wenthor.userdetailsapi.enums.Country;
import com.wenthor.userdetailsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByAddressCountry(Country country);

}
