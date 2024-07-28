package org.boardTest.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.boardTest.board.entities.BoardData;
import org.boardTest.board.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class Ex01 {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @BeforeEach
    void init(){
//        BoardData boardData = BoardData.builder()
//                .subject("제목1")
//                .content("내용내요용")
//                .writer("장작성")
//                .build();
//        boardDataRepository.saveAndFlush(boardData);

        List<BoardData> items = IntStream.rangeClosed(1,5)
                        .mapToObj(i -> BoardData.builder()
                                .subject("제목"+i)
                                .content("내용"+i)
                                .writer("작성자"+i)
                                .build()).toList();

        boardDataRepository.saveAllAndFlush(items);

        em.clear();
    }

    @Test
    void test1(){ //조회
        BoardData bd = boardDataRepository.findById(1L).orElse(null);
        System.out.println(bd);

        List<BoardData> boards = boardDataRepository.findAll();
        boards.forEach(System.out::println);

        System.out.println(bd.getCreatedAt());

    }

    @Test
    void test2(){ //수정
        List<BoardData> boards = boardDataRepository.findAll();

        BoardData bd = boardDataRepository.findById(2L).orElse(null);

        boards.forEach(System.out::println);
        System.out.println(bd.getCreatedAt());

        bd.setSubject("두번째 작성자");
        bd.setModifiedAt(LocalDateTime.now());

        boardDataRepository.saveAndFlush(bd);

        boards.forEach(System.out::println);
        System.out.println(bd.getModifiedAt());

    }

    @Test
    void test3(){ //삭제
        BoardData bd = boardDataRepository.findById(1L).orElse(null);

        boardDataRepository.delete(bd);
        boardDataRepository.flush();

        List<BoardData> boards = boardDataRepository.findAll();
        boards.forEach(System.out::println);
    }

}
