package com.gamePlatForm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gamePlatForm.dto.FaceWritingDto;

@Repository
public class FaceWritingDao {

	@Autowired
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.gamPlatForm.mapper.faceWritingMapper";
    
    //게시글 작성
    public void insertWriting(FaceWritingDto faceWritingDto){
    	sqlSession.insert(Namespace+".insertWriting", faceWritingDto);
    }
    
    //게시글 작성 시 이미지 등록
    public void insertWritingImg(FaceWritingDto faceWritingDto){
    	sqlSession.insert(Namespace+".insertWritingImg", faceWritingDto);
    }
    
    //메인페이지 게시글 페이징 처리 불러오기
    public List<FaceWritingDto> getMainPageFaceWritingList(FaceWritingDto faceWritingDto){
    	return sqlSession.selectList(Namespace+".getMainPageFaceWritingList", faceWritingDto);
    }
    
    //메인페이지 한번에 불러오기 
    public List<FaceWritingDto> getMainFaceWritingList(){
    	return sqlSession.selectList(Namespace+".getMainFaceWritingList");
    }
	
}
