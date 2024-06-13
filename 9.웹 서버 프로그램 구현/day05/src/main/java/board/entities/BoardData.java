package board.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardData { //DB에서 조회후 가져온 데이터라고 가정
    private long seq; //게시글 번호
    private String subject;
    private String content;
    private String poster;
    private LocalDateTime regDt; //작성일자
}

