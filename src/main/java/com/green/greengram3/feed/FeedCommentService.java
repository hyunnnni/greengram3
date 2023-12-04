package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedCommentDelDto;
import com.green.greengram3.feed.model.FeedCommentInsDto;
import com.green.greengram3.feed.model.FeedCommentSelDto;
import com.green.greengram3.feed.model.FeedCommentSelVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedCommentService {
    private final FeedCommentMapper mapper;
    public ResVo postFeedComment(FeedCommentInsDto dto) {
        int affectedRows = mapper.insFeedComment(dto);

        return new ResVo(dto.getIfeedComment());
    }

    public List<FeedCommentSelVo> getFeedCommentAll(int ifeed){
        FeedCommentSelDto dto = FeedCommentSelDto.builder()
                .ifeed(ifeed)
                .startIdx(3)
                .rowCount(999)
                .build();

        return mapper.selFeedCommentAll(dto);
    }

    public ResVo delComment(FeedCommentDelDto dto){
        int result = mapper.delFeedComment(dto);

        return new ResVo(result);
    }
}
