package com.example.preauth.board.controller;

import com.example.preauth.security.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("간단한 테스트")
    void test_noraml() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")
                        .header(SecurityConfig.SECURITY_HEADER, "Lessor 21"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("비인증 사용자 테스트")
    void testanonymous() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")
                        .header(SecurityConfig.SECURITY_HEADER, ""))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}