package com.laonstory.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.laonstory.vo.BoardVO;
import com.laonstory.vo.FileVO;
import com.laonstory.vo.SearchVO;

@Repository
@Mapper
public interface BoardMapper {

	public BoardVO getBoard(BoardVO vo);
	public FileVO fileDetail(int bnum);
	public List<BoardVO> getListBoard(String btype);
	public List<BoardVO> getListUserBoard(BoardVO vo);
	public void cntBoard(BoardVO vo);
	public void insertBoard(BoardVO vo);
	public int fileInsert(FileVO file);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(int bnum);
	public List<BoardVO> getListSearch(SearchVO vo);
}
