package com.green.greengram3.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserSigninDto {
    private String uid;
    private String upw;
    @JsonIgnore
    private int iuser;
}
