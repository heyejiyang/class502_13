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
                .poster("USER"+System.currentTimeMillis())
                .subject("게시글제목1")
                .content("게시글 내용4")
                .build();

       // int cnt = session.insert("mappers.BoardMapper.register",board);
        int cnt = mapper.register2(board);
        System.out.println(cnt);
        System.out.println(board);
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

    //삭제
    @Test
    void test3(){
        Board board = Board.builder()
                .seq(1)
                .build();
        int cnt = session.delete("mappers.BoardMapper.delete",board);
        System.out.println(cnt);
    }
}
