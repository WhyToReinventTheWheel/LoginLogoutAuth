package com.mk.webApp.login;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLogoutController {

	@GetMapping("/login")
	public void login(HttpServletRequest request , HttpServletResponse response) {
		String userName  = request.getParameter("userName");
		System.out.println("UserName: "+userName);
		
	 	HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
			
		String loginTokenId = UUID.randomUUID().toString();
		Cookie cookie = new Cookie("LOGIN_ID",loginTokenId);
		response.addCookie(cookie);
	}
	
	@GetMapping("/test")
	public void login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName  = (String)session.getAttribute("userName");
		System.out.println("Test-UserName: "+userName);
	}
	
	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Logout");
		HttpSession session = request.getSession();
		session.invalidate();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("LOGIN_ID".equals(cookie.getName())) {
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
}
