package org.choongang.member.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.global.Utils;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.rests.JSONData;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class ApiMemberController {
    private final MemberMapper mapper;
    private final JoinService joinService;
    private final Utils utils; //유효성 검사 오류 메시지 처리

    @PostMapping //POST /api/member -> 회원가입으로 동작
    public ResponseEntity join(@RequestBody @Valid RequestJoin form, Errors errors)// errors -> 앞 커맨드 객체에 대한 검증에 대한 에러 결과만 해당됨
            // @RequestBody: HTTP 요청의 본문을 그대로 자바 객체로 변환하여 매핑된 메소드의 파라미터로 전달, 클라이언트가 JSON, XML 등의 형식으로 데이터를 전송하면, Spring이 이를 적절한 자바 객체로 변환해줌 -> 어노테이션에 의해 RequestJoin 클래스의 객체로 변환되는것
            // @Valid: form 객체에 대한 유효성 검사를 수행

    {//RequestJoin 객체를 받아 유효성 검사 수행

        if(errors.hasErrors()){
            throw new BadRequestException(utils.getErrorMessages(errors)); //객체에 오류가 발생하면 해당 메서드를 통해 오류 메시지를 가공하고 에러 발생시킴
            //가공 하는 이유 -> 에러 코드를 그대로 보여주면 사용자가 인식하지 못할수도있다
            //ex) NotBlank.password

            //ExceptionHandler로 유입됨
        }
/*
        boolean result = false;
        if(!result){ //오류 있으면 예외발생
            throw new BadRequestException("예외 테스트!");
        }
        */

        joinService.process(form); //에러없이 성공시 회원가입 처리

        // 응답코드 201, 출력 바디 없음
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/info/{email}")
    //이메일 기반으로 회원 정보 조회 하여 JSONData 형식으로 반환
    public JSONData info(@PathVariable("email")String email){
         //Content-Type: application/json
        Member member = mapper.get(email);

        return new JSONData(member); //회원정보 넘겨줌
    }

    @GetMapping("/list") //임의의 회원 목록을 생성하여 JSONData형식으로 반환
    public ResponseEntity<JSONData> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .password("12345678")
                        .userName("사용자" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();

        HttpHeaders headers = new HttpHeaders(); // 헤더
        headers.add("t1", "v1");
        headers.add("t2", "v2");

        return new ResponseEntity<>(new JSONData(members), headers, HttpStatus.OK);
    }



    @GetMapping(value = "/test", produces = "text/html;charset=UTF-8")
    public String test(){
        //content-type: text/plain
        return "안녕하세요!"; //문자열 경로를 반환하게 되면 문자열 그 자체를 반환
    }

    @GetMapping("/test2")
    public void test2(){
        log.info("test2.....");
    }

    //공통된 형식의 에러처리이기 때문에  통일성 있게 처리하도록 RestCommonControllerAdvice에 공통적인 에러처리 하도록 뺌
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<JSONData> errorHandler(Exception e){
//        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500
//
//        if(e instanceof CommonException commonException){
//            status = commonException.getStatus();
//        }
//
//        JSONData data = new JSONData();
//        data.setSuccess(false);
//
//        data.setMessage(e.getMessage());
//        data.setStatus(status);
//
//        e.printStackTrace();
//
//        return ResponseEntity.status(status).body(data);
//    }

}
