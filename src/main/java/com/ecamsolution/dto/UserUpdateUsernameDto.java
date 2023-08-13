package com.ecamsolution.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateUsernameDto {

    private String phonenumber;
    private String password;
    private String NewUsername;

}
