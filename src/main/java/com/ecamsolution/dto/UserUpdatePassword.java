package com.ecamsolution.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePassword {
    private String phonenumber;
    private String password;
    private String newPassword;
}
