package com.DevEx.DevExBE.domain.token;

import com.DevEx.DevExBE.domain.users.UserAuthority;
import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.domain.token.dto.AddUserRequestDto;
import com.DevEx.DevExBE.util.Convertor;
import com.google.gson.*;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

    @Test
    void 로그인() throws Exception {

        //given
        AddUserRequestDto request = new AddUserRequestDto("testName", "aaa@naver.com", "1234", UserAuthority.ROLE_USER);
        String json = gson.toJson(request);

        //when
        int status = mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(200);

    }

    @Test
    void 중복_회원가입() throws Exception {

        //given
        AddUserRequestDto request = AddUserRequestDto.builder()
                .email("testEmail")
                .name("testName")
                .password("testPassword")
                .userAuthority(UserAuthority.ROLE_USER)
                .build();

        String json = gson.toJson(request);

        MockHttpServletRequestBuilder requestBuilder = post("/auth/signup")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)
                .characterEncoding("utf-8");

        //when
        mockMvc.perform(requestBuilder);

        String contentAsString = mockMvc.perform(requestBuilder)
                .andReturn().getResponse().getContentAsString();

        String code = Convertor.getCode((Convertor.stringToJsonObject(contentAsString)));

        //then
        assertThat(code).isEqualTo("USER_002");
    }



}