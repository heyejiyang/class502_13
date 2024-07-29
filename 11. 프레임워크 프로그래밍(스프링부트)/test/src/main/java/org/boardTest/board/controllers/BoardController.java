package org.boardTest.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.boardTest.board.entities.BoardData;
import org.boardTest.board.services.BoardService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(@ModelAttribute RequestBoard form, Model model){
        List<BoardData> boardData = boardService.items();
        model.addAttribute("boardData", boardData);
        return "board/list";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute RequestBoard form){

        return "board/register";
    }

    @PostMapping("/register")
    public String registerPs(@Valid RequestBoard form, Errors errors){
        if (errors.hasErrors()) {
            return "board/register";
        }
        boardService.save(form);
        return "redirect:/board/list";
    }

    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") Long seq, Model model){
        BoardData boardData = boardService.find(seq);
        model.addAttribute("boardData", boardData);
        return "board/view";
    }

    @GetMapping("/update/{seq}")
    public String update(@PathVariable("seq") Long seq,Model model){

        model.addAttribute("boardData",boardService.find(seq));
        return "board/update";
    }

    @PostMapping("/update")
    public String updatePs(RequestBoard form){
        BoardData boardData = new ModelMapper().map(form, BoardData.class);
        boardService.save(form);
        return "redirect:/board/update/" + boardData.getSeq();
    }

    @PostMapping("/delete/{seq}")
    public String delete(@PathVariable("seq") Long seq){
        BoardData boardData = boardService.find(seq);
        if (boardData != null) {
            boardService.delete(boardData);
        }
        return "redirect:/board/list";
    }


}
