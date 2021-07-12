package com.laonstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laonstory.mapper.MessageMapper;
import com.laonstory.vo.MessageVO;
import com.laonstory.vo.SearchVO;

@Service
public class MessageService implements MessageMapper{

	@Autowired
	private MessageMapper mapper;

	@Override
	public MessageVO getMessage(MessageVO vo) {
		return mapper.getMessage(vo);
	}

	@Override
	public List<MessageVO> getListMessage(MessageVO vo) {
		return mapper.getListMessage(vo);
	}
	
	@Override
	public List<MessageVO> getListUserMessage(MessageVO vo) {
		return mapper.getListUserMessage(vo);
	}

	@Override
	public void insertMessage(MessageVO vo) {
		mapper.insertMessage(vo);
	}

	@Override
	public void deleteMessage(int messagenum) {
		mapper.deleteMessage(messagenum);
	}

	@Override
	public List<MessageVO> getListSearch(SearchVO vo) {
		return mapper.getListSearch(vo);
	}
	
}
