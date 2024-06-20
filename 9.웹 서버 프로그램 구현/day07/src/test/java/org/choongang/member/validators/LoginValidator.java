package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator { //검증하고자하는 전달 객체 지네릭 타입으로 선언
    //RequiredValidator 에는 null이거나 빈값일때 예외처리 메서드, 참인지 체크하는 메서드 들어있음(참이 아니면 예외던짐) (checkedRequired, checkTrue)

    private MemberMapper mapper;

    public LoginValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void check(HttpServletRequest form) {
        String email = form.getParameter("email");
        String password = form.getParameter("password");

        //필수항목 검증
        //null값 빈값 검증
        checkRequired(email,new BadRequestException("이메일을 입력하세요."));
        checkRequired(password,new BadRequestException("비밀번호를 입력하세요"));

        //이메일로 회원이 조회되는지 검증
        String message ="이메일 또는 비밀번호가 일치하지 않습니다.";
        Member member = mapper.get(email);
        //회원이 조회 안되면 null값임
        checkTrue(member != null, new BadRequestException(message));
        /*
        주의 할 점은 예측 불가능성을 줘야함
        아이디가 틀렸습니다 하면 비번이 맞다는걸 알아채고
        비밀번호가 틀렸습니다 하면 아이디는 맞다는걸 알아챌 수 있기 때문! 보안적인 측면
        * */

    }
}
