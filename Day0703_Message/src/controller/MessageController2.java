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
@RequestMapping("/message2")
public class MessageController2 {

	@Autowired
	private MessageService service;
	
	@RequestMapping("/messageList2")
	@ResponseBody
	public Model messageList(Model model, @RequestParam(value="page", defaultValue="1")int page) {
		System.out.println(page);
		return model.addAttribute("data",service.getMessageList(page));
	}
	
	@RequestMapping("/write2")
	public String addMessage(@RequestParam Map<String, Object> param) {
		Message msg = new Message();
		
		msg.setName(param.get("guestName").toString());
		msg.setPassword(param.get("password").toString());
		msg.setMessage(param.get("message").toString());
		service.addMessage(msg);
		return "redirect:messageList2";
	}
	
	@RequestMapping(value ="/delete2", method = RequestMethod.GET)
	public String deleteForm(Model model, HttpServletRequest request) {
		System.out.println("삭제창");
		//삭제요청을 받았으니 비밀번호 확인창으로..
		model.addAttribute("id", request.getParameter("request"));
		return "confirmDeletion";
	}
	
	@RequestMapping("/pwCheck2")
	public String delete(HttpServletRequest request) {
		int result = service.deleteMessage(Integer.parseInt(request.getParameter("id")), request.getParameter("password"));
		if(result>0) {
			//삭제 성공
			return "redirect:messageList2";
		}else {
			//삭제 실패
			return "redirect:messageList2";
		}
	}
}
