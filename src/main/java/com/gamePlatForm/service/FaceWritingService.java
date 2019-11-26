package com.gamePlatForm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gamePlatForm.dao.FaceWritingDao;
import com.gamePlatForm.dto.FaceWritingDto;
import com.gamePlatForm.dto.SlideFaceWritingDto;

@Service
public class FaceWritingService {
	
	private static final Logger logger = LoggerFactory.getLogger(FaceWritingService.class);
	
	@Autowired
    private FaceWritingDao faceWritingDao;
	
	@Autowired FileUploadService fileUploadService;
	
    /*
     ** 게시글 작성
     */
    public void insertWriting(FaceWritingDto faceWritingDto, MultipartHttpServletRequest multipartRequest) throws Exception{
    	
    	try {
    		
    		//저장 경로 생성
    		String appName = "nuguya";
    		String path = fileUploadService.makeSaveFilePath(appName);
    		
    		//제목 이미지 업로드 및 경로 세팅
    		String title_img_path = fileUploadService.restore(multipartRequest.getFile("title_img_file"), path);
    		faceWritingDto.setTitle_img_path(title_img_path);
    		
    		List<MultipartFile> oriImgFile   = multipartRequest.getFiles("ori_img_file");
    		List<MultipartFile> compoImgFile = multipartRequest.getFiles("compo_img_file");
    		
    		int oriImgFileSize   = oriImgFile.size();
    		int compoImgFileSize = compoImgFile.size();
    		
    		int oriLen   = 0;
    		int compoLen = 0;
    		
    		for(int j=0;j<oriImgFileSize;j++) {
    			if(!oriImgFile.get(j).isEmpty()) {
    				oriLen++;
    			} else {
    				break;
    			}
    		}
    		
    		for(int j=0;j<compoImgFileSize;j++) {
    			if(!compoImgFile.get(j).isEmpty()) {
    				compoLen++;
    			} else {
    				break;
    			}
    		}
    		
    		for(int i=1;i<=oriLen;i++) {
    			String ori_img_path   = fileUploadService.restore(oriImgFile.get(i-1), path);
    			
    			if(i == 1) {
    				faceWritingDto.setOri_img_path1(ori_img_path);
    			} else if(i == 2) {
    				faceWritingDto.setOri_img_path2(ori_img_path);
    			} else if(i == 3) {
    				faceWritingDto.setOri_img_path3(ori_img_path);
    			} else if(i == 4) {
    				faceWritingDto.setOri_img_path4(ori_img_path); 				
    			} else if(i == 5) {
    				faceWritingDto.setOri_img_path5(ori_img_path);
    			} else if(i == 6) {
    				faceWritingDto.setOri_img_path6(ori_img_path);
    			} else if(i == 7) {
    				faceWritingDto.setOri_img_path7(ori_img_path);
    			} else if(i == 8) {
    				faceWritingDto.setOri_img_path8(ori_img_path);
    			} else if(i == 9) {
    				faceWritingDto.setOri_img_path9(ori_img_path);
    			} else if(i == 10) {
    				faceWritingDto.setOri_img_path10(ori_img_path);
    			}
    			
    		}
    		
    		for(int i=1;i<=compoLen;i++) {
    			String compo_img_path   = fileUploadService.restore(compoImgFile.get(i-1), path);
    			
    			if(i == 1) {
    				faceWritingDto.setCompo_img_path1(compo_img_path);
    			} else if(i == 2) {
    				faceWritingDto.setCompo_img_path2(compo_img_path);
    			} else if(i == 3) {
    				faceWritingDto.setCompo_img_path3(compo_img_path);
    			} else if(i == 4) {
    				faceWritingDto.setCompo_img_path4(compo_img_path);    				
    			} else if(i == 5) {
    				faceWritingDto.setCompo_img_path5(compo_img_path);
    			} else if(i == 6) {
    				faceWritingDto.setCompo_img_path6(compo_img_path);
    			} else if(i == 7) {
    				faceWritingDto.setCompo_img_path7(compo_img_path);
    			} else if(i == 8) {
    				faceWritingDto.setCompo_img_path8(compo_img_path);
    			} else if(i == 9) {
    				faceWritingDto.setCompo_img_path9(compo_img_path);
    			} else if(i == 10) {
    				faceWritingDto.setCompo_img_path10(compo_img_path);
    			}
    		}
    		
			faceWritingDao.insertWriting(faceWritingDto);
			faceWritingDao.insertWritingImg(faceWritingDto);
			
    	} catch(Exception e) {
    		System.err.println(e.getMessage());
    		throw new RuntimeException(e);
    	}
    	
    }
    
