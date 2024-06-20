package org.choongang.global;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;

import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtil {

    public static void alertError(Exception e, HttpServletResponse resp)throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        if(e instanceof CommonException commonException){ //밑 주석과 같은 기능...
           // CommonException commonException = (CommonException)e;
            resp.setStatus(commonException.getStatus()); //응답코드 400
        }
        //스크립트태그형태로 화면 출력
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>", e.getMessage());
    }
    public static void go(String url, String target, HttpServletResponse resp) throws IOException {
        //타겟이 없는 경우 기본값 설정
        target = target == null || target.isBlank() ? "self":target;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>%s.location.href='%s';</script>", url, target);
    }
    public static void go(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        go(url,"self",resp);
    }

}
