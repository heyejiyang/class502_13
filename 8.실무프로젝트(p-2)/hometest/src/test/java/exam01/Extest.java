package exam01;

import board.Board;
import configs.DBConn;
import mappers.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Extest {
    private SqlSession session = DBConn.getSession();

    @Test
    void test1(){
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = Board.builder()
                .subject("제목")
                .content("내용")
                .build();

        List<Board> boards = mapper.getList3(board);
        boards.forEach(System.out::println);
    }
}
