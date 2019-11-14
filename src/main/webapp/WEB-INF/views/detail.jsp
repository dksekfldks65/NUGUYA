<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>누구야 - 인물 맞추기 게임</title>
</head>

<body>

    <ul class="detail">
        <div class="detail-topinfo">
            <section class="progbar">
                <div class="progbar_back">
                    <div class="progbar_fill"></div>
                </div>
                <span class="progbar_count">
                    <span class="progbar_current">2</span>
                    /
                    <span class="progbar_total">${faceWritingDto.slideSize}</span>
                </span>
            </section>
        </div>

		<c:forEach items="${slideFaceWritingList}" var="slideFaceWritingDto">
        <!-- [D] on : emoji추가 -->
        <section class="detail-main on">
        
            <section class="unit">
                <img src="..${slideFaceWritingDto.ori_img_path}" alt="카드 이미지" class="unit_img">
            </section>
			
            <ul class="detail-btnarea">
      		  <c:forEach items="${slideFaceWritingDto.rand_answer}" var="i">
                <li>
                    <!-- [D] on : 버튼 활성화-->
                    <button type="button" class="questbtn on">
                        <span class="questbtn_tit">${i}</span>
                        <span class="questbtn_o"></span>
                    </button>
                </li>
              </c:forEach>
            </ul>
			
        </section>
		</c:forEach>

</body>

</html>