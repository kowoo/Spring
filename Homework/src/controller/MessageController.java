package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.MessageService;

@Controller
public class MessageController {

	@Autowired
	MessageService msgService;
	
	@RequestMapping(value="/message", method=RequestMethod.GET)
	public String messageForm(@RequestParam String receiver, Model model) {
		System.out.println("메시지폼 요청");
		model.addAttribute("receiver", receiver);
		return "message";
	}
	@RequestMapping(value="/message", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String message(HttpSession session, @RequestParam Map<String, Object> msg ,Model model) {
		String sender = (String) session.getAttribute("userid");
		msg.put("sender", sender);
		System.out.println(msg);
		if(msgService.addMsg(msg)) {
			System.out.println("메시지 전송 성공");
		}else {
			System.out.println("메시지 전송 실패");
			return null;
		}
		return "redirect:main";
	}
	
	//HttpSession session, Model model
	
	//메시지 보내기
	//메시지 전체조회
	//메시지 조회
	//메시지 삭제
	
}
