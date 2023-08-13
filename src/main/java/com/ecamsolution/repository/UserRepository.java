package com.ecamsolution.repository;


import com.ecamsolution.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByPhonenumber(String phonenumber);
    Optional<User> findByPhonenumberAndPassword(String phonenumber,String Pass);

}
