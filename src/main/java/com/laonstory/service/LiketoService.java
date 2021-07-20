package com.laonstory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laonstory.mapper.LiketoMapper;
import com.laonstory.vo.LiketoVO;

@Service
public class LiketoService implements LiketoMapper{

	@Autowired
	private LiketoMapper mapper;
	
	@Override
	public LiketoVO selectLiketo(LiketoVO vo) {
		return mapper.selectLiketo(vo);
	}

	@Override
	public void insertLiketo(LiketoVO vo) {
		mapper.insertLiketo(vo);
	}

	@Override
	public void deleteLiketo(LiketoVO vo) {
		mapper.deleteLiketo(vo);
	}
}
