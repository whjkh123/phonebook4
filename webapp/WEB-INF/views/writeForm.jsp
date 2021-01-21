<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 등록</h1>

	<p>
		전화번호를 등록하려면 <br> 아래 항목을 기입하고 "등록" 버튼을 클릭하세요.
	</p>

	<form action="${pageContext.request.contextPath }/phone/write" method="get">
		이름(name): <input type="text" name="name" value=""> <br>
		핸드폰(hp): <input type="text" name="hp" value=""> <br>
		회사(company): <input type="text" name="company" value=""> <br>
		<button type="submit">등록</button>
	</form>

	<br>

	<a href="${pageContext.request.contextPath }/phone/list">메인으로 돌아가기</a>

</body>
</html>