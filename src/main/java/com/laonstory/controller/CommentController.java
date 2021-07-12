package com.laonstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laonstory.service.CommentService;
import com.laonstory.vo.CommentVO;
import com.laonstory.vo.UserVO;

@Controller
public class CommentController {

	@Autowired
	private CommentService service;
	
	//°Ô½Ã±Û ´ñ±Û ¸®½ºÆ®
	@GetMapping("/commentlist")
    //@ResponseBody
    public List<CommentVO> CommentServiceList(int bnum, Model model) {
		return service.getListComment(bnum);
    }
    
	//´ñ±Û ÀÛ¼º
    @RequestMapping("/commentinsert")
    //@ResponseBody
    public String CommentServiceInsert(int bnum, String content, HttpServletRequest request) {
        UserVO user = new UserVO();
        CommentVO comment = new CommentVO();
        comment.setBnum(bnum);
        comment.setContent(content);
        HttpSession session = request.getSession();
		String writer = (String)session.getAttribute(user.getMemNickname());
		System.out.println("´ñ±Û ÀÛ¼ºÀÚ" + writer);
        comment.setNickname(writer);
        System.out.println(comment);
        return service.insertComment(comment);
    }
    
    //³»°¡ ´Ü ´ñ±Û ¸®½ºÆ®
    @GetMapping("/usercommentlist")
    public String CommentUserList(CommentVO vo, Model model) {
    	List<CommentVO> cList = service.getListUserComment(vo);
    	for (CommentVO comment : cList) {
    		System.out.println("´ñ±Û¸ñ·Ï" + comment);
    	}
    	model.addAttribute("usercomment", cList);
    	return "userComment";
    }
    
    //´ñ±Û ¼öÁ¤
    @RequestMapping("/commentupdate")  
    //@ResponseBody
    public String CommentServiceUpdateProc(int cnum, String content) {
        CommentVO comment = new CommentVO();
        comment.setCnum(cnum);
        comment.setContent(content);
        return service.updateComment(comment);
    }
    
    //´ñ±Û »èÁ¦
    @RequestMapping("/commentdelete")  
    //@ResponseBody
    public int CommentServiceDelete(int cnum) {
        return service.deleteComment(cnum);
    }
}
