package org.choongang.member.controllers;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/*회원을 조회 할 수 있는 커맨드 객체*/
@Data
public class MemberSearch {
    @DateTimeFormat(pattern = "yyyyMMdd") //형식 명시
    private LocalDate sDate; //검색 시작일

    @DateTimeFormat(pattern = "yyyyMMdd") //형식 명시
    private LocalDate eDate; //검색 종료일
}
