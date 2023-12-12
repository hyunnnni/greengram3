package com.green.greengram3.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class UserSigninVo {
    private int result;
    private int iuser;
    private String nm;
    private String pic;
}

