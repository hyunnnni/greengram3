package com.green.greengram3.feed.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeedInsPdto {
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
}
