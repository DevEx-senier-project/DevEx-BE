package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CorporationControllerTest {

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
    void 회사_추가() throws Exception{

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
        Assertions.assertThat(status).isEqualTo(201);
    }
}