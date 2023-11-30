package com.green.greengram3.feed.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FeedInsPicsDto {
    private int ifeed;
    private List<String> pics;
}
