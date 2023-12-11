package com.green.greengram3.user;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo postsignup(UserInsSignupDto dto){
        UserInsSignupPdto pdto= UserInsSignupPdto.builder()
                .uid(dto.getUid())
                .upw(BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt()))
                .nm(dto.getNm())
                .pic(dto.getPic())
                .build();
        int result = mapper.userInsSignup(pdto);
        if(result == 0){
            return new ResVo(result);
        }
        return new ResVo(pdto.getIuser());
    }

    public UserSigninVo postsignin (UserSigninDto dto){
        String upw = mapper.userSelUpw(dto.getUid());
        UserSigninVo vo = new UserSigninVo();
        vo.setResult(Const.LOGIN_DIFF_UPW);
        if(upw == null){
            vo.setResult(Const.LOGIN_NO_UID);
            return vo;
        }

        if(BCrypt.checkpw(dto.getUpw(), upw)){
            vo = mapper.userSelSignin(dto.getUid());
            vo.setResult(Const.SUCCESS);

        }
        return vo;
    }

    public ResVo toggleFollow(UserFollowDto dto){
        int result = mapper.delFollow(dto);
        if(result == 1){
            return new ResVo(Const.FAIL);
        }
        result = mapper.insFollow(dto);
        return new ResVo(Const.SUCCESS);
    }

    public UserInfoVo getUserInfoSel(UserInfoSelDto dto){
        return mapper.userInfoSel(dto);
    }
}
