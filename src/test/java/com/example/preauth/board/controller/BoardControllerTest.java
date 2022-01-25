package com.example.preauth.board.controller;

import com.example.preauth.WithRequestHeaderUser;
import com.example.preauth.domain.account.code.AccountType;
import com.example.preauth.domain.board.dto.BoardModifyRequest;
import com.example.preauth.domain.board.dto.BoardWriteRequest;
import com.example.preauth.security.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.test.annotation.Commit;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableJpaAuditing
@AutoConfigureMockMvc
@Slf4j
class BoardControllerTest {

    @Autowired MockMvc mockMvc;

    @Autowired ObjectMapper objectMapper;

    @Test
    @DisplayName("게시판조회")
    //@WithRequestHeaderUser("Lessor 21")
    void test_boards() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/board")
                        .characterEncoding(Charset.defaultCharset())
                        .queryParam("sort", "createDate,asc")
                        .queryParam("sort", "id,desc"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    @DisplayName("단건조회")
    void test_board() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/board/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;

    }

    @Test
    @DisplayName("게시판글쓰기")
    @WithRequestHeaderUser("Lessor 21")
    void test_write() throws Exception {
        BoardWriteRequest request = new BoardWriteRequest();
        request.setTitle("title");
        request.setContents("test");
        mockMvc.perform(MockMvcRequestBuilders.post("/board")
                       // .header(SecurityConfig.SECURITY_HEADER, "Lessor 21")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("게시판글쓰기 권한오류")
    //@WithRequestHeaderUser("Lessor 21")
    void test_write_permission() throws Exception {
        BoardWriteRequest request = new BoardWriteRequest();
        request.setTitle("제목");
        request.setContents("내용");
        mockMvc.perform(MockMvcRequestBuilders.post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @DisplayName("게시판글수정")
    @WithRequestHeaderUser("Lessor 21")
    void test_modify() throws Exception {
        BoardWriteRequest request = new BoardWriteRequest();
        request.setTitle("제목");
        request.setContents("내용");
        BoardModifyRequest boardModifyRequest = new BoardModifyRequest();
        boardModifyRequest.setBoardWriteRequest(request);
        log.info("Request Body :: {}", objectMapper.writeValueAsString(boardModifyRequest));
        mockMvc.perform(MockMvcRequestBuilders.put("/board/1")
                        .header(SecurityConfig.SECURITY_HEADER, "")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(boardModifyRequest))
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("게시판글수정")
    @WithRequestHeaderUser("Realtor 11")
    void test_modify_permission() throws Exception {
        BoardWriteRequest request = new BoardWriteRequest();
        request.setTitle("제목");
        request.setContents("내용");
        BoardModifyRequest boardModifyRequest = new BoardModifyRequest();
        boardModifyRequest.setBoardWriteRequest(request);
        log.info("Request Body :: {}", objectMapper.writeValueAsString(boardModifyRequest));
        mockMvc.perform(MockMvcRequestBuilders.put("/board/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(boardModifyRequest))
                )
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}