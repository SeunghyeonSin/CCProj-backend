package com.laonstory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.laonstory.service.UserService;
import com.laonstory.vo.UserVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

	@Autowired
	private UserService service;

	/*
	@GetMapping("/login")
	public String loginView(UserVO vo) {
		System.out.println("로그인 페이지");
		return "login";
	}*/
	
	@ResponseBody
	@PostMapping("/login")
	public UserVO login(@RequestBody UserVO vo, HttpServletRequest request) {
		System.out.println("로그인 시도");
		UserVO user = service.loginCheck(vo);
		String ca = "admin01";
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("nickname", user.getMemNickname());
			session.setAttribute("id", user.getMemId());
			String id = user.getMemId();
			System.out.println(id);
			if (id.equals(ca)) {
				System.out.println("유저리스트");
				return null;
			}
			return user;
		} else{
			System.out.println("login error");
			return null;
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout");
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
