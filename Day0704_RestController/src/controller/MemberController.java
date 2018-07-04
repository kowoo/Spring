package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;

	@ResponseBody
	@RequestMapping("/list")
	public List<Map<String, Object>> member() {
		System.out.println("sample/member 요청");
		return service.selectAll();
	}	
}
