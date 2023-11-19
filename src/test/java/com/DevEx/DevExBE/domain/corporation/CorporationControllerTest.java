package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.util.Convertor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CorporationControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    Gson gson = new GsonBuilder().create();
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void 회사_추가() throws Exception {

        //given
        CorporationRequestDto corporationRequestDto = CorporationRequestDto.builder()
                .corpName("test")
                .email("test")
                .tell("test")
                .build();

        String json = gson.toJson(corporationRequestDto);

        //when
        int status = mockMvc.perform(post("/api/corporation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(201);
    }

    @Test
    void 전체_회사_조회() throws Exception {

        //given

        //when
        int status = mockMvc.perform(get("/api/corporation"))
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(200);
    }

    @Test
    void ID로_회사_조회() throws Exception {

        //given

        //when
        int status = mockMvc.perform(get("/api/corporation/1"))
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(200);

    }

    @Test
    void 중복_회사_등록() throws Exception {

        //given
        CorporationRequestDto corporationRequestDto = CorporationRequestDto.builder()
                .corpName("testCorpName")
                .email("testEmail")
                .tell("testTell")
                .build();

        String json = gson.toJson(corporationRequestDto);

        MockHttpServletRequestBuilder post = post("/api/corporation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(post);

        //when
        String contentAsString = mockMvc.perform(post)
                .andReturn().getResponse().getContentAsString();

        String code = Convertor.getCode(Convertor.stringToJsonObject(contentAsString));

        //then
        assertThat(code).isEqualTo("COR_001");
    }

    @Test
    void 없는_회사_조회() throws Exception {

        //given

        //when
        String contentAsString = mockMvc.perform(get("/api/corporation/1000"))
                .andReturn().getResponse().getContentAsString();

        String code = Convertor.getCode(Convertor.stringToJsonObject(contentAsString));

        //then
        assertThat(code).isEqualTo("COR_002");

    }
}