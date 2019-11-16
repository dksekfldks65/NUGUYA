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
import com.gamePlatForm.dto.SlideFaceWritingDto;
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
    	
    	if(faceWritingDto.getPartici_num() != 0) {
    		double average = (double)faceWritingDto.getScore() / faceWritingDto.getPartici_num();
    		faceWritingDto.setAverage(Math.round(average*10)/10.0);
    	}
    	
    	List<SlideFaceWritingDto> slideFaceWritingList = faceWritingService.getSlideFaceWritingList(faceWritingDto);
    	
    	int slideSize = slideFaceWritingList.size();
    	
    	//슬라이드 총 개수
    	faceWritingDto.setSlideSize(slideSize);
    	
    	model.addAttribute("faceWritingDto", faceWritingDto);
    	model.addAttribute("slideFaceWritingList", slideFaceWritingList);
    	
        return "/detail";
    }
    
    /*
     **  게시글 참여자수, 총점 업데이트
     */
    @RequestMapping(value = "/updateWritingInfo", method = RequestMethod.POST)
    public @ResponseBody boolean updateWritingInfo(HttpSession session, HttpServletRequest request, FaceWritingDto faceWritingDto) throws Exception{
    	
    	boolean isSuccess = faceWritingService.updateWritingInfo(faceWritingDto);

        return isSuccess;
    } 
    	

}
