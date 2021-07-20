package com.laonstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laonstory.service.BoardService;
import com.laonstory.service.LiketoService;
import com.laonstory.vo.BoardVO;
import com.laonstory.vo.LiketoVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LiketoController {

	@Autowired
	private LiketoService service;
	@Autowired
	private BoardService bservice;
	
	//���ƿ� ���
	@PostMapping("/insertLiketo")
	public void InserLiketo(LiketoVO vo) {
		service.insertLiketo(vo);
		int boardid = vo.getBoardid();
		System.out.println("����" + vo);
	}
	
	//���ƿ� ��ư ������ �˻�
	@PostMapping("/seletLiketo")
	public LiketoVO SelectLiketo(LiketoVO vo) {
		LiketoVO liketovo = service.selectLiketo(vo);
		System.out.println(vo);
		return liketovo;
	}
	
	//���ƿ� ��� ���
	public void DeleteLiketo(LiketoVO vo) {
		service.deleteLiketo(vo);
		System.out.println("����" + vo);
	}
}
