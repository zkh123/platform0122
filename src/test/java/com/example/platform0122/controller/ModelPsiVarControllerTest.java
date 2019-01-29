package com.example.platform0122.controller;

import com.example.platform0122.Platform0122ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by huanglijun on 2019/1/29
 */
@AutoConfigureMockMvc
public class ModelPsiVarControllerTest extends Platform0122ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void selectById() throws Exception {
        String responseString = this.mockMvc.perform(get("/modelPsiVar/selectById?id=26")
                                                        .contentType(MediaType.TEXT_HTML).param("id", "26")).andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("----返回的json = " + responseString);
    }

}