    /*
     ** 메인페이지 게시글 페이징 조회
     */
    public List<FaceWritingDto> getMainPageFaceWritingList(FaceWritingDto faceWritingDto) throws Exception{
    	
    	int start = (faceWritingDto.getPage_num()-1)*faceWritingDto.getPage_size();
    	int end   = faceWritingDto.getPage_num()*faceWritingDto.getPage_size();

    	faceWritingDto.setStart(start);
    	faceWritingDto.setEnd(end);
    	
    	List<FaceWritingDto> pagingFaceWritingList = new ArrayList<FaceWritingDto>();
    	
    	try {
    		pagingFaceWritingList = faceWritingDao.getMainPageFaceWritingList(faceWritingDto);
    	} catch(Exception e) {
    		System.err.println(e.getMessage());
    	}
    	
    	return pagingFaceWritingList;
    }
    
    /*
     ** 메인페이지 게시글 조회
     */
    public List<FaceWritingDto> getMainFaceWritingList() throws Exception{
    	
    	List<FaceWritingDto> pagingFaceWritingList = new ArrayList<FaceWritingDto>();
    	
    	try {
    		pagingFaceWritingList = faceWritingDao.getMainFaceWritingList();
    	} catch(Exception e) {
    		
    	}
    	
    	return pagingFaceWritingList;
    }
    
    /*
     ** 메인페이지 게시글 조회
     */
    public FaceWritingDto getFaceWritingDto(FaceWritingDto faceWritingDto) throws Exception{
    	
    	try {
    		faceWritingDto = faceWritingDao.getFaceWritingDto(faceWritingDto);
    	} catch(Exception e){
    		System.err.println(e.getMessage());
    	}
    	return faceWritingDto;
    }
    
    /*
     ** 슬라이드 객체 생성
     */
    public List<SlideFaceWritingDto> getSlideFaceWritingList(FaceWritingDto faceWritingDto) throws Exception{
    
    	//랜덤 보기 리스트 생성
    	String options = faceWritingDto.getRand_answer();
    	List<String> optionList = Arrays.asList(options.split(","));
    	
    	//상세 페이지 Slide 상세 객체 리스트
    	List<SlideFaceWritingDto> slideFaceWritingDtoList = new ArrayList<SlideFaceWritingDto>();
    	
    	for(int i=1;i<=10;i++) {
    		
    		String answer = getAnswer(faceWritingDto, i);

    		if("".equals(answer)) {
    			continue;
    		}
    		
    		SlideFaceWritingDto curSlideDto = new SlideFaceWritingDto();
    		//정답 세팅
    		curSlideDto.setAnswer(answer);
    		
    		// 랜덤보기 리스트 셔플 후 앞에 3개만 넣기
    		Collections.shuffle(optionList); 
    		curSlideDto.getRand_answer().add(answer);
    		
    		for(int j=0;j<3;j++) {
    			String tempAnswer = optionList.get(j);
    			curSlideDto.getRand_answer().add(tempAnswer); 
    		}
    		
    		Collections.shuffle(curSlideDto.getRand_answer());
    		
    		//합성이미지, 합성전 이미지 path 설정
    		String ori_img_path    = getOriImgPath(faceWritingDto, i);
    		String compo_img_path  = getCompoImgPath(faceWritingDto, i);
    		curSlideDto.setOri_img_path(ori_img_path);
    		curSlideDto.setCompo_img_path(compo_img_path);
    		
    		slideFaceWritingDtoList.add(curSlideDto);
    	}
    	
    	return slideFaceWritingDtoList;
    }
    
