package com.laonstory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.laonstory.vo.LiketoVO;

@Repository
@Mapper
public interface LiketoMapper {

	public LiketoVO selectLiketo(LiketoVO vo);
	public void insertLiketo(LiketoVO vo);
	public void deleteLiketo(LiketoVO vo);
}
