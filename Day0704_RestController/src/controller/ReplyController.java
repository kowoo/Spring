package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Reply;
import service.ReplyService;

@Controller
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	/*요청 정리
	 * 덧글 등록 /replies method : post
	 * 덧글 수정 /replies/{replyNum} method : post
	 * 덧글 삭제 /replies/{replyNum} method : delete
	 * 덧글 목록 /replies/all/{boardNum} method : get 
	 * */
	
	//등록요청 처리 //value=""로 적어주면 컨트롤러 클래스에 적어놓은 url로 처리
	
	//ResponseEntity
	//응답할 때, 요청 처리 코드와 데이터를 함께 전달
	//메서드의 반환형은 ResponseEntity<T>
	//원래 반환 데이터가 boolean이면 ResponseEntity<Boolean>으로 처리
	
	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.POST)
	public boolean register(Reply reply) {
		//파라미터로 전달 받은 데이터 isert하고 결과에 따라서 true, false 반환
		System.out.println("작성 요청");
		boolean result = replyService.addReply(reply);
		if(result) {
			return true;
		} else {
			return false;
		}
	}
	//board?num=21 요청url+요청파라미터, post 방식시 요청 url board
	//Rest형태의 요청 처리하기, 요청 url에 자원 또는 요청에 대한 정보가 모두 포함
	//ex) board/21
	//url 자체에 포함된 변수 데이터를 받아오기 위해서 @PathVariable
	@ResponseBody
	@RequestMapping(value="/all/{boardNum}", method=RequestMethod.GET)
	public List<Reply> list(@PathVariable("boardNum") int boardNum) {
		System.out.println(boardNum+"번 게시글 덧글 목록 호출");
		return replyService.getBoardReply(boardNum);
	}
	
	

	@ResponseBody		//이렇게 되면 /replyNum/21 이라는 요청이 왔을 때 replyNum이라는 요청을 update 메서드가 처리하면서 매개변수인 replyNum을 21로 받게 된다. 
	@RequestMapping(value="/{replyNum}", method=RequestMethod.POST) //value 중괄호에 적어놓은 녀석을 PathVariable에 넣어주면 된다.
	public ResponseEntity<String> update(@PathVariable("replyNum") int replyNum, String replyContent) {
		System.out.println("수정 요청");
		Reply reply = new Reply();
		reply.setReplyNum(replyNum);
		reply.setReplyContent(replyContent);
//		replyService.modifyReply(reply);
		ResponseEntity<String> entity = null;
		if(replyService.modifyReply(reply)) {
			//응답에 전달할 데이터, 요청상태 코드
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@ResponseBody
	@RequestMapping(value="{replyNum}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable("replyNum") int replyNum) {
		System.out.println("삭제 요청");
		return replyService.removeReply(replyNum);
	}	
	
}
