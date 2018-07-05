package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value="")
	public String getFirstPage() {
		System.out.println("페이지 요청");
		return "memberList";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public boolean addMember(Member member) {
		
		System.out.println(member.getName()+"님을 등록합니다.");
		boolean result = service.addMember(member);
		if(result) {
			return true;
		} else {
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Member> getMemberList() {
		System.out.println("리스트 요청");
		
		return service.getMemberList();
	}
}
