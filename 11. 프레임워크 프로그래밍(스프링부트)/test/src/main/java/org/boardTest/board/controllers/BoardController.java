package org.boardTest.board.controllers;

import lombok.RequiredArgsConstructor;
import org.boardTest.board.entities.BoardData;
import org.boardTest.board.services.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(@ModelAttribute BoardData form, Model model){
        List<BoardData> items = boardService.items();
        model.addAttribute("items", items);
        return "board/list";
    }

    @GetMapping("/register")
    public String register(){
        return "board/register";
    }

    @PostMapping("/register")
    public String registerPs(@ModelAttribute BoardData form){
        boardService.save(form);
        return "redirect:/board/list";
    }

    @GetMapping("/update/{seq}")
    public String update(@PathVariable Long seq,Model model){
        BoardData boardData = boardService.find(seq);
        model.addAttribute("boardData", boardData);
        return "board/update";
    }

    @PostMapping("/update")
    public String updatePs(@ModelAttribute BoardData form){
        boardService.save(form);
        return "redirect:/board/update/" + form.getSeq();
    }

    @PostMapping("/delete/{seq}")
    public String delete(@PathVariable Long seq){
        BoardData boardData = boardService.find(seq);
        if (boardData != null) {
            boardService.delete(boardData);
        }
        return "redirect:/board/list";
    }


}
