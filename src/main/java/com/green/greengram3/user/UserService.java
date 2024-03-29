package com.green.greengram3.user;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.parser.Entity;

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
        UserSigninDto sDto = new UserSigninDto();
        sDto.setUid(dto.getUid());

        UserSelEntity entity = mapper.selUser(dto);

        if(entity == null){
            return UserSigninVo.builder().result(Const.LOGIN_NO_UID).build();
        }

        if(!BCrypt.checkpw(dto.getUpw(), entity.getUpw())){

            return UserSigninVo.builder().result(Const.LOGIN_DIFF_UPW).build();

        }
        return UserSigninVo.builder()
                .result(Const.SUCCESS)
                .iuser(entity.getIuser())
                .nm(entity.getNm())
                .pic(entity.getPic())
                .build();
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

    public ResVo patchUserFirebaseToken(UserFirebaseTokenPatchDto dto) {
        int affectedRows = mapper.updUserFirebaseToken(dto);
        return new ResVo(affectedRows);
    }

    public ResVo patchUserPic(UserPicPatchDto dto) {
        int affectedRows = mapper.updUserPic(dto);
        return new ResVo(affectedRows);
    }
}
