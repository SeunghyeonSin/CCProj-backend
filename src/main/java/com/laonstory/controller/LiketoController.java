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
	
	//게시글 누를 때 생성
	@PostMapping("/insertLiketo")
	public void InserLiketo(LiketoVO vo) {
		service.insertLiketo(vo);
		System.out.println("생성" + vo);
	}
	
	//좋아요 버튼 누른지 검사
	@PostMapping("/seletLiketo")
	public LiketoVO SelectLiketo(LiketoVO vo) {
		LiketoVO liketovo = service.selectLiketo(vo);
		boolean check = liketovo.isLike_check();
		if (check == false) {
			System.out.println("좋아요 안누름");
			return liketovo;
		}
		else {
			System.out.println("좋아요 누름");
			return liketovo;
		}
	}
	
	//좋아요 기능
	@PostMapping("/updateLiketo")
	public void UpdateLiketo(LiketoVO vo) {
		LiketoVO liketovo = service.selectLiketo(vo);
		boolean check = liketovo.isLike_check();
		if (check == false) {
			System.out.println("좋아요 안누름");
			BoardVO boardvo = bservice.selectBoard(liketovo.getBoardid());
			boardvo.setCnt(boardvo.getCnt() + 1);
			bservice.cntBoard(boardvo);
			service.updateLiketoagree(liketovo);
			System.out.println("좋아요취소" + liketovo);
			System.out.println("공감 수" + boardvo.getCnt());
		}
		else {
			System.out.println("좋아요 누름");
			BoardVO boardvo = bservice.selectBoard(liketovo.getBoardid());
			boardvo.setCnt(boardvo.getCnt() - 1);
			bservice.cntBoard(boardvo);
			service.updateLiketocancel(liketovo);
			System.out.println("좋아요취소" + liketovo);
			System.out.println("공감 수" + boardvo.getCnt());
		}
	}
}
