package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedSelDto;
import com.green.greengram3.feed.model.FeedSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
@Tag(name = "피드 API", description = "피드 관련 처리")
public class FeedController {
    private final FeedService service;

    @PostMapping
    @Operation(summary = "피드 등록" , description = "피드 등록 처리")
    public ResVo PostFeed(@RequestBody FeedInsDto dto){
        return service.postFeed(dto);
    }


    @GetMapping
    @Operation(summary = "피드 리스트" ,description = "전체 피드 리스트, 특정 사용자")
    @Parameters(value = {
            @Parameter(name = "page", description = "page값")
    })
    public List<FeedSelVo> PostFeedAll(int page){
        FeedSelDto dto = FeedSelDto.builder()
                .rowCount(Const.FEED_COUNT_PER_PAGE)
                .startIdx((page-1)*Const.FEED_COUNT_PER_PAGE)
                .build();
        return service.PostFeedAll(dto);
    }
}
