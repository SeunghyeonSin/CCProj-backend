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
	
	//���� ����
	@GetMapping("/messageread")
	public String readMessage(MessageVO vo, Model model) {
		System.out.println("���� �д� ������");
		MessageVO messagevo = service.getMessage(vo);
		model.addAttribute("read", messagevo);
		return "readMessage";
	}
	
	//���� ���� ����Ʈ
	@GetMapping("/messagelist")
	public String listMessage(MessageVO vo, Model model) {
		List<MessageVO> mList = service.getListMessage(vo);
		System.out.println(vo);
		for (MessageVO messagevo : mList) {
			System.out.println("���� ����Ʈ " + messagevo);
		}
		model.addAttribute("messagelist", mList);
		return "messageList";
	}
	
	//���� �˻�
	//@ResponseBody
	@PostMapping("/messagelist")
	public String messagelistSearch(SearchVO searchvo, Model model) {
		System.out.println("���� �˻�");
		List<MessageVO> mList = service.getListSearch(searchvo);
		for (MessageVO messagevo : mList) {
			System.out.println("list" + messagevo);
		}
		model.addAttribute("messagelist", mList);
		return "messageList";
	}
	
	//���� �ۼ�
	@GetMapping("/messagesend")
	public String insertMessage() {
		System.out.println("���� ������ ������");
		return "sendMessage";
	}
	@PostMapping("/messagesend")
	public String addMessage(MessageVO vo) {
		System.out.println("�������� " + vo);
		service.insertMessage(vo);
		return "redirect://messagelist?receinick=${nickname}";
	}
	
	//���� ���� ����
	@GetMapping("/messagedelete")
	public String deleteMessage(int messagenum) {
		System.out.println("���� ����" + messagenum);
		service.deleteMessage(messagenum);
		return "redirect://messagelist?receinick=${nickname}";
	}
}
