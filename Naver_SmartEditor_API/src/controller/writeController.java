package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.NaverService;

@Controller
@RequestMapping("/write")
public class writeController {
	
	@Autowired
	NaverService service;
	
	@RequestMapping(value="")
	public String load() {
		System.out.println("이건 기본이지");
		return "write";
	}
	
	@RequestMapping("/write")
	public void write(String ir1) {
		System.out.println("여기는 들어오니????");
		System.out.println(ir1);
		service.add(ir1);
	}
}
