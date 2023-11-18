package com.DevEx.DevExBE.domain.token;

import com.DevEx.DevExBE.domain.users.UserAuthority;
import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.domain.users.dto.AddUserRequestDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AuthControllerTest {

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
    void 회원가입() throws Exception {

        //given
        AddUserRequestDto request = new AddUserRequestDto("testName", "testEmail", "testPassword", UserAuthority.ROLE_USER);
        String json = gson.toJson(request);

        //when
        String string = mockMvc.perform(post("/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andReturn().getResponse().getContentAsString();

        Users users = gson.fromJson(string, Users.class);

        //then
        assertThat(users.getEmail()).isEqualTo(request.getEmail());

    }
}