package com.gamePlatForm.dto;

import java.util.ArrayList;
import java.util.List;

public class SlideFaceWritingDto extends BaseDto{
	
	private int    writing_no;            //게시글 번호
	private String writing_div_cd;        //게시글 구분코드 10: 얼굴매칭
	private String title;                 //제목
	private String answer;                //정답1
	private String title_img_path;        //제목 이미지 경로
	private String ori_img_path;          //원본 이미지 경로1
	private String compo_img_path;        //합성 이미지 경로1
	private List<String> rand_answer;	  //랜덤 보기
	
	public SlideFaceWritingDto() {
		this.rand_answer = new ArrayList<String>();
	}
	
	public int getWriting_no() {
		return writing_no;
	}
	public void setWriting_no(int writing_no) {
		this.writing_no = writing_no;
	}
	public String getWriting_div_cd() {
		return writing_div_cd;
	}
	public void setWriting_div_cd(String writing_div_cd) {
		this.writing_div_cd = writing_div_cd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTitle_img_path() {
		return title_img_path;
	}
	public void setTitle_img_path(String title_img_path) {
		this.title_img_path = title_img_path;
	}
	public String getOri_img_path() {
		return ori_img_path;
	}
	public void setOri_img_path(String ori_img_path) {
		this.ori_img_path = ori_img_path;
	}
	public String getCompo_img_path() {
		return compo_img_path;
	}
	public void setCompo_img_path(String compo_img_path) {
		this.compo_img_path = compo_img_path;
	}
	public List<String> getRand_answer() {
		return rand_answer;
	}
	public void setRand_answer(List<String> rand_answer) {
		this.rand_answer = rand_answer;
	}
}
