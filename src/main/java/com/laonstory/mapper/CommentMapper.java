package com.laonstory.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.laonstory.vo.CommentVO;

@Repository
@Mapper
public interface CommentMapper {

	public int countComment(int boardid);
	public CommentVO getComment(CommentVO vo);
	public List<CommentVO> getListComment(int boardid);
	public List<CommentVO> getListUserComment(CommentVO vo);
	public String insertComment(CommentVO vo);
	public String updateComment(CommentVO vo);
	public int deleteComment(int commentid);
	public int boardDeleteComment(int boardid);
	//public List<CommentVO> getListSearch(SearchVO vo);
}
