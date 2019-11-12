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
<link href="/nuguya/resources/css/app.css" rel="stylesheet"></head>

<body>

    <header class="header">
    <h1 class="header_logoname">NUGUYA</h1>
</header>

    <main class="home-main">
        <ul class="unit-wrap">
            <li class="unit-wrap_item">
                <a href="./detail.html">
                    <section class="unit">
                        <img src="https://placehold.it/170x170" alt="카드 이미지" class="unit_img">
                        <span class="unit_tit">여자 배우 얼굴 맞추기 블라블라블라블라</span>
                    </section>
                </a>
            </li>
            <li class="unit-wrap_item">
                <a href="./detail.html">
                    <section class="unit">
                        <img src="https://placehold.it/170x170" alt="카드 이미지" class="unit_img">
                        <span class="unit_tit">여자 배우 얼굴 맞추기 블라블라블라블라</span>
                    </section>
                </a>
            </li>
        </ul>
    </main>
    

    <script src="<c:url value="/resources/js/app.js" />"></script>

</html>