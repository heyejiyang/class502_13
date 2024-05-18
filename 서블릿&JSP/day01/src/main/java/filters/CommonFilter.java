package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

//        HttpServletRequest request = (HttpServletRequest)req;
//
//        String method = request.getMethod().toUpperCase();
//        if(method.equals("POST")){
//            request.setCharacterEncoding("UTF-8");
//        }
        filterChain.doFilter(new CommonRequestWrapper(req), new CommonResponseWrapper(resp));

    }
}
