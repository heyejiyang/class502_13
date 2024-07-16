package org.choongang.file.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {

    //요청메서드
    @GetMapping("/upload")
    public String upload(){

        return "file/upload";
    }

    @ResponseBody //반환값을 넣지 않기위해
    @PostMapping("/upload")
    public void uploadPs(@RequestPart("file") MultipartFile file){
        String name = file.getOriginalFilename();
        log.info("파일명: {}",name);
    }
}
