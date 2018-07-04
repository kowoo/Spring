package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ReplyService;

@Controller
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	/*요청 정리
	 * 덧글 등록 /replies method : post
	 * 덧글 수정 /replies/{replyNum} method : post
	 * 덧글 삭제 /replies/{replyNum} method : delete
	 * 덧글 목록 /replies/all/{boardNum} method : get 
	 * */
	
	//등록오쳥 처리 //value=""로 적어주면 컨트롤러 클래스에 적어놓은 url로 처리
	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.POST)
	public boolean register(Map<String, Object> reply, HttpServletRequest req) {
		//파라미터로 전달 받은 데이터 isert하고 결과에 따라서 true, false 반환
		System.out.println("reply : " + reply);
		Map<String, Object> tmp = new HashMap<String, Object>();
		tmp.put("boardNum", req.getParameter("boardNum"));
		tmp.put("replyWriter", req.getParameter("replyWriter"));
		tmp.put("replyContent", req.getParameter("replyContent"));
		System.out.println(req.getParameter("replyWriter"));
		boolean result = service.addReply(tmp);
		System.out.println("성공");
		if(result) {
			return true;
		} else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping(value="/all/{boardNum}", method=RequestMethod.GET)
	public List<Map<String, Object>> list(@PathVariable("boardNum") int boardNum) {
		System.out.println(boardNum+"번 게시글 덧글 목록 호출");
		return service.getBoardReply(boardNum);
	}
	
	
	
	//board?num=21 요청url+요청파라미터, post 방식시 요청 url board
	//Rest형태의 요청 처리하기, 요청 url에 자원 또는 요청에 대한 정보가 모두 포함
	//ex) board/21
	//url 자체에 포함된 변수 데이터를 받아오기 위해서 @PathVariable
	@ResponseBody		//이렇게 되면 /replyNum/21 이라는 요청이 왔을 때 replyNum이라는 요청을 update 메서드가 처리하면서 매개변수인 replyNum을 21로 받게 된다. 
	@RequestMapping(value="/{replyNum}", method=RequestMethod.POST) //value 중괄호에 적어놓은 녀석을 PathVariable에 넣어주면 된다.
	public boolean update(@PathVariable("replyNum") int replyNum) {
		
		return false;
	}
	@ResponseBody
	@RequestMapping(value="/{replyNum}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable("replyNum") int replyNum) {
		
		return false;
	}	
	
}
