package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CommonFilter - 요청 전");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("COmmonFilter - 응답 후");
    }
}
