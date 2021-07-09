package com.laonstory.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.laonstory.service.BoardService;
import com.laonstory.vo.BoardVO;
import com.laonstory.vo.FileVO;
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
	public String boardDetail(int bnum, BoardVO vo, Model model) {
		System.out.println("사용자 정보 수정 페이지");
		BoardVO board = service.getBoard(vo);
		FileVO filevo = service.fileDetail(bnum);
		System.out.println("게시글 " + vo);
		System.out.println("파일" + filevo);
		model.addAttribute("board", board);
		model.addAttribute("files", filevo);
		return "detailBoard";
	}
	
	//게시글 검색
	//@ResponseBody
	@PostMapping("/boardlist")
	public String boardlistSearch(SearchVO searchvo, Model model) {
		System.out.println("게시글 검색");
		List<BoardVO> bList = service.getListSearch(searchvo);
		for (BoardVO boardVO : bList) {
			System.out.println("list" + boardVO);
		}
		model.addAttribute("boardlist", bList);
		return "boardList";
	}
	
	//게시글 등록
	@GetMapping("/boardinsert")
	public String insertView() {
		System.out.println("게시글등록 페이지");
		return "insertBoard";
	}
	//파일 업로드 및 게시글 등록
	@PostMapping("/boardinsert")
	public String insertBoard(BoardVO vo, @RequestPart MultipartFile files) throws Exception {
		System.out.println("게시글등록" + vo);
		FileVO file = new FileVO();
		if(files.isEmpty()) {
			service.insertBoard(vo);
		} else {
			String FileName = files.getOriginalFilename();
			String FileNameExtension = FilenameUtils.getExtension(FileName).toLowerCase();
			File destinationFile;
			String destinationFileName;
			String fileUrl = "C:\\Users\\tlstm\\Documents\\workspace-spring-tool-suite-4-4.11.0.RELEASE\\CCProj\\src\\main\\webapp\\WEB-INF\\uploadFiles\\";
			do { 
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + FileNameExtension; 
				destinationFile = new File(fileUrl + destinationFileName); 
			} while (destinationFile.exists()); 
			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);
			service.insertBoard(vo);
			file.setBnum(vo.getBnum());
			file.setFileName(destinationFileName);
			file.setFileOriName(FileName);
			file.setFileUrl(fileUrl);
			service.fileInsert(file);
		}
		return "redirect:/boardlist";
	}
	
	//업로드 한 파일 다운로드
	@GetMapping("/fileDown/{bnum}")
    private void fileDown(@PathVariable int bnum, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        
        request.setCharacterEncoding("UTF-8");
        FileVO fileVO = service.fileDetail(bnum);
        System.out.println(fileVO);
        
        //파일 업로드된 경로 
        try{
            String fileUrl = fileVO.getFileUrl();
            String savePath = fileUrl;
            String fileName = fileVO.getFileName();
            
            //실제 내보낼 파일명 
            String oriFileName = fileVO.getFileOriName();
            InputStream in = null;
            OutputStream os = null;
            File file = null;
            boolean skip = false;
            String client = "";
            
            //파일을 읽어 스트림에 담기  
            try{
                file = new File(savePath, fileName);
                in = new FileInputStream(file);
            } catch (FileNotFoundException fe) {
                skip = true;
            }
            
            client = request.getHeader("User-Agent");
            
            //파일 다운로드 헤더 지정 
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Description", "JSP Generated Data");
            
            if (!skip) {
                // IE
                if (client.indexOf("MSIE") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                    // IE 11 이상.
                } else if (client.indexOf("Trident") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                } else {
                    // 한글 파일명 처리
                    response.setHeader("Content-Disposition",
                            "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                    response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
                }
                response.setHeader("Content-Length", "" + file.length());
                os = response.getOutputStream();
                byte b[] = new byte[(int) file.length()];
                int leng = 0;
                while ((leng = in.read(b)) > 0) {
                    os.write(b, 0, leng);
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
            }
            in.close();
            os.close();
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        
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
	//@ResponseBody
	@PostMapping("/boardupdate")
	public String updateBoard(BoardVO up) {
		System.out.println("게시글 수정" + up);
		service.updateBoard(up);
		return "redirect:/boardlist";
	}
	
	//게시글 삭제
	//@ResponseBody
	@GetMapping("/boarddelete")
	public String deleteBoard(int bnum) {
		System.out.println("게시글 삭제" + bnum);
		service.deleteBoard(bnum);
		return "redirect:/boardlist";
	}
}
