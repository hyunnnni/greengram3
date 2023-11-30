package com.green.greengram3.feed.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data

public class FeedSelVo {
    private int ifeed;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
    private String contents;
    private String location;
    private List<String> pics;
    private String createdAt;
    private int isFav;
}
