package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Board;
import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/start")
	public String start() {
		System.out.println("게시글 목록 페이지 이동");
		return "redirect:boardList";
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Board> list() {
		System.out.println("게시글 목록 호출");
		return service.getAllBoardList();
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "boardWrite";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Board board) {
		System.out.println(board);
		service.addBoard(board);
		return "boardList";
	}
}
