package com.gamePlatForm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gamePlatForm.dto.FaceWritingDto;
import com.gamePlatForm.service.FaceWritingService;

/**
 * 게시글 작성 컨트롤러
 * @ author : GOOHOON
 * @ version 1.0
 */
@Controller
public class PostController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
    @Autowired
    private FaceWritingService faceWritingService;

    /*
     ** 글작성 페이지 이동
     */
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(HttpSession session, HttpServletRequest request) throws Exception{
    	
        return "/write";
    }
    
    /*
     ** 게시글 작성
     */
    @RequestMapping(value="/insertWriting", method = RequestMethod.POST)
    public String insertWriting(HttpServletRequest request, HttpSession session, FaceWritingDto faceWritingDto) throws Exception{
    	
    	faceWritingDto.setUser_id(session.toString()); //유저 아이디 세팅
    	
    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
    	
    	faceWritingService.insertWriting(faceWritingDto, multipartRequest);
    	
    	return "/index";
    }
    
}
