package org.choongang.board.entities;

// 뷰 카운트 저장할 엔티티

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class BoardView{
    @Id
    @EmbeddedId
    private BoardViewId id;
}

//@IdClass(BoardViewId.class)
//public class BoardView {
//    @Id
//    private long seq;
//    @Id
//    @Column(name = "_uid")
//    private int uid; //구분값
//    //두개를 조합해서 복합키 생성
//}
