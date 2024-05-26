package exam01;

import board.Board;
import configs.DBConn;
import mappers.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;

public class Ex03 {

    private SqlSession session = DBConn.getSession();

    @Test
    void test1(){
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = Board.builder()
                .seq(System.currentTimeMillis())
                .poster("USER10")
                .subject("게시글제목2")
                .content("게시글 내용2")
                .build();

       // int cnt = session.insert("mappers.BoardMapper.register",board);
        int cnt = mapper.register(board);
        System.out.println(cnt);
    }

    @Test
    void test2(){
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = Board.builder()
                .seq(1)
                .poster("USER09")
                .subject("게시글제목1")
                .content("게시글 내용2(수정)")
                .build();

        int cnt = mapper.modify(board);
        System.out.println(cnt);
    }
}
