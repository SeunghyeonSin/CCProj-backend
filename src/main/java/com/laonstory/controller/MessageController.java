package com.laonstory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.laonstory.service.MessageService;
import com.laonstory.vo.MessageVO;
import com.laonstory.vo.SearchVO;

@Controller
public class MessageController {

	@Autowired
	private MessageService service;
	
	//쪽지 읽음
	@GetMapping("/messageread")
	public String readMessage(MessageVO vo, Model model) {
		System.out.println("쪽지 읽는 페이지");
		MessageVO messagevo = service.getMessage(vo);
		model.addAttribute("read", messagevo);
		return "readMessage";
	}
	
	//받은 쪽지 리스트
	@GetMapping("/messagelist")
	public String listMessage(MessageVO vo, Model model) {
		List<MessageVO> mList = service.getListMessage(vo);
		System.out.println(vo);
		for (MessageVO messagevo : mList) {
			System.out.println("쪽지 리스트 " + messagevo);
		}
		model.addAttribute("messagelist", mList);
		return "messageList";
	}
	
	//쪽지 검색
	//@ResponseBody
	@PostMapping("/messagelist")
	public String messagelistSearch(SearchVO searchvo, Model model) {
		System.out.println("쪽지 검색");
		List<MessageVO> mList = service.getListSearch(searchvo);
		for (MessageVO messagevo : mList) {
			System.out.println("list" + messagevo);
		}
		model.addAttribute("messagelist", mList);
		return "messageList";
	}
	
	//쪽지 작성
	@GetMapping("/messagesend")
	public String insertMessage() {
		System.out.println("쪽지 보내는 페이지");
		return "sendMessage";
	}
	@PostMapping("/messagesend")
	public String addMessage(MessageVO vo) {
		System.out.println("쪽지보냄 " + vo);
		service.insertMessage(vo);
		return "redirect://messagelist?receinick=${nickname}";
	}
	
	//받은 쪽지 삭제
	@GetMapping("/messagedelete")
	public String deleteMessage(int messagenum) {
		System.out.println("쪽지 삭제" + messagenum);
		service.deleteMessage(messagenum);
		return "redirect://messagelist?receinick=${nickname}";
	}
}
