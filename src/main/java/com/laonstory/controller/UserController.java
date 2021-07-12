package com.laonstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laonstory.service.UserService;
import com.laonstory.vo.SearchVO;
import com.laonstory.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	//메인 페이지
	@ResponseBody
	@GetMapping("/")
	public String main() {
		return "Hello World";
	}
	
	//사용자 리스트 출력
	@GetMapping("/userlist")
	public String userlistView(UserVO vo, Model model) {
		List<UserVO> urList = service.selectUser();
		for (UserVO userVO : urList) {
			System.out.println("사용자 목록" + userVO);
		}
		model.addAttribute("userlist", urList);
		return "userList";
	}
	//사용자 리스트 검색
	//@ResponseBody
	@PostMapping("/userlist")
	public Model userlistSearch(SearchVO searchvo, Model model) {
		System.out.println("게시글 검색");
		List<UserVO> urList = service.getListSearch(searchvo);
		for (UserVO userVO : urList) {
			System.out.println("list" + userVO);
		}
		model.addAttribute("userlist", urList);
		return model;
	}
	
	//회원가입
	@GetMapping("/join")
	public String insertView() {
		System.out.println("사용자가입 페이지");
		return "join";
	}
	//@ResponseBody
	@PostMapping("/join")
	public String Join(UserVO vo) {
		System.out.println("사용자등록 " + vo);
		service.insertUser(vo);
		return null;
	}
	
	//아이디 중복 체크
	//@ResponseBody
	@PostMapping("/idCheck")
	public int idCheck(HttpServletRequest req) {
		System.out.println("아이디 중복 체크");
		String id = req.getParameter("id");
		System.out.println(id);
		UserVO idCheck =  service.idCheck(id);
		System.out.println(idCheck);
		int result = 0;
		if(idCheck != null) {
			result = 1;
		} 
		return result;
	}
	
	//닉네임 중복 체크
	//@ResponseBody
	@PostMapping("/nickCheck")
	public int nickCheck(HttpServletRequest req) {
		System.out.println("닉네임 중복 체크");
		String nickname = req.getParameter("nickname");
		UserVO nickCheck =  service.nickCheck(nickname);
		System.out.println(nickCheck);
		int result = 0;
		if(nickCheck != null) {
			result = 1;
		} 
		return result;
	}
	
	//마이페이지
	@GetMapping("/mypage")
	public String mylist() {
		System.out.println("마이 페이지 출력");
		return "myPage";
	}
	
	//사용자 정보 수정
	@GetMapping("/userupdate")
	public String updateView(UserVO vo, Model model) {
		System.out.println("사용자 정보 수정 페이지");
		UserVO user = service.getUser(vo);
		System.out.println("사용자 " + user);
		model.addAttribute("user", user);
		return "updateUser";
	}
	//@ResponseBody
	@PostMapping("/userupdate")
	public String updateUser(UserVO up) {
		System.out.println("사용자 정보 수정" + up);
		service.updateUser(up);
		return "redirect:/mypage";
	}
	
	//사용자 영구 삭제
	//@ResponseBody
	@GetMapping("/userdelete")
	public String deleteUser(UserVO vo) {
		System.out.println("사용자 삭제" + vo);
		service.deleteUser(vo);
		return "redirect:/";
	}
}
