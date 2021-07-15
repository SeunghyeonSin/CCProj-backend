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
	
	//�Խñ� ���� �� ����
	@PostMapping("/insertLiketo")
	public void InserLiketo(LiketoVO vo) {
		service.insertLiketo(vo);
		System.out.println("����" + vo);
	}
	
	//���ƿ� ��ư ������ �˻�
	@PostMapping("/seletLiketo")
	public LiketoVO SelectLiketo(LiketoVO vo) {
		LiketoVO liketovo = service.selectLiketo(vo);
		boolean check = liketovo.isLike_check();
		if (check == false) {
			System.out.println("���ƿ� �ȴ���");
			return liketovo;
		}
		else {
			System.out.println("���ƿ� ����");
			return liketovo;
		}
	}
	
	//���ƿ� ���
	@PostMapping("/updateLiketo")
	public void UpdateLiketo(LiketoVO vo) {
		LiketoVO liketovo = service.selectLiketo(vo);
		boolean check = liketovo.isLike_check();
		if (check == false) {
			System.out.println("���ƿ� �ȴ���");
			BoardVO boardvo = bservice.selectBoard(liketovo.getBoardid());
			boardvo.setCnt(boardvo.getCnt() + 1);
			bservice.cntBoard(boardvo);
			service.updateLiketoagree(liketovo);
			System.out.println("���ƿ����" + liketovo);
			System.out.println("���� ��" + boardvo.getCnt());
		}
		else {
			System.out.println("���ƿ� ����");
			BoardVO boardvo = bservice.selectBoard(liketovo.getBoardid());
			boardvo.setCnt(boardvo.getCnt() - 1);
			bservice.cntBoard(boardvo);
			service.updateLiketocancel(liketovo);
			System.out.println("���ƿ����" + liketovo);
			System.out.println("���� ��" + boardvo.getCnt());
		}
	}
}
