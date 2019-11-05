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

import com.gamePlatForm.dto.FaceWritingDto;
import com.gamePlatForm.service.FaceWritingService;

/**
 * 게시글 상세 컨트롤러
 * @ author : GOOHOON
 * @ version 1.0
 */
@Controller
public class DetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	
	@Autowired
	private FaceWritingService faceWritingService;
	
    /*
     ** 메인 페이지 이동
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(HttpSession session, HttpServletRequest request, Model model, FaceWritingDto faceWritingDto) throws Exception{
    	
    	faceWritingDto = faceWritingService.getFaceWritingDto(faceWritingDto);
    	
    	model.addAttribute("faceWritingDto", faceWritingDto);
    	
        return "/detail";
    }

}
