package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping(value="test", method=RequestMethod.GET)
	public String testGET(String a) {
		System.out.println(a);
		String test = "{\"result\" : \"soon\"}";
		return test;
	}
	@RequestMapping(value="test", method=RequestMethod.POST)
	public String testPost(String b) {
		System.out.println(b);
		String test = "{\"result\" : \"soon\"}";
		return test;
	}
}
