package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyHandler extends TextWebSocketHandler {
	//클라이언트당 하나의 WebSocketSession이 생성되어 다른 클라이언트에게 메시지 전달하기 위해
	//클라이언트의 WebSocketSession을 리스트로 관리한다.
	
	//특정한 사용자에게 메시지를 보내려면? 특정한 사용자가 어떤 session을 가지고 있는지 알아야한다.
	
	
	private List<WebSocketSession> connectedUser;
	//사용자가 저장될 맵
	private Map<String, WebSocketSession> usersMap;
	
	public MyHandler() {
		connectedUser = new ArrayList<WebSocketSession>();
		usersMap = new HashMap<String, WebSocketSession>();
	}
	
	//연결요청 처리, 메시지 받기, 메시지 전달
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("TextWebSocketHandler : 연결 생성");
		//연결 되었으니 해당 웹소켓 세션을 리스트에 넣는다!
		connectedUser.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//받은 메시지를 보냄!
		
//		System.out.println("TextWebSocketHandler : 메시지 받음");
//										받은 메시지 문자열만 추출.
//		System.out.println("message : " + message.getPayload());
		
		System.out.println("message : " + message.getPayload());
		
		//id값을 받은 경우 JSON 파싱 JsonParser이랑은 다름. JSONParser (json-simple 디펜던시)
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject)parser.parse(message.getPayload());
		System.out.println(json.get("type"));
		
		if(json.get("type") != null && json.get("type").equals("register")) {
			//사용자 등록 : 사용자가 보낸 id랑 session 짝 맞춰주기.
			usersMap.put(json.get("memberid").toString(), session);
		}else {
			//특정 사용자에게 메시지 전달!
			//클라이언트에서 메시지를 보낼 사용자 id를 줘야한다.
			String targetUser = json.get("target").toString();
			WebSocketSession targetSession = usersMap.get(targetUser);
			//System.out.println(json.get("message").toString());
			String msg=null;
			
			for(String a: usersMap.keySet()) {
				if(usersMap.get(a).equals(session)) {
					msg = a+" : "+json.get("message").toString();
				}
			}
			if(targetSession != null) {
				targetSession.sendMessage(new TextMessage(msg));
				
				return;
			}
			
			//메시지 전달
			for(WebSocketSession s : connectedUser) {
				if(s!=session) {
					s.sendMessage(new TextMessage(message.getPayload()));
				}
			}
//			//메시지 받고 전달
//			for(WebSocketSession s : connectedUser) {
//				if(s!=session) {
//					s.sendMessage(new TextMessage(message.getPayload()));
//				}
//			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("TextWebSocketHandler : 연결 끊김");
		//연결이 끊겼으니 해당 웹소켓 세션을 리스트에서 지운다.
		connectedUser.remove(session);
	}
	
}
