package com.DevEx.DevExBE.domain.search.controller;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
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
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    Gson gson = new GsonBuilder().create();

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void search() throws Exception {

        //given
        UserQuoteRequestDto userQuoteRequestDto = UserQuoteRequestDto.builder()
                .recipientPostalCode("13564")
                .recipientCountryCode("KR")
                .shipperPostalCode("8099")
                .shipperCountryCode("CH")
                .weight(11)
                .weightUnit("KG")
                .build();

        String json = gson.toJson(userQuoteRequestDto);

        //when
        int status = mockMvc.perform(get("/api/search")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(200);

    }

}