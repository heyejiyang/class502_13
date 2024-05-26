package board;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Board {
    private long seq;
    private String poster;
    private String subject;
    private String content;
    private LocalDate regDt;
    private  LocalDate modDt;

}
