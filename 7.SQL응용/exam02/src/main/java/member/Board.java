package member;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Board {
    private int seq;
    private final String subject; //초기화됨
    private  final String content;
    private String poster;
}
