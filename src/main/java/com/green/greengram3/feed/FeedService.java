package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo postFeed(FeedInsDto dto){
        FeedInsPdto pdto = FeedInsPdto .builder()
                .iuser(dto.getIuser())
                .contents(dto.getContents())
                .location(dto.getLocation())
                .build();
        mapper.insFeed(pdto);

        if(!dto.getPics().isEmpty()) {//앞의 배열이 비어있는지 아닌지 true, false 가려준다.
            FeedInsPicsDto pics = FeedInsPicsDto.builder()
                    .ifeed(pdto.getIfeed())
                    .pics(dto.getPics())
                    .build();
            mapper.insFeedPics(pics);
        }

        return new ResVo(pdto.getIfeed());
    }

    public List<FeedSelVo> PostFeedAll(FeedSelDto dto){
        List<FeedSelVo> vo = mapper.feedSelAll(dto);

        for(FeedSelVo a : vo){
            a.setPics(mapper.feedSelPics(a.getIfeed()));

        }
        return vo;
    }
}
