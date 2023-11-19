package com.DevEx.DevExBE.domain.handcarry;

import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class HandcarryControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    Gson gson = new GsonBuilder().create();

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void 핸드캐리_추가() throws Exception {

        //given
        HandcarryRequestDto handcarryRequestDto = HandcarryRequestDto.builder()
                .startPoint("서울")
                .endPoint("중국")
                .unitCosts(3000f)
                .maxWeight(30L)
                .corporation("삼성성")
                .bannedItemList(List.of("금지품목1"))
                .build();

        String json = gson.toJson(handcarryRequestDto);

        //when
        int status = mockMvc.perform(post("/api/Handcarry")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andDo(print())
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(201);
    }

    @Test
    void 핸드캐리_조회() throws Exception {

        //given

        //when
        int status = mockMvc.perform(get("/api/Handcarry"))
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(200);

    }
    
}