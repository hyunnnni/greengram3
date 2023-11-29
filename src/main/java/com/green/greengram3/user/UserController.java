package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.UserInsSignupDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService service;


    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원가입 처리")
    @Parameters(value = {
            @Parameter(name ="uid", description = "아이디"),
            @Parameter(name ="upw", description = "비밀번호"),
            @Parameter(name ="nm", description = "유저 이름"),
            @Parameter(name ="pic", description = "프로필 사진")
    })//<< 스웨거에서 표시된 파라미터 부분은 쿼리스트링으로 날아가는 부분이다
    //그래서 get방식일 때 사용하는 편이 좋고 post일 때는 헷갈릴 수 있다
    public ResVo postsignup(@RequestBody UserInsSignupDto dto){
        log.info("dto : {}", dto);
        return service.postsignup(dto);
    }
}
