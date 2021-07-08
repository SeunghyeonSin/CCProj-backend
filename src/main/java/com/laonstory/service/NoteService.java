package com.laonstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laonstory.mapper.NoteMapper;
import com.laonstory.vo.NoteVO;
import com.laonstory.vo.SearchVO;

@Service
public class NoteService implements NoteMapper{

	@Autowired
	private NoteMapper mapper;

	@Override
	public NoteVO getNote(NoteVO vo) {
		return mapper.getNote(vo);
	}

	@Override
	public List<NoteVO> getListNote() {
		return mapper.getListNote();
	}

	@Override
	public void insertNote(NoteVO vo) {
		mapper.insertNote(vo);
	}

	@Override
	public void deleteNote(NoteVO vo) {
		mapper.deleteNote(vo);
	}

	@Override
	public List<NoteVO> getListSearch(SearchVO vo) {
		return mapper.getListSearch(vo);
	}
	
}
