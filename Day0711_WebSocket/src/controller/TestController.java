package controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Message;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String webSocketForm() {
		return "webSocketEx2";
	}
	
	@RequestMapping("/stomp")
	public String stompForm() {
		return "stomp";
	}
	
	@CrossOrigin
	@MessageMapping("/greeting/{memberid}/{targetid}")
	@SendTo("/topic/msg/{targetid}") //타겟 id가 채팅방 번호라면 채팅방에 들어와있는 사람한테도 보내게 할 수 있겠지?
	public Message stompTest(@DestinationVariable(value="memberid") String memberid, @DestinationVariable(value="targetid") String targetid, String message) {
		//특정한 주소로 메시지를 받았을 때 실행된다.
		
		// /client/greeting
		// /client : servlet-context에 application-destination-prefix로 선언 됨
		System.out.println("memberid : " + memberid);
		System.out.println("targetid : " + targetid);
		System.out.println("message : " + message);
		Message msg = new Message();
		msg.setBody(message);
		return msg;
	}
}

