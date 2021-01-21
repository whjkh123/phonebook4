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

	<p>입력한 전화번호 내역입니다.</p>

	<c:forEach items="${requestScope.PersonList }" var="pVo">
		<table border="1">

			<tr>
				<td>이름(name)</td>
				<td>${pVo.name }</td>
			</tr>

			<tr>
				<td>핸드폰(hp)</td>
				<td>${pVo.hp }</td>
			</tr>

			<tr>
				<td>회사(company)</td>
				<td>${pVo.company }</td>
			</tr>

			<tr>
				<td><a href="${pageContext.request.contextPath }/phone/uForm?id=${pVo.person_id }">[수정]</a></td>
				<td><a href="${pageContext.request.contextPath }/phone/delete/${pVo.person_id }">[삭제]</a></td>
				<%-- <td><a href="/phonebook3/phone/delete?id=${pVo.person_id }">[삭제]</a></td> --%>
			</tr>

		</table>

		<br>

	</c:forEach>

	<br>

	<a href="${pageContext.request.contextPath }/phone/writeForm">전화번호 추가등록</a>

</body>
</html>