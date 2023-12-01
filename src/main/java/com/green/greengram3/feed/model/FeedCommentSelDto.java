package com.green.greengram3.feed.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class FeedCommentSelDto {
    private int ifeed;
    private int startIdx;
    private int rowCount;
}
