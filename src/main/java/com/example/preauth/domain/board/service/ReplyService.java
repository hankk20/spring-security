package com.example.preauth.domain.board.service;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.Reply;
import com.example.preauth.domain.board.dto.ReplyWriteRequest;
import com.example.preauth.domain.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ReplyService {

    private final ReplyRepository repository;
    private final BoardService boardService;

    public long write(Long id, Account account, ReplyWriteRequest request){
        Board board = boardService.findOrElseThrow(id);
        Reply reply = new Reply(account, request.getContents());
        board.addReply(reply);
        Reply save = repository.save(reply);
        return save.getId();
    }

    public long update(Long id, ReplyWriteRequest request){
        Optional<Reply> byId = repository.findById(id);
        byId.get().setContents(request.getContents());
        return byId.get().getId();
    }

    public long delete(Long id){
        repository.deleteById(id);
        return id;
    }
}
