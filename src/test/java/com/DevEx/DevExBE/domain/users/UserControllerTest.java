package com.DevEx.DevExBE.domain.users;

import com.DevEx.DevExBE.util.Convertor;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
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

    @Test
    void 모든_유저_조회() throws Exception {

        //given

        //when
        int status = mockMvc.perform(get("/api/user")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("utf-8"))
                .andReturn().getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(200);

    }

    // TODO: 2023-11-19 [공준우] 테스트 코드 작성
    @Test
    void getUserId() {
    }

    // TODO: 2023-11-19 [공준우] 테스트 코드 작성
    @Test
    void deleteUser() {

        //given

        //when

        //then
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

    @Test
    void 없는_회원_조회() throws Exception{

        //given

        //when
        String contentAsString = mockMvc.perform(get("/api/user/1000")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("utf-8"))
                .andReturn().getResponse().getContentAsString();

        String code = Convertor.getCode(Convertor.stringToJsonObject(contentAsString));

        //then
        assertThat(code).isEqualTo("USER_001");

    }

}