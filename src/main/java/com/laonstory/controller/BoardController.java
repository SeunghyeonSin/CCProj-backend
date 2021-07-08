package com.laonstory.controller;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.laonstory.service.BoardService;
import com.laonstory.vo.BoardVO;
import com.laonstory.vo.SearchVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	//게시글 리스트 출력
	@GetMapping("/boardlist")
	public String boardlistView(BoardVO vo, Model model) {
		List<BoardVO> bList = service.getListBoard();
		for (BoardVO boardVO : bList) {
			System.out.println("게시글 리스트 " + boardVO);
		}
		model.addAttribute("boardlist", bList);
		return "boardList";
	}
	
	//게시글 상세 화면
	@GetMapping("/boarddetail")
	public String boardDetail(BoardVO vo, Model model) {
		System.out.println("사용자 정보 수정 페이지");
		BoardVO board = service.getBoard(vo);
		System.out.println("게시글 " + vo);
		model.addAttribute("board", board);
		return "detailBoard";
	}
	
	//게시글 검색
	@ResponseBody
	@PostMapping("/boardlist")
	public Model boardlistSearch(@RequestBody SearchVO searchvo, @RequestBody Model model) {
		System.out.println("게시글 검색");
		List<BoardVO> bList = service.getListSearch(searchvo);
		for (BoardVO boardVO : bList) {
			System.out.println("list" + boardVO);
		}
		model.addAttribute("boardlist", bList);
		return model;
	}
	
	//게시글 등록
	@GetMapping("/boardinsert")
	public String insertView() {
		System.out.println("게시글등록 페이지");
		return "insertBoard";
	}

	@PostMapping("/boardinsert")
	public String insertBoard(BoardVO vo, @RequestPart MultipartFile files) {
		System.out.println("게시글등록" + vo);
		
		String sourceFileName = files.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "C:\\Users\\tlstm\\Documents\\workspace-spring-tool-suite-4-4.11.0.RELEASE\\CCProj\\src\\main\\webapp\\WEB-INF\\uploadFiles";
		do { 
            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension; 
            destinationFile = new File(fileUrl + destinationFileName); 
        } while (destinationFile.exists()); 
        destinationFile.getParentFile().mkdirs(); 
        files.transferTo(destinationFile);
        service.insertBoard(vo);
		return "redirect:/boardlist";
	}
	
	//게시글 수정	
	@GetMapping("/boardupdate")
	public String updateView(BoardVO vo, Model model) {
		System.out.println("게시글수정 페이지");
		BoardVO board = service.getBoard(vo);
		System.out.println("게시글" + board);
		model.addAttribute("board", board);
		return "updateBoard";
	}
	@ResponseBody
	@PostMapping("/boardupdate")
	public String updateBoard(@RequestBody BoardVO up) {
		System.out.println("게시글 수정" + up);
		service.updateBoard(up);
		return "redirect:/boardlist";
	}
	
	//게시글 삭제
	@ResponseBody
	@GetMapping("/boarddelete")
	public String deleteBoard(@RequestBody int bnum) {
		System.out.println("게시글 삭제" + bnum);
		service.deleteBoard(bnum);
		return "redirect:/boardlist";
	}
}
