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
	
	//�Խñ� ����Ʈ ���
	@GetMapping("/boardlist")
	public String boardlistView(BoardVO vo, Model model) {
		List<BoardVO> bList = service.getListBoard();
		for (BoardVO boardVO : bList) {
			System.out.println("�Խñ� ����Ʈ " + boardVO);
		}
		model.addAttribute("boardlist", bList);
		return "boardList";
	}
	
	//�Խñ� �� ȭ��
	@GetMapping("/boarddetail")
	public String boardDetail(BoardVO vo, Model model) {
		System.out.println("����� ���� ���� ������");
		BoardVO board = service.getBoard(vo);
		System.out.println("�Խñ� " + vo);
		model.addAttribute("board", board);
		return "detailBoard";
	}
	
	//�Խñ� �˻�
	@ResponseBody
	@PostMapping("/boardlist")
	public Model boardlistSearch(@RequestBody SearchVO searchvo, @RequestBody Model model) {
		System.out.println("�Խñ� �˻�");
		List<BoardVO> bList = service.getListSearch(searchvo);
		for (BoardVO boardVO : bList) {
			System.out.println("list" + boardVO);
		}
		model.addAttribute("boardlist", bList);
		return model;
	}
	
	//�Խñ� ���
	@GetMapping("/boardinsert")
	public String insertView() {
		System.out.println("�Խñ۵�� ������");
		return "insertBoard";
	}

	@PostMapping("/boardinsert")
	public String insertBoard(BoardVO vo, @RequestPart MultipartFile files) {
		System.out.println("�Խñ۵��" + vo);
		
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
	
	//�Խñ� ����	
	@GetMapping("/boardupdate")
	public String updateView(BoardVO vo, Model model) {
		System.out.println("�Խñۼ��� ������");
		BoardVO board = service.getBoard(vo);
		System.out.println("�Խñ�" + board);
		model.addAttribute("board", board);
		return "updateBoard";
	}
	@ResponseBody
	@PostMapping("/boardupdate")
	public String updateBoard(@RequestBody BoardVO up) {
		System.out.println("�Խñ� ����" + up);
		service.updateBoard(up);
		return "redirect:/boardlist";
	}
	
	//�Խñ� ����
	@ResponseBody
	@GetMapping("/boarddelete")
	public String deleteBoard(@RequestBody int bnum) {
		System.out.println("�Խñ� ����" + bnum);
		service.deleteBoard(bnum);
		return "redirect:/boardlist";
	}
}
