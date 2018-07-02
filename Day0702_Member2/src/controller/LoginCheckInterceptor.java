package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter  {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("userid")!=null) {
			return true;
		} else {
			response.sendRedirect("loginForm");
			return false;
		}
	}
}
