package com.laonstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laonstory.service.CommentService;
import com.laonstory.vo.CommentVO;
import com.laonstory.vo.UserVO;

@Controller
public class CommentController {

	@Autowired
	private CommentService service;
	
	//댓글 리스트
	@GetMapping("/commentlist")
    //@ResponseBody
    public List<CommentVO> CommentServiceList(int bnum, Model model) {
        return service.getListComment(bnum);
    }
    
	//댓글 작성
    @RequestMapping("/commentinsert")
    //@ResponseBody
    public String CommentServiceInsert(int bnum, String content, HttpServletRequest request) {
        UserVO user = new UserVO();
        CommentVO comment = new CommentVO();
        comment.setBnum(bnum);
        comment.setContent(content);
        //로그인 기능을 구현했거나 따로 댓글 작성자를 입력받는 폼이 있다면 입력 받아온 값으로 사용하면 됩니다. 저는 따로 폼을 구현하지 않았기때문에 임시로 "test"라는 값을 입력해놨습니다.
        HttpSession session = request.getSession();
		String writer = (String)session.getAttribute(user.getMemNickname());
		System.out.println("댓글 작성자" + writer);
        comment.setNickname(writer);
        System.out.println(comment);
        return service.insertComment(comment);
    }
    
    //댓글 수정
    @RequestMapping("/commentupdate")  
    //@ResponseBody
    public String CommentServiceUpdateProc(int cnum, String content) {
        CommentVO comment = new CommentVO();
        comment.setCnum(cnum);
        comment.setContent(content);
        return service.updateComment(comment);
    }
    
    //댓글 삭제
    @RequestMapping("/commentdelete/{cnum}")  
    //@ResponseBody
    public int CommentServiceDelete(int cnum) {
        return service.deleteComment(cnum);
    }
}
