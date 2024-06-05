package tests;

import global.exceptions.ValidationException;
import member.controllers.RequestJoin;
import member.services.JoinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("회원가입기능 테스트")
public class JoinServiceTest { //테스트 한번에 실행

    @Test
    @DisplayName("회원가입 성공시 예외 발생 없음")
    public void successTest(){
        assertDoesNotThrow(()->{ //실행 코드 실행시 예외가 발생하지 않으면 통과
            JoinService service = new JoinService();
            RequestJoin form = RequestJoin.builder().build();;
            service.process(form);
        });//함수형 인터페이스
    }

    @Test
    @DisplayName("필수항목(이메일, 비밀번호, 비밀번호 확인, 회원명) 검증, 검증 실패시 ValidationException 발생")
    void requiredFieldTest() {
        /*이메일 필수 검증 S*/
        //잘못된 데이터 들어왔을때 예상 예외 클래스에서 예외발생 여부 체크
        assertThrows(ValidationException.class, () ->{
            RequestJoin form = RequestJoin.builder().build();
            JoinService service = new JoinService();
            service.process(form);
        });
        /*이메일 필수 검증 E*/
    }

}
