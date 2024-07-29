package org.boardTest.board.services;

import lombok.RequiredArgsConstructor;
import org.boardTest.board.controllers.RequestBoard;
import org.boardTest.board.entities.BoardData;
import org.boardTest.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDataRepository boardDataRepository;

    public List<BoardData> items(){

        return boardDataRepository.findAll();
    }

    public void save(RequestBoard form){

        BoardData boardData = new ModelMapper().map(form,BoardData.class);

        boardDataRepository.saveAndFlush(boardData);
    }

    public BoardData find(Long seq){
        return boardDataRepository.findById(seq).orElse(null);
    }

    public void delete(BoardData boardData){
        boardDataRepository.delete(boardData);
    }


}
