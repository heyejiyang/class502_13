package org.choongang.global;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;

import java.io.IOException;
import java.io.PrintWriter;

//알림메시지를 표시하거나 페이지를 이동시키는데 사용
public class MessageUtil {
    public static void alertError(Exception e, HttpServletResponse resp) throws IOException {
        //예외 발생시 클라이언트에게 자바스크립트 경고창을 통해 에러메시지를 표시함

        resp.setContentType("text/html; charset=UTF-8");
        //응답 콘텐츠 타입 설정

        if (e instanceof CommonException commonException) {
            //예외가 CommonException 인스턴스인지 확인하고, 맞다면 응답 상태 코드를 해당 예외의 상태 코드로 설정
            // CommonException commonException = (CommonException)e;
            resp.setStatus(commonException.getStatus());
        }
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>", e.getMessage());
        //PrintWriter를 사용하여 JavaScript 경고 창을 통해 예외 메시지를 출력
    }

    //클라이언트를 지정된 URL로 이동시키는 메서드
    //url: 이동할 URL, target: 이동할 브라우저 창 또는 프레임의 이름
    public static void go(String url, String target, HttpServletResponse resp) throws IOException {
        target = target == null || target.isBlank() ? "self" : target;
        //target이 null이거나 공백일경우 기본값으로 self사용
        /**
         * 자바스크립트에서의 창 및 프레임 지정
         * self - 현재 창 또는 프레임을 나타냅니다
         * parent - 현재 프레임의 부모 창을 나타냅니다. 프레임 내부에서 parent를 사용하면 프레임을 감싸고 있는 상위 창을 의미
         * top - 최상위 창(가장 바깥쪽 창)을 나타냅니다. 여러 레벨의 프레임이 중첩되어 있어도 최상위 창을 의미
         */

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        /**
         * location.href : 주소 이동시 이동 기록이 남는다, 뒤로가 버튼을 누른 경우
         * POST 처리가 중복 된다.
         * POST 처리시 이동할때는 기록을 남기지 않는 이동 방식 location.replace(..)
         */
        //out.printf("<script>%s.location.href='%s';</script>", target, url);
        out.printf("<script>%s.location.replace('%s');</script>", target, url);
        //location.replace를 사용하여 이동 기록을 남기지 않고 URL을 변경
    }

    public static void go(String url, HttpServletResponse resp) throws IOException {
        go(url, "self", resp);
        //클라이언트를 지정된 URL로 이동시키며, 기본 target을 "self"로 설정
    }
}