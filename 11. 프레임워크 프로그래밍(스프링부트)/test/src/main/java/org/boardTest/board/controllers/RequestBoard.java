package org.boardTest.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class RequestBoard { //사용자가 작성한 게시글 데이터 전달하는 커맨드 객체 - 검증 용도
    @NotBlank //필수항목 검증
    private String subject;
    @NotBlank
    private String content;
    @NotBlank
    private String writer;
}
