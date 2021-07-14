package com.laonstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.laonstory.service.CommentService;
import com.laonstory.vo.CommentVO;
import com.laonstory.vo.UserVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CommentController {

	@Autowired
	private CommentService service;
	
	//°Ô½Ã±Û ´ñ±Û ¸®½ºÆ®
	@PostMapping("/commentList")
    @ResponseBody
    public List<CommentVO> CommentServiceList(@RequestBody int boardid, @RequestBody Model model) {
		System.out.println(boardid);
    	List<CommentVO> commentList = service.getListComment(boardid);
    	System.out.println(commentList);
        return commentList;
    }
    
	//´ñ±Û ÀÛ¼º
    @PostMapping("/insertComment")
    public void CommentServiceInsert(@RequestBody CommentVO vo) {
        System.out.println(vo);
        if (vo.getAnonymous() != 1) {
        	vo.setAnonymous(0);
        }
        service.insertComment(vo);
    }
    
    //³»°¡ ´Ü ´ñ±Û ¸®½ºÆ®
    @GetMapping("/usercommentlist")
    public String CommentUserList(@RequestBody CommentVO vo, @RequestBody Model model) {
    	List<CommentVO> cList = service.getListUserComment(vo);
    	for (CommentVO comment : cList) {
    		System.out.println("´ñ±Û¸ñ·Ï" + comment);
    	}
    	model.addAttribute("usercomment", cList);
    	return "userComment";
    }
    
    //´ñ±Û ¼öÁ¤
    @RequestMapping("/updateComment")  
    //@ResponseBody
    public String CommentServiceUpdateProc(@RequestBody int commentid, @RequestBody String content) {
        CommentVO comment = new CommentVO();
        comment.setCommentid(commentid);
        comment.setContent(content);
        return service.updateComment(comment);
    }
    
    //´ñ±Û »èÁ¦
    @PostMapping("/deleteComment")
    public int CommentServiceDelete(@RequestBody int commentid) {
        return service.deleteComment(commentid);
    }
}
