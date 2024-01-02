package com.green.greengram3.feed;

import com.green.greengram3.BaseIntegrationTest;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

public class FeedIntegrationTest extends BaseIntegrationTest {

    @Test
    //@Rollback(false)
    public void postFeed() throws Exception{

        FeedInsDto dto = new FeedInsDto();
        dto.setIuser(2);
        dto.setContents("통합 테스트 작업 중");
        dto.setLocation("그린컴퓨터학원");

        List<String> pics = new ArrayList<>();
        pics.add("https://photo.newsen.com/news_photo/2023/01/16/202301161022545510_1.jpg");
        pics.add("https://dispatch.cdnser.be/cms-content/uploads/2023/04/24/3d7ddd63-f6f5-468d-b0b2-3c3b806443f5.jpg");

        dto.setPics(pics);


        String json = om.writeValueAsString(dto);
        System.out.println("json"+ json);


        MvcResult mr = mvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/feed")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content = mr.getResponse().getContentAsString();
        //{ result : 1 } << 이런 형태로 넘어오며 그걸 String으로 변환해서 content로 넣어준다.
        ResVo vo = om.readValue(content, ResVo.class);
        //ResVo를 문자열로 표현된 것을 다시 ResVo 객체로 바꾸어주는 메소드
        //ResVo에 기본생성자를 넣어주어야 바꿔진다
        assertEquals(true, vo.getResult() > 0);
    }
}
