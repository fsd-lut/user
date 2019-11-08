package com.mentor.ondemand.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(
                webApplicationContext).build();
    }
    @Test
    public void TestQueryAll() throws Exception {
        String uri = "/api/v1/user";
  

        // 模拟GET请求
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get(uri))
                .andReturn();// 获取返回结果

        // 打印返回结果
        	System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void TestQueryId() throws Exception {
        String uri = "/api/v1/user/9999";
  

        // 模拟GET请求
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get(uri))
                .andReturn();// 获取返回结果

        // 打印返回结果
        	System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void TestQueryName() throws Exception {
        String uri = "/api/v1/query"+"?username=daniel";
  

        // 模拟GET请求
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get(uri))
                .andReturn();// 获取返回结果

        // 打印返回结果
        	System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
