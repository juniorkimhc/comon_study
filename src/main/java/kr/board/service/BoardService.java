package kr.board.service;

import kr.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BoardService {

    List<Board> select();
    void  insert(Board data);
    Board content(int idx);
    void delete(int idx);
    Board updateForm(int idx);
    void update(Board data);

}
