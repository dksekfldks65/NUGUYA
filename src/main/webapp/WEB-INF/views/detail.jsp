<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>누구야 - 인물 맞추기 게임</title>
<link href="/nuguya/resources/app.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>

	<header class="header">
		<h1 class="header_logoname">NUGUYA</h1>
	</header>

	<section class="detail">

		<p class="progress">
			<span class="progress_current">1</span> <span class="progress_tx">/</span>
			<span class="progress_total">${faceWritingDto.slideSize}</span>
		</p>
		
		<c:forEach items="${slideFaceWritingList}" var="slideFaceWritingDto">
			<main class="detail-main" data-answer=${slideFaceWritingDto.answer}> <!-- [D] 틀렸을때 wrong, 맞췄을때 ok -->
			<section class="unit">
				<img src="..${slideFaceWritingDto.ori_img_path}" alt="카드 이미지"
					class="unit_img">
				<button type="button" class="unit_nextbtn">다음문제</button>
			</section>

			<!-- [D] on : 문제 풀고 나서 추가 -->
			<ul class="questbtn-area">
				<c:forEach items="${slideFaceWritingDto.rand_answer}"
					var="randAnswer">
					<c:choose>
						<c:when test="${randAnswer == slideFaceWritingDto.answer}">
							<li>
								<button type="button" class="questbtn">
									<span class="questbtn_tit">${randAnswer}</span> <span
										class="questbtn_o"></span>
								</button>
							</li>
						</c:when>
						<c:otherwise>
							<li>
								<!-- [D] 문제 틀렸을때 wrong , 맞췄을때 ok 추가 -->
								<button type="button" class="questbtn">
									<span class="questbtn_tit">${randAnswer}</span> <span
										class="questbtn_x"></span>
								</button>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>

			</main>
		</c:forEach>
		
	</section>


	<section class="resultpage">
		<header class="title">${faceWritingDto.title}</header>
		<main class="result">
		<h1 class="result_total">10점 만점에</h1>
		<h1 class="result_current">6점</h1>
		<p class="result_average">유저 평균 점수 4.5점</p>
		</main>
		<ul class="links">
			<li>
				<button class="links_link">
					<img
						src="/nuguya/resources/facebook@2x.png?67ecca68db8c9c32d18b89f0fc48d356"
						alt="">
				</button>
			</li>
			<li>
				<button class="links_link">
					<img
						src="/nuguya/resources/kakao@2x.png?45d79b3e6d1a4c4ecdfe7ae38810d55a"
						alt="">
				</button>
			</li>
		</ul>
		<div class="section result-options">
			<button type="button" class="questbtn">
				<span class="questbtn_tit">메인으로 이동</span>
			</button>
			<button type="button" class="questbtn">
				<span class="questbtn_tit">한 번 더 하기</span>
			</button>
		</div>
	</section>

</body>

<script src="<c:url value="/resources/app.js" />"></script>
<script src="<c:url value="/resources/server.js" />"></script>
<script type="text/javascript">
	var score = 0;
	
	$('.detail-main').not(':first').hide();
	$('.resultpage').hide();
	$('.questbtn-area').on('click', '.questbtn', function(e) {
		var $btnArea = $(e.delegateTarget);
		var $btnGroup = $btnArea.find('.questbtn');
		var $btn = $(e.currentTarget);
		var $main = $btn.closest('.detail-main');
		var $unit = $main.find('.unit');
		var $text = $btn.find('.questbtn_tit');
		var sText = $text.text();
		var answer = $main.data('answer');
		
		$btnArea.addClass('on');
		$btnGroup.prop('disabled',true);
		
		if( answer === sText) {
			$btn.addClass('ok');
			$unit.addClass('ok')
			score++;
			
		}else {
			$btn.addClass('wrong');
			$unit.addClass('wrong')
		}
		
	});
	
	$(document).on('click', '.unit_nextbtn', function(e){
		var $pageNum = $('.progress_current');
		var $nextBtn = $(e.currentTarget);
		var $main = $nextBtn.closest('.detail-main');
		var $result = $('.resultpage');
		var $progress = $('.progress');
		var nTotal = parseInt($('.progress_total').text(), 10);
		var nCurrentPage = parseInt($pageNum.text(), 10);
		  

		if(nCurrentPage === nTotal) {
			$main.hide();
			$result.show();
			$progress.hide();
			
			var $result = $('.result');
			var $total = $result.find('.result_total');
			var $current = $result.find('.result_current');
			
			$total.text(nTotal + "점 만점에");
			$current.text(score + "점");
		}else {
			if(nCurrentPage - 1 === nTotal) {
				$nextBtn.text('결과보기');
			}
			$pageNum.text( Math.min( nCurrentPage + 1), nTotal);
			$main.next().show();
			$main.hide();
		}
		
		
	});
	
</script>
</html>