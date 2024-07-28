package org.boardTest.board.repositories;

import org.boardTest.board.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>{

}
