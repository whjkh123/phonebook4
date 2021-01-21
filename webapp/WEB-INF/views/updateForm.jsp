<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 리스트</h1>

	<p>
		수정화면입니다. <br> 아래 항목을 수정하고 "수정" 버튼을 클릭하세요.
	</p>

	<form action="${pageContext.request.contextPath }/phone/update" method="get">
		이름(name): <input type="text" name="name" value="${PersonVo.name }"><%-- ${requestScope.PersonVo.name } --%>
		<br>
		핸드폰(hp): <input type="text" name="hp" value="${PersonVo.hp }"><%-- ${requestScope.PersonVo.hp } --%>
		<br>
		회사(company): <input type="text" name="company" value="${PersonVo.company }"><%-- ${requestScope.PersonVo.company } --%>
		<br>
		<input type="hidden" name="person_id" value="${PersonVo.person_id}"><%-- ${requestScope.PersonVo.person_id } --%>
		<button type="submit">수정</button>
	</form>

</body>
</html>