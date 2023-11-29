package com.green.greengram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class UserInsSignupPdto {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
