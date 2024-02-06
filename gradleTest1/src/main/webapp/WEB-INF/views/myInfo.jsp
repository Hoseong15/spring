<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	 <%-- 이름 : ${id1} <br> 나이 : ${age }<br> 직업 : ${job } --%>
	 
	<h3>내정보</h3>
	<p>이름 : ${myInfoDTO.id1 }</p>
	<p>연령대 : ${age }</p>
	<p>직업 : ${myInfoDTO.job }</p>

</body>
</html>