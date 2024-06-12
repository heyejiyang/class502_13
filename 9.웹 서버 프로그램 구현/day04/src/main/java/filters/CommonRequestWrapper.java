package filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {

    public CommonRequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request); //HttpServletRequestWrapper에 기본생성자가 없이 매개변수가 있는 생성자가 존재하기 때문에 super에 매개변수 추가해줘야함

        //요청 전 공통 처리 부분
        System.out.println("요청 전 공통 처리 코드 ...");
    }
}
