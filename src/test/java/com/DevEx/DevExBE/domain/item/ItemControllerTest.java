package com.DevEx.DevExBE.domain.item;

import com.DevEx.DevExBE.domain.item.dto.ItemRequestDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.assertj.core.api.Assertions;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ItemControllerTest {

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
    void 아이템_추가() throws Exception {

        //given
        ItemRequestDto itemRequestDto = new ItemRequestDto("testItemName", "testCategory");

        String content = gson.toJson(itemRequestDto);

        //when
        int status = mockMvc.perform(post("/api/Item")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))
                .andReturn().getResponse().getStatus();

        //then
        Assertions.assertThat(status).isEqualTo(200);

    }

}