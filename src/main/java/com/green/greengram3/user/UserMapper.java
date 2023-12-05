package com.green.greengram3.user;

import com.green.greengram3.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userInsSignup(UserInsSignupPdto pdto);

    UserSigninVo userSelSignin(String uid);

    String userSelUpw(String uid);

    int delFollow(UserFollowDto dto);

    int insFollow(UserFollowDto dto);

    UserInfoVo userInfoSel (UserInfoSelDto dto);
}
