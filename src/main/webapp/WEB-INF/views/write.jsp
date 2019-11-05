<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NUGUYA</title>
</head>
<body>
                                             
  <form action="insertWriting" method="post" enctype="multipart/form-data">
  	<input type="hidden" id="writing_div_cd" name="writing_div_cd" value="10"/>
    <div>
	  <p> 제목: <input type="text" id="title" name="title" style="width:200px"> </p>
    </div>
    <div>
	  <p> 
	  	     대표이미지: <input type="file" id="title_img_file"  name="title_img_file"  style="width:200px"> 
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file1"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file1" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer1"         name="answer1"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file2"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file2" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer2"         name="answer2"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file3"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file3" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer3"         name="answer3"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file4"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file4" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer4"         name="answer4"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file5"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file5" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer5"         name="answer5"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file6"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file6" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer6"         name="answer6"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file7"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file7" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer7"         name="answer7"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file8"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file8" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer8"         name="answer8"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file9"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file9" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer9"         name="answer9"         style="width:150px">
	  </p>
	  <p> 
	              원본이미지: <input type="file" id="ori_img_file10"   name="ori_img_file"   style="width:200px"> 
	 	     합성이미지: <input type="file" id="compo_img_file10" name="compo_img_file" style="width:200px">
	 	     정답:     <input type="text" id="answer10"         name="answer10"         style="width:150px">
	  </p>
	  <p>
	  	  랜덤보기: <input type="text" id="rand_answer" name="rand_answer" style="width:708px">
	  </p>
	  <p>
	  	 -> 랜덤보기는 ',' 기준으로 입력해주세요 (ex) 권상우,나현,전지현,수지,효린,박보영,공효진,공유
	  </p>
	  <button type ="submit">게시글 업로드</button>
	</div>
  </form>

</body>
</html>