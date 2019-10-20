package com.gamePlatForm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gamePlatForm.dto.UserDto;

@Repository
public class UserDao {

	@Autowired
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.gamPlatForm.mapper.userMapper";
    
    public String getNickname(){
    	return sqlSession.selectOne(Namespace+".getNickname");
    }
    
}
