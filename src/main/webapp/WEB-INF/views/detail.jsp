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
    <link href="/nuguya/resources/app.css" rel="stylesheet"></head>
</head>

<body>

    <header class="header">
      <h1 class="header_logoname">NUGUYA</h1>
    </header>

    <section class="detail">

        <p class="progress">
            <span class="progress_current">1</span>
            <span class="progress_tx">/</span>
            <span class="progress_total">${faceWritingDto.slideSize}</span>
        </p>

        <main class="detail-main">
          <c:forEach items="${slideFaceWritingList}" var="slideFaceWritingDto">
            <!-- [D] 틀렸을때 wrong, 맞췄을때 ok -->
            <section class="unit ok">
                <img src="..${slideFaceWritingDto.ori_img_path}" alt="카드 이미지" class="unit_img">
                <button type="button" class="unit_nextbtn">다음문제</button>
            </section>

            <!-- [D] on : 문제 풀고 나서 추가 -->
            <ul class="questbtn-area on">
              <c:forEach items="${slideFaceWritingDto.rand_answer}" var="randAnswer">

			    <c:choose>
			        <c:when test="${randAnswer == slideFaceWritingDto.answer}">
		                <li>
		                    <button type="button" class="questbtn ok">
		                        <span class="questbtn_tit">${randAnswer}</span>
		                        <span class="questbtn_o"></span>
		                    </button>
		                </li>
			        </c:when>
			        <c:otherwise>
                        <li>
                            <!-- [D] 문제 틀렸을때 wrong , 맞췄을때 ok 추가 -->
                            <button type="button" class="questbtn wrong">
                                <span class="questbtn_tit">${randAnswer}</span>
                                <span class="questbtn_x"></span>
                            </button>
                        </li>
			        </c:otherwise>
			    </c:choose>
              </c:forEach>    
            </ul>
          </c:forEach>
        </main>

    </section>

</body>

	<script src="<c:url value="/resources/app.js" />"></script>
	
</html>