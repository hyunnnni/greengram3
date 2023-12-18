package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedFavDto;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import 되어 있으니 따로 클래스 이름 적고 메소드 호출 안해도 된다.
@MybatisTest//mybatis를 테스트한다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FeedMapperTest {

    @Autowired
    private FeedMapper mapper;
    //주소값을 달라고 한다.
    @Test
    public void insFeedFav(){
        FeedFavDto dto = new FeedFavDto();
        dto.setIfeed(1);
        dto.setIuser(2);

        int affectedRows1 = mapper.insFeedFav(dto);
        assertEquals(1, affectedRows1,"첫 번째 테스트");//테스트 실패 시 위치를 알 수 있음

        List<FeedFavDto> result = mapper.selFeedFavForTest(dto);
        assertEquals(1, result.size());
    }

    @Test
    public void delFeedFav(){
        FeedFavDto dto = new FeedFavDto();
        dto.setIuser(8);
        dto.setIfeed(110);

        int affectedRows1 = mapper.delFeedFav(dto);
        assertEquals(1, affectedRows1);

        int affectedRows2 = mapper.delFeedFav(dto);
        assertEquals(0, affectedRows2);

        List<FeedFavDto> result = mapper.selFeedFavForTest(dto);
        assertEquals(0, result.size());
    }

    @Test
    public void delFeedFavAll(){
        int affectedRows1 = mapper.delFeedFavAll(1);
        assertEquals(2,affectedRows1);

        int affectedRows2 = mapper.delFeedFavAll(1);
        assertEquals(0,affectedRows2);

        FeedFavDto dto2 = new FeedFavDto();
        dto2.setIfeed(1);
        List<FeedFavDto> result = mapper.selFeedFavForTest(dto2);


        FeedDelDto dto = new FeedDelDto();
        dto.setIfeed(1);
        int delAffectedRows = mapper.delFeedFavAll(dto.getIfeed());
        assertEquals(result.size(), delAffectedRows);

        List<FeedFavDto> result2 = mapper.selFeedFavForTest(dto2);
        assertEquals(0, result2.size());
    }
}