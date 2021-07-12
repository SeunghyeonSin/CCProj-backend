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
	
	//���� ������
	@ResponseBody
	@GetMapping("/")
	public String main() {
		return "Hello World";
	}
	
	//����� ����Ʈ ���
	@GetMapping("/userlist")
	public String userlistView(UserVO vo, Model model) {
		List<UserVO> urList = service.selectUser();
		for (UserVO userVO : urList) {
			System.out.println("����� ���" + userVO);
		}
		model.addAttribute("userlist", urList);
		return "userList";
	}
	//����� ����Ʈ �˻�
	//@ResponseBody
	@PostMapping("/userlist")
	public Model userlistSearch(SearchVO searchvo, Model model) {
		System.out.println("�Խñ� �˻�");
		List<UserVO> urList = service.getListSearch(searchvo);
		for (UserVO userVO : urList) {
			System.out.println("list" + userVO);
		}
		model.addAttribute("userlist", urList);
		return model;
	}
	
	//ȸ������
	@GetMapping("/join")
	public String insertView() {
		System.out.println("����ڰ��� ������");
		return "join";
	}
	//@ResponseBody
	@PostMapping("/join")
	public String Join(UserVO vo) {
		System.out.println("����ڵ�� " + vo);
		service.insertUser(vo);
		return null;
	}
	
	//���̵� �ߺ� üũ
	//@ResponseBody
	@PostMapping("/idCheck")
	public int idCheck(HttpServletRequest req) {
		System.out.println("���̵� �ߺ� üũ");
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
	
	//�г��� �ߺ� üũ
	//@ResponseBody
	@PostMapping("/nickCheck")
	public int nickCheck(HttpServletRequest req) {
		System.out.println("�г��� �ߺ� üũ");
		String nickname = req.getParameter("nickname");
		UserVO nickCheck =  service.nickCheck(nickname);
		System.out.println(nickCheck);
		int result = 0;
		if(nickCheck != null) {
			result = 1;
		} 
		return result;
	}
	
	//����������
	@GetMapping("/mypage")
	public String mylist() {
		System.out.println("���� ������ ���");
		return "myPage";
	}
	
	//����� ���� ����
	@GetMapping("/userupdate")
	public String updateView(UserVO vo, Model model) {
		System.out.println("����� ���� ���� ������");
		UserVO user = service.getUser(vo);
		System.out.println("����� " + user);
		model.addAttribute("user", user);
		return "updateUser";
	}
	//@ResponseBody
	@PostMapping("/userupdate")
	public String updateUser(UserVO up) {
		System.out.println("����� ���� ����" + up);
		service.updateUser(up);
		return "redirect:/mypage";
	}
	
	//����� ���� ����
	//@ResponseBody
	@GetMapping("/userdelete")
	public String deleteUser(UserVO vo) {
		System.out.println("����� ����" + vo);
		service.deleteUser(vo);
		return "redirect:/";
	}
}