    /*
     ** 참여자 수, 총점 업데이트
     */
    public boolean updateWritingInfo(FaceWritingDto faceWritingDto) throws Exception{
    	boolean isSuccess = false;
    	
    	try {
    		
    		faceWritingDao.updateWritingInfo(faceWritingDto);
    	
    		isSuccess = true;
    	} catch(Exception e) {
    		
    	}
    	
    	return isSuccess;
    }
    
    /*
     ** 인덱스에 따른 정답값 얻어옴
     */
    public String getAnswer(FaceWritingDto faceWritingDto, int index) throws Exception{
    	
    	String answer="";
    	
    	if(index == 1) {
    		answer = faceWritingDto.getAnswer1();
    	} else if(index == 2) {
    		answer = faceWritingDto.getAnswer2();
    	} else if(index == 3) {
    		answer = faceWritingDto.getAnswer3();
    	} else if(index == 4) {
    		answer = faceWritingDto.getAnswer4();
    	} else if(index == 5) {
    		answer = faceWritingDto.getAnswer5();
    	} else if(index == 6) {
    		answer = faceWritingDto.getAnswer6();
    	} else if(index == 7) {
    		answer = faceWritingDto.getAnswer7();
    	} else if(index == 8) {
    		answer = faceWritingDto.getAnswer8();
    	} else if(index == 9) {
    		answer = faceWritingDto.getAnswer9();
    	} else if(index == 10) {
    		answer = faceWritingDto.getAnswer10();
    	}
    	
    	return answer;
    }
    
    /*
     ** 인덱스에 따른 합성전 이미지 경로 획득
     */
    public String getOriImgPath(FaceWritingDto faceWritingDto, int index) throws Exception{
    	
    	String oriImgPath = "";
		
    	if(index == 1) {
    		oriImgPath = faceWritingDto.getOri_img_path1();
    	} else if(index == 2) {
    		oriImgPath = faceWritingDto.getOri_img_path2();
    	} else if(index == 3) {
    		oriImgPath = faceWritingDto.getOri_img_path3();
    	} else if(index == 4) {
    		oriImgPath = faceWritingDto.getOri_img_path4();
    	} else if(index == 5) {
    		oriImgPath = faceWritingDto.getOri_img_path5();
    	} else if(index == 6) {
    		oriImgPath = faceWritingDto.getOri_img_path6();
    	} else if(index == 7) {
    		oriImgPath = faceWritingDto.getOri_img_path7();
    	} else if(index == 8) {
    		oriImgPath = faceWritingDto.getOri_img_path8();
    	} else if(index == 9) {
    		oriImgPath = faceWritingDto.getOri_img_path9();
    	} else if(index == 10) {
    		oriImgPath = faceWritingDto.getOri_img_path10();
    	}
    	
    	return oriImgPath;
    }
    
    /*
     ** 인덱스에 따른 합성 이미지 경로 획득
     */
    public String getCompoImgPath(FaceWritingDto faceWritingDto, int index) throws Exception{
    	String compoImgPath = "";
    	
    	if(index == 1) {
    		compoImgPath = faceWritingDto.getCompo_img_path1();
    	} else if(index == 2) {
    		compoImgPath = faceWritingDto.getCompo_img_path2();
    	} else if(index == 3) {
    		compoImgPath = faceWritingDto.getCompo_img_path3();
    	} else if(index == 4) {
    		compoImgPath = faceWritingDto.getCompo_img_path4();
    	} else if(index == 5) {
    		compoImgPath = faceWritingDto.getCompo_img_path5();
    	} else if(index == 6) {
    		compoImgPath = faceWritingDto.getCompo_img_path6();
    	} else if(index == 7) {
    		compoImgPath = faceWritingDto.getCompo_img_path7();
    	} else if(index == 8) {
    		compoImgPath = faceWritingDto.getCompo_img_path8();
    	} else if(index == 9) {
    		compoImgPath = faceWritingDto.getCompo_img_path9();
    	} else if(index == 10) {
    		compoImgPath = faceWritingDto.getCompo_img_path10();
    	}
    	
    	return compoImgPath;
    }
}
