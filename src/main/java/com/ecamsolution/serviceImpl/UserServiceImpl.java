package com.ecamsolution.serviceImpl;

import com.ecamsolution.dto.UserLogin;
import com.ecamsolution.dto.UserUpdatePassword;
import com.ecamsolution.entity.User;
import com.ecamsolution.repository.UserRepository;
import com.ecamsolution.service.UserService;
import com.ecamsolution.serviceImpl.validation.RegisterValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getUser(UserLogin userLogin) {

        String password = userLogin.getPassword();
        String phonenumber = userLogin.getPhonenumber();

        User user = userRepository.findByPhonenumberAndPassword(phonenumber, password).orElseThrow(()-> new RuntimeException());
        return user;

    }

    @Override
    public void updateUsername(User user) {
        User old = userRepository.findByPhonenumberAndPassword(user.getPhonenumber(), user.getPassword()).orElseThrow(RuntimeException::new);
        user.setId(old.getId());
        userRepository.save(user);

    }

    @Override
    public void updatePassword(UserUpdatePassword update) {
        User user = userRepository.findByPhonenumberAndPassword(update.getPhonenumber(), update.getPassword()).orElseThrow(RuntimeException::new);

        if( RegisterValidation.validatePassword(update.getNewPassword())){
            user.setPassword(update.getNewPassword());
            userRepository.save(user);
        }
        else {
            throw new RuntimeException();
        }


    }
}
