<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Book_UpdateBook">
<div>
<span>数据库中编号</span>
<input  type="text" name="book.bookid"  value="${sessionScope.book.bookid}"/>
</div>
<br>
<div>
<span>图书名称</span>
<input  type="text" name="book.bookname"  value="${sessionScope.book.bookname}"/>
</div>
<br>
<div>
<span>图书作者</span>
<input  type="text" name="book.bookauthor"  value="${sessionScope.book.bookauthor}"/>
</div>
<br>
<div>
<span>图书价格</span>
<input  type="text" name="book.bookprice"  value="${sessionScope.book.bookprice}"/>
</div><br>
<input type="submit" value="提交"/>
</form>
</body>
</html>