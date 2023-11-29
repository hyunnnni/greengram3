package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.UserInsSignupDto;
import com.green.greengram3.user.model.UserInsSignupPdto;
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
}
