package com.ecamsolution.mapstruct;

import com.ecamsolution.dto.UserUpdateUsernameDto;
import com.ecamsolution.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target ="username" ,source = "newUsername")
    User toUser(UserUpdateUsernameDto userUpdateUsernameDto);
}
