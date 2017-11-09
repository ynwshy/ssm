<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
<a href="${pageContext.request.contextPath}">hello</a>
	<h1>List</h1>

	<div>${listname}</div>
	<table>
		<tbody>
			<c:forEach var="user" items="${userList }">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.age }</td>
					<td><a href="${pageContext.request.contextPath}">修改</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>