package com.gamePlatForm.dto;

import java.util.Date;

public class FaceWritingDto {

	private int    writing_no;            //게시글 번호
	private String writing_div_cd;        //게시글 구분코드 10: 얼굴매칭
	private String title;                 //제목
	private String answer1;               //정답1
	private String answer2;				  //정답2
	private String answer3;				  //정답3
	private String answer4;		          //정답4		
	private String answer5;				  //정답5
	private String answer6;			      //정답6
	private String answer7;				  //정답7
	private String answer8;				  //정답8
	private String answer9;				  //정답9
	private String answer10;  			  //정답10
	private String rand_answer;			  //랜덤 보기
	private String regpe_id;			  //등록자
	private	String modpe_id;			  //변경자
	private Date   reg_dts;				  //등록일
	private Date   mod_dts;				  //변경일
	
	private String title_img_path;        //제목 이미지 경로
	private String ori_img_path1;         //원본 이미지 경로1
	private String ori_img_path2;		  //원본 이미지 경로2
	private String ori_img_path3;		  //원본 이미지 경로3
	private String ori_img_path4;		  //원본 이미지 경로4
	private String ori_img_path5;		  //원본 이미지 경로5
	private String ori_img_path6;		  //원본 이미지 경로6
	private String ori_img_path7;		  //원본 이미지 경로7
	private String ori_img_path8;		  //원본 이미지 경로8
	private String ori_img_path9;		  //원본 이미지 경로9
	private String ori_img_path10;		  //원본 이미지 경로10
	
	private String compo_img_path1;       //합성 이미지 경로1
	private String compo_img_path2;       //합성 이미지 경로2
	private String compo_img_path3;       //합성 이미지 경로3
	private String compo_img_path4;       //합성 이미지 경로4
	private String compo_img_path5;       //합성 이미지 경로5
	private String compo_img_path6;       //합성 이미지 경로6
	private String compo_img_path7;       //합성 이미지 경로7
	private String compo_img_path8;       //합성 이미지 경로8
	private String compo_img_path9;       //합성 이미지 경로9
	private String compo_img_path10;      //합성 이미지 경로10
	private String user_id;               //유저아이디
	
