package org.choongang.member.controllers;

import lombok.Builder;

@Builder
public record RequestLogin2(
        //값만 담을 수 있는 데이터 클래스
        String email,
        String password
) {}
