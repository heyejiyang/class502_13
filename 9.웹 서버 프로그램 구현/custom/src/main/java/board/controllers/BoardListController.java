package board.controllers;

import board.entities.BoardData;
import board.services.BoardInfoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/list/*")
public class BoardListController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardInfoService service = new BoardInfoService();
        List<BoardData> items = service.getList();

        req.setAttribute("items", items); //속성을 통해서 넘겨준다.

        // css, javascript 동적으로 레이아웃쪽에 포함될 수 있게한다.
        req.setAttribute("addCss", new String[] {"board/style","board/list"}); //자동추가
        req.setAttribute("addScript",List.of("board/common","board/list"));
        /*
        스타일은
        List<String>, String[]
        Set<String>
        형태로 추가할 수 있다.
         */

        //속성 설정은 RequestDispatcher 상단에 정의해야한다.
        //출력 완료 되면 속성은 반영되지 않기 때문
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/board/list.jsp");
        rd.forward(req, resp);
    }
}
