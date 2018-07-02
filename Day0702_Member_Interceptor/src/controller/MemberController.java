package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Member;
import service.MemberServiceImp;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberServiceImp service;
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		List<Member> list =  service.memberList();
		model.addAttribute("memberList", list);
		return "memberList";
	}
}
