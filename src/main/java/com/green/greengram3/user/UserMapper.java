package com.green.greengram3.user;

import com.green.greengram3.user.model.UserInsSignupPdto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userInsSignup(UserInsSignupPdto pdto);
}
