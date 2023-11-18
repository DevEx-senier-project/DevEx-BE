package com.DevEx.DevExBE.domain.users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

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

    @WithMockUser(username = "aaa@naver.com", password = "1234")
    @Test
    void 로그인한_유저의_상세정보를_얻어온다() throws Exception {

        //given

        //when
        String result = mockMvc.perform(get("/api/user/detail")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("utf-8"))
                .andReturn().getResponse().getContentAsString();

        Users users = gson.fromJson(result, Users.class);

        //then
        assertThat(users.getEmail()).isEqualTo("aaa@naver.com");

    }
}