package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Member member,RedirectAttributes ra) {
		//login.jsp에서 넘겨주는 form 요소를 받아서 
		//로그인 진행
		System.out.println("userid :" + member.getId());
		System.out.println("userpw :" + member.getPassword());
		boolean result 
		= memberService.login(member.getId(), member.getPassword());
		
		if(result) {
			//세션에 아이디를 담고 메인으로 이동
			session.setAttribute("userid", member.getId());
			return "redirect:/board/boardList";
		}else {
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
		model.addAttribute("member", memberService.selectOne(id));
		
		return "memberUpdate";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userid");
		return "redirect:login";
	}
	
}
