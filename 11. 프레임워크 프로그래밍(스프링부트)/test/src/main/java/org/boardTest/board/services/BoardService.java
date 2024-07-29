package org.boardTest.board.services;

import lombok.RequiredArgsConstructor;
import org.boardTest.board.controllers.BoardForm;
import org.boardTest.board.entities.BoardData;
import org.boardTest.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDataRepository boardDataRepository;

    public List<BoardForm> items(){
        return boardDataRepository.findAll();
    }

    public void save(BoardForm form){
        BoardData boardData = new ModelMapper().map(form,BoardData.class);
    }

    public void save(BoardData boardData){
        boardDataRepository.saveAndFlush(boardData);
//        boardDataRepository.saveAndFlush(boardData);
    }

    public BoardForm find(Long seq){
        return boardDataRepository.findById(seq).orElse(null);
    }

    public void delete(BoardForm boardData){
        boardDataRepository.delete(boardData);
    }


}
