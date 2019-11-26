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
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-153425898-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-153425898-1');
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type='text/javascript'>	  
    // // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('2154a19a8b424f820604283812388ab4');
    // // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
    function sendLink() {

      var titleObj = document.getElementById('title');
      var title = titleObj.dataset.title;
      var titleImgUrl = 'http://2weeks.io' + titleObj.dataset.path;
      var url = window.location.href;
      
      Kakao.Link.sendDefault({
        objectType: 'feed',
        content: {
          title: title,
          description: '#2weeks.io #연예인얼굴맞추기 #누구야 #유튜브게임 #연예인 #얼굴맞추기',
          imageUrl: titleImgUrl,
          link: {
            mobileWebUrl: url,
            webUrl: url
          }
        },
        social: {
          likeCount: 1043,
          commentCount: 32,
          sharedCount: 84
        },
        buttons: [{
          title: '웹으로 보기',
          link: {
            mobileWebUrl: url,
            webUrl: url
          }
        }, {
          title: '앱으로 보기',
          link: {
            mobileWebUrl: url,
            webUrl: url
          }
        }]
      });
    }
</script>

</head>

<body>

	<header class="header">
		<a href="/nuguya">
			<h1 class="header_logoname">NUGUYA</h1>
		</a>
	</header>

	<section class="detail" data-id="${faceWritingDto.writing_no}">

		<p class="progress">
			<span class="progress_current">1</span> <span class="progress_tx">/</span>
			<span class="progress_total">${faceWritingDto.slideSize}</span>
		</p>

		<c:forEach items="${slideFaceWritingList}" var="slideFaceWritingDto">
			<main class="detail-main" data-answer="${slideFaceWritingDto.answer}">
				<!-- [D] 틀렸을때 wrong, 맞췄을때 ok -->
				<section class="unit">
					<img src="http://2weeks.io${slideFaceWritingDto.compo_img_path}" alt="카드 이미지" class="unit_img">
					<img src="http://2weeks.io${slideFaceWritingDto.ori_img_path}" alt="카드 이미지" class="unit_img" style="display:none">
					<button type="button" class="unit_nextbtn">다음문제</button>
				</section>

				<!-- [D] on : 문제 풀고 나서 추가 -->
				<ul class="questbtn-area">
					<c:forEach items="${slideFaceWritingDto.rand_answer}" var="randAnswer">
						<c:choose>
							<c:when test="${randAnswer == slideFaceWritingDto.answer}">
								<li>
									<button type="button" class="questbtn">
										<span class="questbtn_tit">${randAnswer}</span> <span class="questbtn_o"></span>
									</button>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<!-- [D] 문제 틀렸을때 wrong , 맞췄을때 ok 추가 -->
									<button type="button" class="questbtn">
										<span class="questbtn_tit">${randAnswer}</span> <span class="questbtn_x"></span>
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
		<header class="title" id="title" data-title="${faceWritingDto.title}" data-path="${faceWritingDto.title_img_path}">${faceWritingDto.title}</header>
		<main class="result">
			<h1 class="result_total">${faceWritingDto.slideSize}점 만점에</h1>
			<h1 class="result_current">점</h1>
			<p class="result_average">유저 평균 점수 ${faceWritingDto.average}점</p>
		</main>

		<div class="resultpage_right">
			<ul class="links">
				<li>
	              <button class="links_link" onclick="javascript:sendLink()">
	                <img src="/nuguya/resources/kakao@2x.png?45d79b3e6d1a4c4ecdfe7ae38810d55a" alt="">
	              </button>
				</li>
			</ul>
		</div>
		<div class="section result-options">
			<button type="button" class="questbtn" onclick="location.href='/nuguya'">
				<span class="questbtn_tit">메인으로 이동</span>
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

	$('.questbtn-area').on('click', '.questbtn', function (e) {
		var $btnArea = $(e.delegateTarget);
		var $btnGroup = $btnArea.find('.questbtn');
		var $btn = $(e.currentTarget);
		var $main = $btn.closest('.detail-main');
		var $unit = $main.find('.unit');
		var $unitImgs = $unit.find('.unit_img');
		var $text = $btn.find('.questbtn_tit');
		var sText = $text.text();
		var answer = $main.data('answer');

		$btnArea.addClass('on');
		$btnGroup.prop('disabled', true);
		$unitImgs.hide().last().show();

		if (answer == sText) {
			$btn.addClass('ok');
			$unit.addClass('ok')
			score++;
		} else {
			$btn.addClass('wrong');
			$unit.addClass('wrong')
		}

	});

	$(document).on('click', '.unit_nextbtn', function (e) {
		var $pageNum = $('.progress_current');
		var $nextBtn = $(e.currentTarget);
		var $main = $nextBtn.closest('.detail-main');
		var $detail = $('.detail');
		var $result = $('.resultpage');
		var $progress = $('.progress');
		var nTotal = parseInt($('.progress_total').text(), 10);
		var nCurrentPage = parseInt($pageNum.text(), 10);

		if (nCurrentPage === nTotal) {
			$main.hide();
			$result.show();
			$progress.hide();

			var $result = $('.result');
			var $total = $result.find('.result_total');
			var $current = $result.find('.result_current');

			$total.text(nTotal + "점 만점에");
			$current.text(score + "점");

			$.post('/nuguya/updateWritingInfo', { writing_no: $detail.data('id'), parti_score: score }, function (data) {
				data && console.log('스코어 등록 성공');
			});

		} else {
			if (nCurrentPage - 1 === nTotal) {
				$nextBtn.text('결과보기');
			}
			$pageNum.text(Math.min(nCurrentPage + 1), nTotal);
			$main.next().show();
			$main.hide();
		}

	});

</script>

</html>