package exam01;

import board.Board;
import configs.DBConn;
import mappers.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Ex02 {

    @Test
    void test1(){
        SqlSession session = DBConn.getSession();
        List<Board> boards = session.selectList("mappers.BoardMapper.getList");
        boards.forEach(System.out::println);
    }

    //mapper 인터페이스 사용
    @Test
    void test2(){
        SqlSession session = DBConn.getSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        List<Board> boards = mapper.getList();
        boards.forEach(System.out::println);
    }


    //인터페이스에 직접 별칭 지정
    @Test
    void test3(){
        SqlSession session = DBConn.getSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        List<Board> boards = mapper.getList2();
        boards.forEach(System.out::println);
    }
}
