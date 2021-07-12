package com.laonstory.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.laonstory.vo.MessageVO;
import com.laonstory.vo.SearchVO;

@Repository
@Mapper
public interface MessageMapper {

	public MessageVO getMessage(MessageVO vo);
	public List<MessageVO> getListMessage(MessageVO vo);
	public void insertMessage(MessageVO vo);
	public void deleteMessage(int messagenum);
	public List<MessageVO> getListSearch(SearchVO vo);
}
