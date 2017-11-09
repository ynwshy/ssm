<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多文件 上传 </title>

</head>
<body>

    <div style="margin: 0 auto;margin-top: 100px; ">
        <h1>单文件上传</h1>
        <form action="one" method="post" enctype="multipart/form-data">
                <p>
                <span>文件：</span>
                <input type="file" name="imageFile">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
    <br>
    <div style="margin: 0 auto;margin-top: 100px; ">
        <h1>多文件上传</h1>
        <form action="more" method="post" enctype="multipart/form-data">
            <p>
                <span>文件1：</span>
                <input type="file" name="imageFile1">
            </p>
            <p>
                <span>文件2：</span>
                <input type="file" name="imageFile2">
            </p>            
            <p>
                <input type="submit">
            </p>
        </form>
    
    </div>
    <h2>多文件上传的图片</h2>
    <c:forEach var="filesrc" items="${fileList }">
        <img src="${filesrc }" alt="">
    </c:forEach>
</body>
</html>