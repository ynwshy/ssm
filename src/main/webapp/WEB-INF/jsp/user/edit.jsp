<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>edit</title>
	<script src="js/jquery.min.js"></script>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<a href="${pageContext.request.contextPath}">hello</a>
	<h1>edit</h1>
	<div>${pagename}</div>
	<form action="${pageContext.request.contextPath}/user/save"
		method="post" enctype="multipart/form-data">
		<p>
			用户编号:<span>${user.id}</span>
		</p>
		用户名：<input type="text" name="name" value="${user.name}"> 年龄：<input
			type="text" name="age" value="${user.age}"> 图片:
		<tr>
			<td>文件一</td>
			<td><input type="file" name="file" /></td>
		</tr>
		<tr>
			<td>文件二</td>
			<td><input type="file" name="file" /></td>
		</tr>
		<tr>
			<input type="submit" value="上传文件" />
		</tr>
		<button type="submit">提交</button>
	</form>


	<script>
		$.ajax({
			url : "/ajax",
			type : 'POST', //GET
			async : true, //或false,是否异步
			timeout : 5000, //超时时间
			data : {},
			dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
			// contentType: "application/json; charset=utf-8",
			success : function(data) {
				console.log(data);
			}
		});
	</script>
</body>
</html>