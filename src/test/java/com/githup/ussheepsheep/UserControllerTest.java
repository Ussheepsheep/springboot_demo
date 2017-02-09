package com.githup.ussheepsheep;

import com.githup.ussheepsheep.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by daren on 2016/9/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
@ImportAutoConfiguration(MockServletContext.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Before
    public void initContoller() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testSomeThing() throws Exception {

        RequestBuilder request = null;
        request = get("/user/users");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        request = post("/user/").param("id", "1").param("email", "123@qq.com").param("password", "123");
        mockMvc.perform(request).andExpect(content().string(equalTo("success")));

        request = get("/user/1");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("{\"id\":1,\"email\":\"123@qq.com\",\"password\":\"123\"}")));
    }
}
