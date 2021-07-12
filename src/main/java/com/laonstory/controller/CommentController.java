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
	
	//��� ����Ʈ
	@GetMapping("/commentlist")
    //@ResponseBody
    public List<CommentVO> CommentServiceList(int bnum, Model model) {
        return service.getListComment(bnum);
    }
    
	//��� �ۼ�
    @RequestMapping("/commentinsert")
    //@ResponseBody
    public String CommentServiceInsert(int bnum, String content, HttpServletRequest request) {
        UserVO user = new UserVO();
        CommentVO comment = new CommentVO();
        comment.setBnum(bnum);
        comment.setContent(content);
        //�α��� ����� �����߰ų� ���� ��� �ۼ��ڸ� �Է¹޴� ���� �ִٸ� �Է� �޾ƿ� ������ ����ϸ� �˴ϴ�. ���� ���� ���� �������� �ʾұ⶧���� �ӽ÷� "test"��� ���� �Է��س����ϴ�.
        HttpSession session = request.getSession();
		String writer = (String)session.getAttribute(user.getMemNickname());
		System.out.println("��� �ۼ���" + writer);
        comment.setNickname(writer);
        System.out.println(comment);
        return service.insertComment(comment);
    }
    
    //��� ����
    @RequestMapping("/commentupdate")  
    //@ResponseBody
    public String CommentServiceUpdateProc(int cnum, String content) {
        CommentVO comment = new CommentVO();
        comment.setCnum(cnum);
        comment.setContent(content);
        return service.updateComment(comment);
    }
    
    //��� ����
    @RequestMapping("/commentdelete/{cnum}")  
    //@ResponseBody
    public int CommentServiceDelete(int cnum) {
        return service.deleteComment(cnum);
    }
}
