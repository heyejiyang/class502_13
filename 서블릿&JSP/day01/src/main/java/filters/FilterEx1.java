package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterEx1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterEx1 - 요청 전");
        filterChain.doFilter(servletRequest,servletResponse);
        //다음 필터를 체크하게되고 있으면 넘어가고 없으면 마지막으로 응답을 하게된다.
        System.out.println("FleterEx1 - 요청 후");
    }
}
