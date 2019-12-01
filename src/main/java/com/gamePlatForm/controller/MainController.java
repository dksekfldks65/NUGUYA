package com.gamePlatForm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gamePlatForm.dto.FaceWritingDto;
import com.gamePlatForm.service.FaceWritingService;

/**
 * 메인페이지 컨트롤러
 * @ author : GOOHOON
 * @ version 1.0
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private FaceWritingService faceWritingService;
	
    /*
     ** 메인 페이지 이동
     */
	/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String write(HttpSession session, HttpServletRequest request, Model model) throws Exception{
    	
    	List<FaceWritingDto> writingDtlDtoList = faceWritingService.getMainFaceWritingList();
    	
    	model.addAttribute("writingDtlDtoList", writingDtlDtoList);
    	
        return "/index";
    }
	 */
    
	/*
     ** 메인 페이지 이동
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpSession session, HttpServletRequest request, Model model) throws Exception{
    	
    	List<FaceWritingDto> writingDtlDtoList = faceWritingService.getMainFaceWritingList();
    	
    	model.addAttribute("writingDtlDtoList", writingDtlDtoList);
    	
        return "/home";
    }
    
    /*
     ** 메인페이지 비동기 페이징 처리
     */    
    @RequestMapping(value = "/getMainPagingList", method = RequestMethod.GET)
    public @ResponseBody List<FaceWritingDto> getPagingList(HttpSession session, HttpServletRequest request, FaceWritingDto faceWritingDto) throws Exception{
    	
    	List<FaceWritingDto> writingDtlDtoList = faceWritingService.getMainPageFaceWritingList(faceWritingDto);

        return writingDtlDtoList;
    }
    
    @RequestMapping(value = "/faceShare", method = RequestMethod.GET)
    public String faceShare(HttpSession session, HttpServletRequest request, Model model) throws Exception{
    	
        return "/faceShare";
    }
    
}
