package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Member;
import service.MemberService;

@Service
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@ResponseBody
	@RequestMapping("/memberList")
	public List<Member> memberList(){
		return service.getAllMembers();
	}
}







