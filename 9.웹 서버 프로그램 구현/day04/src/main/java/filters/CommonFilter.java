package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //최초 한번만 호출
        System.out.println("init()");
        String key1 = filterConfig.getInitParameter("key1");
        String key2 = filterConfig.getInitParameter("key2");
        System.out.printf("key1 = %s, key2 = %s,\n", key1, key2);
    }

    @Override
    public void destroy() {
        //소멸 직전 호출
        System.out.println("destroy()");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("CommonFilter - 요청 전");
        filterChain.doFilter(new CommonRequestWrapper(servletRequest),servletResponse);
        //System.out.println("COmmonFilter - 응답 후");
    }

}
