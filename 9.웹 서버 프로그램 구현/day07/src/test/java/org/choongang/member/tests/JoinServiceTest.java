package org.choongang.member.tests;

import com.github.javafaker.Faker;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.choongang.global.configs.DBConn;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.exceptions.DuplicatedMemberException;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;
import org.choongang.member.validators.JoinValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) //모의객체 사용
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    private JoinService joinService;
    private MemberMapper mapper;
    @BeforeEach
    void init(){
        joinService = MemberServiceProvider.getInstance().joinService();
        //객체 조립기에서 joinService 객체 생성한것 넘겨줌
        mapper = DBConn.getSession().getMapper(MemberMapper.class);
        //MemberMapper에 있는 sql내용? DB에 저장되어있는 member 테이블 데이터들 담겨있음 자동커밋
    }

    /*
    RequestJoin -> DTO(데이터전달)
    계층 간에 데이터를 전달하기 위한 객체
    서비스 계층과 데이터베이스 계층 간의 데이터를 주고받는 데 사용
     */
    RequestJoin getData(){
        Faker faker = new Faker(Locale.ENGLISH); //가짜 데이터 -> 영어로
        RequestJoin form = RequestJoin //각 변수에 가짜 데이터 넣어줌
                .builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8}").toLowerCase())
                .userName(faker.name().fullName())
                .termsAgree(true)
                .build();
        form.setConfirmPassword(form.getPassword());
        return form; //getData는 가짜로 생성한 객체 데이터 담고있음
    }

    @Test
    @DisplayName("회원가입 성공시 예외가 발생하지 않음")
    void successTest() {
        RequestJoin form = getData(); //가짜 데이터 객체 가져옴
        assertDoesNotThrow(() -> { //예외가 발생하지 않으면 통과
            joinService.process(form); //joinValidator -> check 에서 예외발생하지않으면 검증 성공
            //check -> 필수항목 검증 과정 다 담겨있음, check 검증이 다통과되면 여기도 통과되는것
        });
        //가입된 이메일로 회원이 조회 되는지 체크
        Member member = mapper.get(form.getEmail());
        //getEmail -> form에서 내가 넣은 가상 데이터가 db테이블에서 조회가 되는지 get을 통해서 DB테이블 전체 조회 수행 (가입되어있다면 get에서 조회가 된다)
        //get은 참조자료형이 Member임으로 Member객체에 대입될 수 있다.

        assertEquals(form.getEmail(),member.getEmail());
        //기대값은 form.getEmail(), 실제 값은 member.getEmail()
        //form에 넣은 이메일과 db테이블에서 얻은 이메일 값이 동일한지 비교 후 같으면 true로 통과
    }

    @Test
    @DisplayName("필수 입력항목(이메일, 비밀번호, 비밀번호확인, 회원명, 약관동의)검증, 검증 실패시 BadRequestException발생")
    void requiredFieldTest(){
        //문제가 있는 경우 상황에 따라서 응답코드 던져주기
        //Bad request -> 400
//        assertThrows(BadRequestException.class, ()->{ //예외 발생해야 통과됨
//            RequestJoin form = getData();
//            form.setEmail(null);
//            joinService.process(form);
//        });
        assertAll( //모든 검증 실행, 실행 결과로 검증에 실패한 코드가 있다면 그 목록을 모아서 에러 메시지로 보여준다.
                () -> requiredEachFieldTest("email", true,"이메일"),
                () -> requiredEachFieldTest("email",false,"이메일"),
                () -> requiredEachFieldTest("password", true,"비밀번호"),
                () -> requiredEachFieldTest("password",false,"비밀번호"),
                () -> requiredEachFieldTest("confirmPassword",true,"비밀번호를 확인"),
                () -> requiredEachFieldTest("confirmPassword",false,"비밀번호를 확인"),
                () -> requiredEachFieldTest("userName",true,"회원명"),
                () -> requiredEachFieldTest("userName",false,"회원명"),
                () -> requiredEachFieldTest("termsAgree",false,"약관")
        );
    }

    void requiredEachFieldTest(String field, boolean isNull, String keyword){
       BadRequestException thrown = assertThrows(BadRequestException.class,()->{
           //assertThrows 지정한 타입의 익셉션이 발생하면 테스트 통과
           //두번째 매개변수의 결과가 BadRequestException이 발생하면 통과되는 것
           RequestJoin form = getData(); //만들어둔 가짜 데이터 객체 삽입

           if(field.equals("email")){ //첫번째 람다식으로 보자면 isNull이 true일 경우 setEmail에 email은 null 값이 대입되고 false일 경우 빈값이 대입되서 예외 발생
                form.setEmail(isNull?null:"    ");
            }else if(field.equals("password")){
                form.setPassword(isNull?null:"    ");
            }else if(field.equals("confirmPassword")){
                form.setConfirmPassword(isNull?null:"    ");
            }else if(field.equals("userName")){
               form.setUserName(isNull?null:"    ");
            }else if(field.equals("termsAgree")){
                form.setTermsAgree(false);
            }
           joinService.process(form); //check에서 필수항목 검증시 checkedRequired -> 빈값이나 null 값 검증 하면 예외 발생 -> BadRequestException 발생
        }, field+" 테스트");

       String message = thrown.getMessage(); //던저진 예외 객체에서 예외 message 저장
       assertTrue(message.contains(keyword),field+" 키워드 테스트");
       //true가 나오면 통과
       //message 객체에 keyword가 포함되어 있는지 확인 -> true여야 테스트 성공
        //두번째 매개변수: 조건이 false일 경우 출력될 메시지
    }

    @Test
    @DisplayName("비밀번호와 확인이 일치하지 않으면 BadRequestException 발생")
    void passwordMismatchTest(){
        BadRequestException thrown = assertThrows(BadRequestException.class,() ->{
           RequestJoin form = getData();
           form.setConfirmPassword(form.getPassword()+"**");
           joinService.process(form);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("비밀번호가 일치하지"));
    }

    @Test
    @DisplayName("이메일이 형식에 맞지 않으면 BadRequestException 발생")
    void emailPatternTest(){
        BadRequestException thrown = assertThrows(BadRequestException.class,()->{
           RequestJoin form = getData();
           form.setEmail("*****");
           joinService.process(form);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 형식이"));
    }

    @Test
    @DisplayName("비밀번호 자리수가 8자리 미만이면 BadRequestException 발생")
    void passwordLengthTest(){
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            Faker faker = new Faker();
            RequestJoin form = getData();
            form.setPassword(faker.regexify("\\w{3,7}").toLowerCase());
            form.setConfirmPassword(form.getPassword());
            joinService.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("8자리 이상"));
    }

    @Test
    @DisplayName("이미 가입된 메일인 경우 DuplicatedMemberException 발생")
    void duplicateEmailTest() {
        MemberServiceProvider provider = MemberServiceProvider.getInstance();
        assertThrows(DuplicatedMemberException.class, () -> {
            RequestJoin form = getData();
            provider.joinService().process(form);
            provider.joinService().process(form);
        });
    }

}
