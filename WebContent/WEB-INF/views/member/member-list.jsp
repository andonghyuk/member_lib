<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>패스워드</th>
		<th>가입일</th>
	</tr>
<c:forEach items="${memberList}" var="m">
	<tr>
		<td>${m.m_name}</td>
		<td><a href="/member/view?m_num=${m.m_num}">${m.m_id}</a></td>
		<td>${m.m_pwd}</td>
		<td>${m.m_credat}</td>
	</tr>
</c:forEach>
</table>
<a href="/views/member/member-insert"><button>회원추가</button></a>
</body>
</html>
