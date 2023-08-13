package com.ecamsolution.service;

import com.ecamsolution.dto.UserLogin;
import com.ecamsolution.dto.UserUpdatePassword;
import com.ecamsolution.dto.UserUpdateUsernameDto;
import com.ecamsolution.entity.User;

import java.util.Map;

public interface UserService {

    User save(User newUser);

    User getUser(UserLogin user);

    void updateUsername(User user);

    void updatePassword(UserUpdatePassword update);


}
