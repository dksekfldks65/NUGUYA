package com.gamePlatForm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gamePlatForm.dao.FaceWritingDao;
import com.gamePlatForm.dto.FaceWritingDto;

@Service
public class FaceWritingService {
	
	private static final Logger logger = LoggerFactory.getLogger(FaceWritingService.class);
	
	@Autowired
    private FaceWritingDao faceWritingDao;
	
	@Autowired FileUploadService fileUploadService;
	
    /*
     ** 게시글 작성
     */
    public void insertWriting(FaceWritingDto faceWritingDto, MultipartFile title_img_file, List<MultipartFile> ori_img_files, List<MultipartFile> compo_img_files) throws Exception{
    	
    	try {
    		//제목 이미지 업로드 및 경로 세팅
    		String title_img_path = fileUploadService.restore(title_img_file);
    		faceWritingDto.setTitle_img_path(title_img_path);
    		
    		//원본, 합성 이미지 업로드 및 경로 세팅, 원본과 합성이미지의 개수는 같음
    		int len = 0;
    		int imgFilesSize = ori_img_files.size();
    		for(int j=0;j<imgFilesSize;j++) {
    			if(!ori_img_files.get(j).isEmpty()) {
    				len++;
    			} else {
    				break;
    			}
    		}
    		
    		for(int i=1;i<=len;i++) {
    			
    			String ori_img_path   = fileUploadService.restore(ori_img_files.get(i-1));
    			String compo_img_path = fileUploadService.restore(compo_img_files.get(i-1));
    			
    			if(i == 1) {
    				faceWritingDto.setOri_img_path1(ori_img_path);
    				faceWritingDto.setCompo_img_path1(compo_img_path);
    			} else if(i == 2) {
    				faceWritingDto.setOri_img_path2(ori_img_path);
    				faceWritingDto.setCompo_img_path2(compo_img_path);
    			} else if(i == 3) {
    				faceWritingDto.setOri_img_path3(ori_img_path);
    				faceWritingDto.setCompo_img_path3(compo_img_path);
    			} else if(i == 4) {
    				faceWritingDto.setOri_img_path4(ori_img_path);
    				faceWritingDto.setCompo_img_path4(compo_img_path);    				
    			} else if(i == 5) {
    				faceWritingDto.setOri_img_path5(ori_img_path);
    				faceWritingDto.setCompo_img_path5(compo_img_path);
    			} else if(i == 6) {
    				faceWritingDto.setOri_img_path6(ori_img_path);
    				faceWritingDto.setCompo_img_path6(compo_img_path);
    			} else if(i == 7) {
    				faceWritingDto.setOri_img_path7(ori_img_path);
    				faceWritingDto.setCompo_img_path7(compo_img_path);
    			} else if(i == 8) {
    				faceWritingDto.setOri_img_path8(ori_img_path);
    				faceWritingDto.setCompo_img_path8(compo_img_path);
    			} else if(i == 9) {
    				faceWritingDto.setOri_img_path9(ori_img_path);
    				faceWritingDto.setCompo_img_path9(compo_img_path);
    			} else if(i == 10) {
    				faceWritingDto.setOri_img_path10(ori_img_path);
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
	
}
