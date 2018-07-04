package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
//	CharacterEncodingFilter
	
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		System.out.println("memberList 요청 받음");
		
		model.addAttribute("memberList", memberService.getAllMembers());
		return "memberList";
	}
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam Map<String, Object> params) {
	public String login(HttpSession session, Member member,RedirectAttributes ra) {
		//login.jsp에서 넘겨주는 form 요소를 받아서 
		//로그인 진행
		System.out.println("userid :" + member.getId());
		System.out.println("userpw :" + member.getPw());
		
//		System.out.println("map userid :" + params.get("id"));
//		System.out.println("map userpw :" + params.get("pw"));
		
		boolean result 
		= memberService.login(member.getId(), member.getPw());
		
		if(result) {
			//세션에 아이디를 담고 메인으로 이동
			session.setAttribute("userid", member.getId());
			return "redirect:main";
		}else {
			//로그인 실패니까.. 로그인 페이지로 이동
			//로그인 페이지 이동할 때...실패 메시지를 전달하고 싶음,
			//redirect는 요청이 새로 만들어 지기 때문에...model에 담아도 데이터 전달 불가
			
			//redirect할 때(새로운 요청을 만들어 낼 때) 메시지를 전달하려고 한다.
			//RedirectAttribute 를 이용
			
//			model.addAttribute("msg", "로그인 실패");  이렇게 못씀
			ra.addFlashAttribute("msg","로그인 실패");
			return "redirect:login";
		}
	}
	
	@RequestMapping(value = "/join" ,method = RequestMethod.GET)
	public String joinForm() {
		return "join";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(HttpSession session,Model model) {
		String id = (String)session.getAttribute("userid");
		model.addAttribute("member", memberService.getMemberById(id));
		
		return "memberUpdate";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST )
	public String join(HttpServletRequest request,Member member) {
		//회원가입 진행하기...
//		System.out.println("id : " + request.getParameter("id"));
//		System.out.println("pw : " + request.getParameter("pw"));
//		System.out.println("name : " + request.getParameter("name"));
//		System.out.println("email : " + request.getParameter("email"));
		
		if(memberService.join(member)) {
			//회원가입 성공
			return "redirect:login";
		}else {
			//실패하면 성공할 때 까지...join으로 
			return "redirect:join";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userid");
		return "redirect:login";
	}
	
	@RequestMapping("/update")
	public String update() {
		return null;
	}
	
	
	
	
	
	
	
	
	
}
