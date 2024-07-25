package org.choongang.board.repositories;

import org.choongang.board.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> { //첫 번째에는 엔티티 타입 클래스를, 두 번째는 기본키 타입

}
