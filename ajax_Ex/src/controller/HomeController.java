package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Emp;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping(value="/rest", method = RequestMethod.GET)
	public Emp getHandler() {
		Emp e = new Emp();
		e.setEmpno(1111);
		e.setEname("OracleJavaCommunity");                  
		return e;
	}

	@RequestMapping(value="/rest", method = RequestMethod.POST)
	@ResponseBody
	public String postHandler(String e) {
		String result = "{\"da\" : \"asd\"}";
		return result;
	}         
}
