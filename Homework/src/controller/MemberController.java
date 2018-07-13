package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memService;
	
	//메인 화면 요청
	@RequestMapping("/main")
	public String mainForm(HttpSession session, Model model) {
			model.addAttribute("memberList", memService.getAllMems());
			return "/main";
	}
	//로그인 화면 요청
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		System.out.println("로그인 폼 요청");
		return "/loginForm";
	}
	//로그인 요청
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session, @RequestParam Map<String, Object> member) {
		String userid = (String) member.get("userid");
		String userpw = (String) member.get("password");
		
		if(memService.getMem(userid)!=null) {
			if(userpw.equals(memService.getMem(userid).get("PASSWORD"))) {
				//로그인 성공
				System.out.println(userid+" 로그인 성공");
				session.setAttribute("userid", userid);
				return "redirect:main";
			}
		}
		return "redirect:login";
	}
	//로그아웃 요청
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println(session.getAttribute("userid") + " 로그아웃");
		session.removeAttribute("userid");
		return "redirect:login";
	}
}

