package com.green.greengram3.user;

import com.green.greengram3.user.model.UserFollowDto;
import com.green.greengram3.user.model.UserInsSignupPdto;
import com.green.greengram3.user.model.UserSigninVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userInsSignup(UserInsSignupPdto pdto);

    UserSigninVo userSelSignin(String uid);

    String userSelUpw(String uid);

    int delFollow(UserFollowDto dto);

    int insFollow(UserFollowDto dto);
}
