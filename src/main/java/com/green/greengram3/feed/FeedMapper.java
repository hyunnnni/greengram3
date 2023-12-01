package com.green.greengram3.feed;

import com.green.greengram3.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed (FeedInsPdto pdto);

    int insFeedPics(FeedInsPicsDto pics);

    List<FeedSelVo> feedSelAll(FeedSelDto dto);

    List<String> feedSelPics (int ifeed);

    int delFeedFav (FeedFavDto dto);

    int insFeedFav(FeedFavDto dto);
}
