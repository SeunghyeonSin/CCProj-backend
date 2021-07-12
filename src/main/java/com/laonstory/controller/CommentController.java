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
	
	//�Խñ� ��� ����Ʈ
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
        HttpSession session = request.getSession();
		String writer = (String)session.getAttribute(user.getMemNickname());
		System.out.println("��� �ۼ���" + writer);
        comment.setNickname(writer);
        System.out.println(comment);
        return service.insertComment(comment);
    }
    
    //���� �� ��� ����Ʈ
    @GetMapping("/usercommentlist")
    public String CommentUserList(CommentVO vo, Model model) {
    	List<CommentVO> cList = service.getListUserComment(vo);
    	for (CommentVO comment : cList) {
    		System.out.println("��۸��" + comment);
    	}
    	model.addAttribute("usercomment", cList);
    	return "userComment";
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
    @RequestMapping("/commentdelete")  
    //@ResponseBody
    public int CommentServiceDelete(int cnum) {
        return service.deleteComment(cnum);
    }
}
