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
    @DisplayName("필수항목(이메일, 비밀번호, 비밀번호 확인, 회원명) 검증, 검증 실패시 ValidationException 발생")
    void requiredFieldTest() {//잘못된 데이터 들어왔을때 예상 예외 클래스에서 예외발생 여부 체크
        /*이메일 필수 검증 S*/
        assertThrows(ValidationException.class, () -> {
            RequestJoin form = getData();
            form.setEmail(null); //null체크
            joinService.process(form);

            form.setEmail("    "); //빈문자 체크
            joinService.process(form);
        });
        /*이메일 필수 검증 E*/

        /*비밀번호 필수 검증 S*/
        assertThrows(ValidationException.class, () ->
        {
            RequestJoin form = getData();
            form.setPassword(null); //null체크
            joinService.process(form);

            form.setPassword("    "); //빈문자 체크
            joinService.process(form);
        });
        /*비밀번호 필수 검증 E*/
    }
}
