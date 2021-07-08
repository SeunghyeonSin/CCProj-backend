package com.laonstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laonstory.mapper.UserMapper;
import com.laonstory.vo.SearchVO;
import com.laonstory.vo.UserVO;

@Service
public class UserService implements UserMapper{

	@Autowired
	private UserMapper mapper;

	@Override
	public List<UserVO> selectUser() {
		return mapper.selectUser();
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return mapper.getUser(vo);
	}


	@Override
	public UserVO loginCheck(UserVO vo) {
		return mapper.loginCheck(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		mapper.insertUser(vo);
	}

	@Override
	public UserVO idCheck(String memId) {
		return mapper.idCheck(memId);
	}

	@Override
	public UserVO nickCheck(String memNickname) {
		return mapper.nickCheck(memNickname);
	}

	@Override
	public void updateUser(UserVO vo) {
		mapper.updateUser(vo);
		
	}

	@Override
	public void deleteUser(UserVO vo) {
		mapper.deleteUser(vo);
		
	}

	@Override
	public List<UserVO> getListSearch(SearchVO vo) {
		return mapper.getListSearch(vo);
	}
}
