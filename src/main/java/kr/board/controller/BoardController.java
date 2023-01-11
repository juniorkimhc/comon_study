package kr.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.board.service.BoardService;
import kr.board.service.impl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController{

	@Autowired
	private BoardServiceImpl service;

	// HandlerMapping
	@RequestMapping("/boardList.do")
	public String boardList(/*@RequestParam Map map,*/Model model) {
		List<Board> boardList= service.select();
		model.addAttribute("list",boardList);
		return "boardList"; // /WEB-INF/views/boardList.jsp -> forward
	}

	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm"; // /WEB-INF/views/boardForm.jsp -> forward
	}

	@PostMapping("/boardInsert.do")
	public String boardInsert(Board data) { // title, content, writer => 파라메터수집(Board)
		service.insert(data);
		return "redirect:/boardList.do"; // redirect
	}

	@GetMapping("/boardContent.do")
	public String boardContent(int idx, Model model) { // ?idx=6
		Board vo=service.content(idx);
		model.addAttribute("vo", vo); // ${vo.idx}...
		return "boardContent"; // boardContent.jsp
	}
	@GetMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) { // ?idx=6
		service.delete(idx);
		return "redirect:/boardList.do";
	}	
	@GetMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {
		Board data=service.updateForm(idx);
		model.addAttribute("vo",data);
		return "boardUpdate"; // boardUpdate.jsp
	}
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board data) { // idx, title, content
		service.update(data);
		return "redirect:/boardList.do";
	}

}
