package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Message;
import service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService service;
	
	@RequestMapping("/messageList")
	public String messageList(Model model, @RequestParam(value="page", defaultValue="1")int page) {
		System.out.println(page);
		model.addAttribute("viewData",service.getMessageList(page));
		return "messageList";
	}
	
	@RequestMapping("/write")
	public String addMessage(@RequestParam Map<String, Object> param) {
		Message msg = new Message();
		msg.setName(param.get("guestName").toString());
		msg.setPassword(param.get("password").toString());
		msg.setMessage(param.get("message").toString());
		service.addMessage(msg);
		return "redirect:messageList";
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public String deleteForm(Model model, HttpServletRequest request) {
		System.out.println("삭제창");
		//삭제요청을 받았으니 비밀번호 확인창으로..
		model.addAttribute("id", request.getParameter("request"));
		return "confirmDeletion";
	}
	
	@RequestMapping("/pwCheck")
	public String delete(HttpServletRequest request) {
		int result = service.deleteMessage(Integer.parseInt(request.getParameter("id")), request.getParameter("password"));
		if(result>0) {
			//삭제 성공
			return "redirect:messageList";
		}else {
			//삭제 실패
			return "redirect:messageList";
		}
	}
}
