package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedInsPdto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)//일부분만 객체화를 하겠다
@Import({FeedService.class})//그 중에서도 얘만 빈 등록 하겠다는 뜻
    //서비스만 객체화를 하려면 연결된 mapper도 등록이 되어야 한다
    //그때 @MockBean사용

class FeedServiceTest {

    @MockBean//마치 주소값이 있는 거 처럼 꾸며준다 실체는 없지만 있는 거처럼 만들어줌
    private FeedMapper mapper;
    @MockBean
    private FeedCommentMapper comMapper;

    @Autowired
    private FeedService service;

    @Test
    void postFeed() {
        when(mapper.insFeed(any())).thenReturn(1); //가짜로 이 메소드에 any 어떠한 걸 보낼 것인데
        // 정해진 1이란 값을 리턴하라는 뜻
        when(mapper.insFeedPics(any())).thenReturn(3);

        FeedInsDto dto = new FeedInsDto();
        dto.setIfeed(100);
        dto.setPics(new ArrayList<>());
        dto.getPics().add("aaaa");
        ResVo vo = service.postFeed(dto);
        assertEquals(dto.getIfeed(), vo.getResult());

        verify(mapper).insFeed(any());// 메소드를 실제로 호출했는지 확인
        verify(mapper).insFeedPics(any());
    }

    @Test
    void postFeedAll() {
    }

    @Test
    void toggleFeedFav() {
    }

    @Test
    void delFeed() {
    }
}