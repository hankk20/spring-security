package com.example.preauth.board.controller;

import com.example.preauth.domain.account.code.AccountType;
import com.example.preauth.domain.board.dto.BoardWriteRequest;
import com.example.preauth.security.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableJpaAuditing
@AutoConfigureMockMvc
class BoardControllerTest {

    @Autowired MockMvc mockMvc;

    @Autowired ObjectMapper objectMapper;

    @Test
    @DisplayName("비인증 사용자 테스트")
    void testanonymous() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")
                        .header(SecurityConfig.SECURITY_HEADER, ""))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @DisplayName("게시판조회")
    void test_boards() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/boards")
                        .header(SecurityConfig.SECURITY_HEADER, "")
                        .characterEncoding(Charset.defaultCharset())
                .queryParam("sort", "createDate,asc")
                .queryParam("sort", "id,desc"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                ;

    }
    @Test
    @DisplayName("단건조회")
    void test_board() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/board/1")
                        .header(SecurityConfig.SECURITY_HEADER, ""))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;

    }

    @Test
    @DisplayName("게시판글쓰기")
    @WithMockUser(username = "1", roles = {"LESSOR"})
    void test_noraml() throws Exception {
        BoardWriteRequest request = new BoardWriteRequest();
        request.setTitle("제목");
        request.setContents("내용");

        mockMvc.perform(MockMvcRequestBuilders.post("/board")
                        .header(SecurityConfig.SECURITY_HEADER, "Lessor 21")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}