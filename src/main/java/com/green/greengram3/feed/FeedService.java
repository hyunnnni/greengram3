package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final FeedCommentMapper comMapper;

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

        FeedCommentSelDto fcDto = FeedCommentSelDto.builder()
                .startIdx(0)
                .rowCount(4)
                .build();

        for(FeedSelVo a : vo){
            a.setPics(mapper.feedSelPics(a.getIfeed()));
            fcDto.setIfeed(a.getIfeed());
            List<FeedCommentSelVo> comments = comMapper.selFeedCommentAll(fcDto);
            a.setComments(comments);
            if(comments.size() == 4){
                a.setIsMoreComment(Const.FEED_COMMENT_MORE);
                comments.remove(comments.size()-1);

            }
        }
        return vo;
    }

    public ResVo toggleFeedFav(FeedFavDto dto){
        int result = mapper.delFeedFav(dto);
        if(result == 1){
            return new ResVo(Const.FEED_FAV_DEL);
        }
        result = mapper.insFeedFav(dto);
        return new ResVo(Const.FEED_FAV_ADD);
    }

    public ResVo DelFeed(FeedDelDto dto) {

        int result = mapper.delComFavPics(dto);
        if(result == 1) {
            result = mapper.delFeed(dto);
            return new ResVo(result);
        }
        return new ResVo(result);
    }


}
