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
	
	//��� ����Ʈ
	@RequestMapping("/commentlist")
    @ResponseBody
    public List<CommentVO> CommentServiceList(Model model) {
        return service.getListComment();
    }
    
	//��� �ۼ�
    @RequestMapping("/commentinsert")
    @ResponseBody
    public String CommentServiceInsert(@RequestBody int boardid, @RequestBody String content, @RequestBody String writer) {
        
        CommentVO comment = new CommentVO();
        comment.setBoardid(boardid);
        comment.setContent(content);
        //�α��� ����� �����߰ų� ���� ��� �ۼ��ڸ� �Է¹޴� ���� �ִٸ� �Է� �޾ƿ� ������ ����ϸ� �˴ϴ�. ���� ���� ���� �������� �ʾұ⶧���� �ӽ÷� "test"��� ���� �Է��س����ϴ�.
        comment.setWriter(writer);
        return service.insertComment(comment);
    }
    
    //��� ����
    @RequestMapping("/commentupdate")  
    @ResponseBody
    public String CommentServiceUpdateProc(@RequestBody int commentid, @RequestBody String content) {
        CommentVO comment = new CommentVO();
        comment.setCommentid(commentid);
        comment.setContent(content);
        return service.updateComment(comment);
    }
    
    //��� ����
    @RequestMapping("/commentdelete/{commentid}")  
    @ResponseBody
    public int CommentServiceDelete(@PathVariable int commentid) {
        return service.deleteComment(commentid);
    }
}
