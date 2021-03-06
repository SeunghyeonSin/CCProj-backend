package com.laonstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laonstory.mapper.BoardMapper;
import com.laonstory.vo.BoardVO;
import com.laonstory.vo.FileVO;
import com.laonstory.vo.SearchVO;


@Service
public class BoardService implements BoardMapper{

	@Autowired
	private BoardMapper mapper;

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return mapper.getBoard(vo);
	}
	
	@Override
	public BoardVO selectBoard(int bnum) {
		return mapper.selectBoard(bnum);
	}

	@Override
	public FileVO fileDetail(int bnum) {
		return mapper.fileDetail(bnum);
	}

	@Override
	public List<BoardVO> getListBoard(String btype) {
		return mapper.getListBoard(btype);
	}
	
	@Override
	public List<BoardVO> getListUserBoard(BoardVO vo) {
		return mapper.getListUserBoard(vo);
	}
	
	@Override
	public void cntBoard(BoardVO vo) {
		mapper.cntBoard(vo);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		mapper.insertBoard(vo);
	}
	
	@Override
	public int fileInsert(FileVO file) {
		return mapper.fileInsert(file);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		mapper.updateBoard(vo);
	}

	@Override
	public void deleteBoard(int bnum) {
		mapper.deleteBoard(bnum);
	}

	@Override
	public List<BoardVO> getListSearch(SearchVO vo) {
		return mapper.getListSearch(vo);
	}
	
	
}
