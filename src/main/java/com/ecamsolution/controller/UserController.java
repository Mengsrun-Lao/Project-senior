package com.ecamsolution.controller;


import com.ecamsolution.dto.UserLogin;
import com.ecamsolution.dto.UserRegister;
import com.ecamsolution.dto.UserUpdatePassword;
import com.ecamsolution.dto.UserUpdateUsernameDto;
import com.ecamsolution.entity.User;
import com.ecamsolution.mapstruct.UserMapper;
import com.ecamsolution.repository.UserRepository;
import com.ecamsolution.service.UserService;
import com.ecamsolution.serviceImpl.validation.RegisterValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registration(@RequestBody UserRegister user){

        String phonenumber = user.getPhonenumber();
        String password = user.getPassword();
        String confirmPass = user.getConfirmPass();


        boolean validePhoneNumber = RegisterValidation.validatePhoneNumber(phonenumber);
        boolean match = RegisterValidation.passMatch(password, confirmPass);

        if(validePhoneNumber){
            Optional<User> optionalUser = userRepository.findByPhonenumber(phonenumber);
            if(optionalUser.isPresent()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already Exists");
            }
            else {

                if(!RegisterValidation.validatePassword(password)){
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your Password Must include number, capital character, lowercase character and Special character");
                }
                else {
                    if(match){
                        User newUser = new User(null,phonenumber,password,null);
                        userService.save(newUser);
                        return ResponseEntity.ok("Registration Successfully");
                    }
                    else{
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your Password is not match");
                   }
                }
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your Phone Number is invalid");

    }

    @PostMapping("/login")
    public ResponseEntity<?> loging(@RequestBody UserLogin userLogin){

        User user = userService.getUser(userLogin);
        return ResponseEntity.ok().body("Login Successfully");

    }


    @PutMapping("/update-Username")
    public ResponseEntity<?> UpdateUser(@RequestBody UserUpdateUsernameDto usernameDto){

        User user = UserMapper.INSTANCE.toUser(usernameDto);
        userService.updateUsername(user);
        return ResponseEntity.ok().body("Update UserName Successfully");
    }

    @PutMapping("/update-password")
    public ResponseEntity<?> udpatePassword(@RequestBody UserUpdatePassword updatePassword){

        userService.updatePassword(updatePassword);
        return ResponseEntity.ok().body("Update new Password Successfully");
    }



}
