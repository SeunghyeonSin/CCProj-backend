package com.laonstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laonstory.mapper.CommentMapper;
import com.laonstory.vo.CommentVO;

@Service
public class CommentService implements CommentMapper{

	@Autowired
	private CommentMapper mapper;

	@Override
	public int countComment(int boardid) {
		return mapper.countComment(boardid);
	}
	
	@Override
	public CommentVO getComment(CommentVO vo) {
		return mapper.getComment(vo);
	}

	@Override
	public List<CommentVO> getListComment(int boardid) {
		return mapper.getListComment(boardid);
	}

	@Override
	public List<CommentVO> getListUserComment(CommentVO vo) {
		return mapper.getListUserComment(vo);
	}

	@Override
	public String insertComment(CommentVO vo) {
		return mapper.insertComment(vo);	
	}

	@Override
	public String updateComment(CommentVO vo) {
		return mapper.updateComment(vo);
	}

	@Override
	public int deleteComment(int commentid) {
		return mapper.deleteComment(commentid);
	}

	@Override
	public int boardDeleteComment(int boardid) {
		return mapper.boardDeleteComment(boardid);
	}
}
