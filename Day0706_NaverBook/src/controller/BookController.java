package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.NaverBookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	NaverBookService naverBookService;
	
	@RequestMapping("/bookSearch")		//리콰이어드 = 파라미터가 없어도 예외를 발생시키지 않겠다! 라는거.. 디폴트 밸류를 넣었다면 파라미터를 안넣어도 자동으로 들어가니까 상관없음 ㅋ
	public String bookSearch(@RequestParam(required=false, defaultValue="") String keyword, Model model) {
		System.out.println("검색 요청");
		//검색어를 이용해서 네이버에 요청하고 응답을 받는다.
		//응답받은 데이터를 모델로 만들어서 jsp로 전달!
		//위의 작업을 service에서 처리하면 된다.
		try {
			model.addAttribute("bookList", naverBookService.searchBooks(keyword));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "bookList";
	}
}
