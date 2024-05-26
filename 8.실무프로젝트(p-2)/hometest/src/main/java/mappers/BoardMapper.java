package mappers;

import board.Board;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

    List<Board> getList();

    @Select("SELECT SEQ seq, POSTER poster, SUBJECT subject FROM BOARD")
    List<Board> getList2();

    List<Board> getList3(Board board);
    List<Board> getList4(List<String> poster);
    List<Board> getList5(long seq);
    int register(Board board);
    int register2(Board board);

    int modify(Board board);
}
