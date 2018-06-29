package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/test.do")
	public String test(Model model) {
		System.out.println("test.do 요청입니다.");
		// return "test"; //viewResolver를 설정해주지 않으면 해당 파일 경로를 다 작성해줘야함.
		model.addAttribute("msg", "msg마시쪙!!");
		return "test";
	}
	
	//whatTime.do 요청받아서
	//화면에 현재 시간 출력하기
	@RequestMapping("/whatTime.do")
	public String time(Model model) {
		System.out.println("whatTime.do 요청입니다.");
		model.addAttribute("time", new Date());
		return "time";
	}
}