	private int    start;                 //페이지 결과 시작 번호
	private int    end;                   //페이지 결과 마지막 번호
	private int    page;                  //페이지 번호
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
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
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getAnswer5() {
		return answer5;
	}
	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}
	public String getAnswer6() {
		return answer6;
	}
	public void setAnswer6(String answer6) {
		this.answer6 = answer6;
	}
	public String getAnswer7() {
		return answer7;
	}
	public void setAnswer7(String answer7) {
		this.answer7 = answer7;
	}
	public String getAnswer8() {
		return answer8;
	}
	public void setAnswer8(String answer8) {
		this.answer8 = answer8;
	}
	public String getAnswer9() {
		return answer9;
	}
	public void setAnswer9(String answer9) {
		this.answer9 = answer9;
	}
	public String getAnswer10() {
		return answer10;
	}
	public void setAnswer10(String answer10) {
		this.answer10 = answer10;
	}
	public String getRand_answer() {
		return rand_answer;
	}
	public void setRand_answer(String rand_answer) {
		this.rand_answer = rand_answer;
	}
	public String getRegpe_id() {
		return regpe_id;
	}
	public void setRegpe_id(String regpe_id) {
		this.regpe_id = regpe_id;
	}
	public String getModpe_id() {
		return modpe_id;
	}
	public void setModpe_id(String modpe_id) {
		this.modpe_id = modpe_id;
	}
	public Date getReg_dts() {
		return reg_dts;
	}
	public void setReg_dts(Date reg_dts) {
		this.reg_dts = reg_dts;
	}
	public Date getMod_dts() {
		return mod_dts;
	}
	public void setMod_dts(Date mod_dts) {
		this.mod_dts = mod_dts;
	}
	public String getTitle_img_path() {
		return title_img_path;
	}
	public void setTitle_img_path(String title_img_path) {
		this.title_img_path = title_img_path;
	}
	public String getOri_img_path1() {
		return ori_img_path1;
	}
	public void setOri_img_path1(String ori_img_path1) {
		this.ori_img_path1 = ori_img_path1;
	}
	public String getOri_img_path2() {
		return ori_img_path2;
	}
	public void setOri_img_path2(String ori_img_path2) {
		this.ori_img_path2 = ori_img_path2;
	}
	public String getOri_img_path3() {
		return ori_img_path3;
	}
	public void setOri_img_path3(String ori_img_path3) {
		this.ori_img_path3 = ori_img_path3;
	}
	public String getOri_img_path4() {
		return ori_img_path4;
	}
	public void setOri_img_path4(String ori_img_path4) {
		this.ori_img_path4 = ori_img_path4;
	}
	public String getOri_img_path5() {
		return ori_img_path5;
	}
	public void setOri_img_path5(String ori_img_path5) {
		this.ori_img_path5 = ori_img_path5;
	}
	public String getOri_img_path6() {
		return ori_img_path6;
	}
	public void setOri_img_path6(String ori_img_path6) {
		this.ori_img_path6 = ori_img_path6;
	}
	public String getOri_img_path7() {
		return ori_img_path7;
	}
	public void setOri_img_path7(String ori_img_path7) {
		this.ori_img_path7 = ori_img_path7;
	}
	public String getOri_img_path8() {
		return ori_img_path8;
	}
	public void setOri_img_path8(String ori_img_path8) {
		this.ori_img_path8 = ori_img_path8;
	}
	public String getOri_img_path9() {
		return ori_img_path9;
	}
	public void setOri_img_path9(String ori_img_path9) {
		this.ori_img_path9 = ori_img_path9;
	}
	public String getOri_img_path10() {
		return ori_img_path10;
	}
	public void setOri_img_path10(String ori_img_path10) {
		this.ori_img_path10 = ori_img_path10;
	}
	public String getCompo_img_path1() {
		return compo_img_path1;
	}
	public void setCompo_img_path1(String compo_img_path1) {
		this.compo_img_path1 = compo_img_path1;
	}
	public String getCompo_img_path2() {
		return compo_img_path2;
	}
	public void setCompo_img_path2(String compo_img_path2) {
		this.compo_img_path2 = compo_img_path2;
	}
	public String getCompo_img_path3() {
		return compo_img_path3;
	}
	public void setCompo_img_path3(String compo_img_path3) {
		this.compo_img_path3 = compo_img_path3;
	}
	public String getCompo_img_path4() {
		return compo_img_path4;
	}
	public void setCompo_img_path4(String compo_img_path4) {
		this.compo_img_path4 = compo_img_path4;
	}
	public String getCompo_img_path5() {
		return compo_img_path5;
	}
	public void setCompo_img_path5(String compo_img_path5) {
		this.compo_img_path5 = compo_img_path5;
	}
	public String getCompo_img_path6() {
		return compo_img_path6;
	}
	public void setCompo_img_path6(String compo_img_path6) {
		this.compo_img_path6 = compo_img_path6;
	}
	public String getCompo_img_path7() {
		return compo_img_path7;
	}
	public void setCompo_img_path7(String compo_img_path7) {
		this.compo_img_path7 = compo_img_path7;
	}
	public String getCompo_img_path8() {
		return compo_img_path8;
	}
	public void setCompo_img_path8(String compo_img_path8) {
		this.compo_img_path8 = compo_img_path8;
	}
	public String getCompo_img_path9() {
		return compo_img_path9;
	}
	public void setCompo_img_path9(String compo_img_path9) {
		this.compo_img_path9 = compo_img_path9;
	}
	public String getCompo_img_path10() {
		return compo_img_path10;
	}
	public void setCompo_img_path10(String compo_img_path10) {
		this.compo_img_path10 = compo_img_path10;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
