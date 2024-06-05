package tests;

import global.exceptions.ValidationException;
import global.validators.Validator;
import member.controllers.RequestJoin;
import member.services.JoinService;
import member.validators.JoinValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("회원가입기능 테스트")
public class JoinServiceTest { //테스트 한번에 실행

    private JoinService joinService;

    @BeforeEach
    void init() { //테스트 실행때마다 객체 생성
        joinService = new JoinService(new JoinValidator());
    }

    RequestJoin getData() {
        //회원가입시 이상 없는 형태의 데이터 넣어주기
        return RequestJoin.builder()
                .email("test" + System.currentTimeMillis() + "@test.org") //중복 안되게 난수형태로
                .password("12345678") //비밀번호 8자리
                .confrimPw("12345678")
                .userName("나이름")
                .termsAgree(true)
                .build();
    }

    @Test
    @DisplayName("회원가입 성공시 예외 발생 없음")
    public void successTest() {
        assertDoesNotThrow(() -> { //실행 코드 실행시 예외가 발생하지 않으면 통과
            joinService.process(getData());
        });//함수형 인터페이스
    }

    @Test
    @DisplayName("필수항목(이메일, 비밀번호, 비밀번호 확인, 이름, 약관동의) 검증, 검증 실패시 ValidationException 발생")
    void requiredFieldTest() {//잘못된 데이터 들어왔을때 예상 예외 클래스에서 예외발생 여부 체크
//        /*이메일 필수 검증 S*/
//       ValidationException thrown = assertThrows(ValidationException.class, () -> {
//            RequestJoin form = getData();
//            form.setEmail(null); //null체크
//            joinService.process(form);
//
//            form.setEmail("    "); //빈문자 체크
//            joinService.process(form);
//        });
//        String message = thrown.getMessage(); //발생한 예외메시지
//        assertTrue(message.contains("이메일"));
//        /*이메일 필수 검증 E*/
//
//        /*비밀번호 필수 검증 S*/
//       thrown =  assertThrows(ValidationException.class, () ->
//        {
//            RequestJoin form = getData();
//            form.setPassword(null); //null체크
//            joinService.process(form);
//
//            form.setPassword("    "); //빈문자 체크
//            joinService.process(form);
//        });
//        message = thrown.getMessage();
//        assertTrue(message.contains("비밀번호"));
//        /*비밀번호 필수 검증 E*/
//
        //이메일 필수 체크 - null, 빈값 S
//        RequestJoin form = getData();
//        form.setEmail(null);
//        requiredFieldEachTest(form, "이메일");
//        form.setEmail("   ");
//        requiredFieldEachTest(form, "이메일");
//        //이메일 필수 체크 - null, 빈값 E
//
//        //비밀번호 필수 체크 - null, 빈값 S
//        form = getData();
//        form.setPassword(null);
//        requiredFieldEachTest(form,"비밀번호");
//        form.setPassword("   ");
//        requiredFieldEachTest(form, "비밀번호");
//        //비밀번호 필수 체크 - null, 빈값 E
        assertAll(
                //이메일 검증
                () -> {
                    RequestJoin form = getData();
                    form.setEmail(null);
                    requiredFieldEachTest(form,"이메일");

                    form.setEmail("   ");
                    requiredFieldEachTest(form,"이메일");
                },
                //비밀번호 검증
                () -> {
                    RequestJoin form = getData();
                    form.setPassword(null);
                    requiredFieldEachTest(form,"비밀번호");

                    form.setPassword("   ");
                    requiredFieldEachTest(form,"비밀번호");
                },
                //비밀번호 확인 검증
                () -> {
                    RequestJoin form = getData();
                    form.setConfrimPw(null);
                    requiredFieldEachTest(form,"비밀번호를 확인");

                    form.setConfrimPw("   ");
                    requiredFieldEachTest(form,"비밀번호를 확인");
                },
                //회원 이름 검증
                () -> {
                    RequestJoin form = getData();
                    form.setUserName(null);
                    requiredFieldEachTest(form,"이름");

                    form.setUserName("   ");
                    requiredFieldEachTest(form,"이름");
                },
                //약관 동의 검증
                () -> {
                    RequestJoin form = getData();
                    form.setTermsAgree(false);
                    requiredFieldEachTest(form,"약관에 동의");
                }
        );
    }

    void requiredFieldEachTest(RequestJoin form, String keyword) {
        ValidationException thrown = assertThrows(ValidationException.class, () -> {
            joinService.process(form);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains(keyword));
    }

    @Test
    @DisplayName("비밀번호와 비밀번호 확인 일치 테스트, 검증 실패시 ValidationException 발생")
    void passwordMatchTest(){

    }

    @Test
    @DisplayName("이메일 중복 여부 테스트, 검증 실패시 DuplicatedMemberException 발생")
    void duplicateEmailTest(){

    }

    @Test
    @DisplayName("회원 가입 완료 후 실제 데이터베이스에서 조회 되는지 검증")
    void memberExistsTest(){
        //가입 처리

        //getData()로 생성한 데이터의 email항목으로 DB조회

        //조회한 회원 데이터 email과 getData()로 생성한 email이 일치하는지 체크
        //assertEquals(...)

    }
}
