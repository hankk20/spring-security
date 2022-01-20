package com.example.preauth.domain.board.service;

import com.example.preauth.domain.account.Account;
import com.example.preauth.domain.board.Board;
import com.example.preauth.domain.board.predicate.BoardLikePredicate;
import com.example.preauth.domain.board.repository.BoardLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardLikeService {

    private final BoardLikeRepository boardLikeRepository;
    private final BoardService boardService;

    public long like(long boardId, Account account){
        if(alreadyLike(boardId, account)){
            throw new RuntimeException("이미 좋아요를 한 게시물 입니다.");
        }
        return addLike(boardId, account);
    }

    public boolean alreadyLike(long boardId, Account account){
        return boardLikeRepository.exists(BoardLikePredicate.compositeKey(boardId, account));
    }

    private long addLike(long boardId, Account account){
        Board board = boardService.findOrElseThrow(boardId);
        board.addLike(account);

        return board.getId();
    }

}
