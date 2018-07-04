package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Member;
import service.MemberServiceImp;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberServiceImp service;
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("loginForm");
		return "loginForm";
	}
	@RequestMapping("/login")
	public String login(Model model, @RequestParam String id, @RequestParam String password, HttpSession session) {
		System.out.println("login");
		if(service.selectOne(id) != null) {
			if(service.selectOne(id).getPassword().equals(password)) {
				session.setAttribute("userid", id);
				return "main";
			}
		}
		return "loginForm";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("logout");
		session.invalidate();
		return "loginForm";
	}
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("joinForm");
		return "joinForm";
	}
	@RequestMapping("/join")
	public String join(@RequestParam Map<String, Object> param) {
		System.out.println("join");
		Member m = new Member();
		System.out.println("아이디 : "+param.get("id").toString());
		System.out.println("비번 : "+param.get("password").toString());
		System.out.println("이름 : "+param.get("name").toString());
		System.out.println("메일 : "+param.get("email").toString());
		
		m.setId(param.get("id").toString());
		m.setPassword(param.get("password").toString());
		m.setName(param.get("name").toString());
		m.setEmail(param.get("email").toString());
		int result = service.memberJoin(m);
		if(result>0) {
			//여기에 게시글 등록 메서드를?
			System.out.println("등록");
			service.join(m);
			return "loginForm";
		} else {
			return "joinForm";
		}
	}
	@RequestMapping("/main")
	public String main() {
		System.out.println("main");
		return "main";
	}
	@RequestMapping("/updateForm")
	public String updateForm() {
		System.out.println("updateForm");
		return "updateForm";
	}
	@RequestMapping("/update")
	public String update(Model model, @RequestParam Map<String, Object> param, HttpSession session) {
		System.out.println("update");
		Member m = new Member();
		m.setId(session.getAttribute("userid").toString());
		m.setPassword(param.get("password").toString());
		m.setName(param.get("name").toString());
		m.setEmail(param.get("email").toString());
		service.memberUpdate(m);
		return "main";
	}
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		System.out.println("memberList");
		model.addAttribute("memberList", service.selectAll());
		return "memberList";
	}
}
