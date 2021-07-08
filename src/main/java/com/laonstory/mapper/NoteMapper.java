package com.laonstory.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.laonstory.vo.NoteVO;
import com.laonstory.vo.SearchVO;

@Repository
@Mapper
public interface NoteMapper {

	public NoteVO getNote(NoteVO vo);
	public List<NoteVO> getListNote();
	public void insertNote(NoteVO vo);
	//public void updateNote(NoteVO vo);
	public void deleteNote(NoteVO vo);
	public List<NoteVO> getListSearch(SearchVO vo);
}
