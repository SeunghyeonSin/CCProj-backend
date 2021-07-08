package com.laonstory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laonstory.service.CommentService;
import com.laonstory.vo.CommentVO;

@Controller
public class CommentController {

	@Autowired
	private CommentService service;
	
	//댓글 리스트
	@RequestMapping("/commentlist")
    @ResponseBody
    public List<CommentVO> CommentServiceList(Model model) {
        return service.getListComment();
    }
    
	//댓글 작성
    @RequestMapping("/commentinsert")
    @ResponseBody
    public String CommentServiceInsert(@RequestBody int boardid, @RequestBody String content, @RequestBody String writer) {
        
        CommentVO comment = new CommentVO();
        comment.setBoardid(boardid);
        comment.setContent(content);
        //로그인 기능을 구현했거나 따로 댓글 작성자를 입력받는 폼이 있다면 입력 받아온 값으로 사용하면 됩니다. 저는 따로 폼을 구현하지 않았기때문에 임시로 "test"라는 값을 입력해놨습니다.
        comment.setWriter(writer);
        return service.insertComment(comment);
    }
    
    //댓글 수정
    @RequestMapping("/commentupdate")  
    @ResponseBody
    public String CommentServiceUpdateProc(@RequestBody int commentid, @RequestBody String content) {
        CommentVO comment = new CommentVO();
        comment.setCommentid(commentid);
        comment.setContent(content);
        return service.updateComment(comment);
    }
    
    //댓글 삭제
    @RequestMapping("/commentdelete/{commentid}")  
    @ResponseBody
    public int CommentServiceDelete(@PathVariable int commentid) {
        return service.deleteComment(commentid);
    }
}
