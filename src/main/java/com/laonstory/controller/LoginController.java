package com.laonstory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laonstory.service.UserService;
import com.laonstory.vo.UserVO;


@Controller
public class LoginController {

	@Autowired
	private UserService service;

	@GetMapping("/login")
	public String loginView(UserVO vo) {
		System.out.println("로그인 페이지");
		return "login";
	}
	//@ResponseBody
	@PostMapping("/login")
	public String login(UserVO vo, HttpServletRequest request) {
		System.out.println("로그인 시도");
		UserVO user = service.loginCheck(vo);
		String ca = "CAST";
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("nickname", user.getMemNickname());
			String id = user.getMemRole();
			System.out.println(id);
			if (id.equals(ca)) {
				System.out.println("유저리스트");
				return "redirect:/userlist";
			}
			return "redirect:/boardlist";
		} else{
			System.out.println("login error");
			return "login";
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
