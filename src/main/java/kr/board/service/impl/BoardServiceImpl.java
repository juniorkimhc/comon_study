package kr.board.service.impl;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;
import kr.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

    @Override
    public List<Board> select() {
        List<Board> list = mapper.getLists(); // 조회
        return list;
    }
    @Override
    public void insert(Board data) {
        mapper.boardInsert(data); // 등록
    }
    @Override
    public Board content(int idx) {
        Board data=mapper.boardContent(idx); //상세내용
        mapper.boardCount(idx); // 조회수 증가
        return data;
    }

    @Override
    public void delete(int idx) {
        mapper.boardDelete(idx); //삭제
    }

    @Override
    public Board updateForm(int idx) {
        Board data=mapper.boardContent(idx); // Form 화면 데이터 조회
        return data;
    }

    @Override
    public void update(Board data) {
        mapper.boardUpdate(data); // 수정
    }
}
