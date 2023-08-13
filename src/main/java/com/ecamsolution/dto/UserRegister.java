package com.ecamsolution.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegister {
    String phonenumber  ;
    String password  ;
    String confirmPass ;
}
