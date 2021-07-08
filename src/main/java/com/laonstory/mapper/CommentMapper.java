package com.laonstory.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.laonstory.vo.CommentVO;

@Repository
@Mapper
public interface CommentMapper {

	public int countComment();
	public CommentVO getComment(CommentVO vo);
	public List<CommentVO> getListComment();
	public String insertComment(CommentVO vo);
	public String updateComment(CommentVO vo);
	public int deleteComment(int commentid);
	//public List<CommentVO> getListSearch(SearchVO vo);
}
