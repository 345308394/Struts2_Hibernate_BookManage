<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Book_AddBook">
<s:textfield name="book.bookname" label="图书名字"></s:textfield><br>
<s:textfield name="book.bookauthor" label="图书作者"></s:textfield><br>
<s:textfield name="book.bookprice" label="图书价格"></s:textfield>

<br>
<input type="submit" value="提交">
</form>
</body>
</html>