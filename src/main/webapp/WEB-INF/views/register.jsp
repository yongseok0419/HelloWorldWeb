<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value="${user}"/> <!-- myuser라는 키를 쓰면 user가 넘어옴 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>회원가입 결과</h1>
		<ul>
			<!-- UserVo의 멤버변수와 변수명이 동일해야한다. -->
			<li>회원아이디 : ${user.userid}</li>
			<li>회원비밀번호 : ${user.passwd}</li>
			<li>회원이름 : ${user.username}</li>
			<li>회원나이 : ${user.userage}</li>
			<li>회원성별 : ${user.gender}</li>
		</ul>
</body>
</html>