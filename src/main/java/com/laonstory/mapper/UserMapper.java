package com.laonstory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.laonstory.vo.SearchVO;
import com.laonstory.vo.UserVO;

@Repository
@Mapper
public interface UserMapper {

	public List<UserVO> selectUser();
	public UserVO getUser(UserVO vo);
	public UserVO loginCheck(UserVO vo);
	public void insertUser(UserVO vo);
	public UserVO idCheck(String memId);
	public UserVO nickCheck(String memNickname);
	public void updateUser(UserVO vo);
	public void deleteUser(UserVO vo);
	public List<UserVO> getListSearch(SearchVO vo);
}
