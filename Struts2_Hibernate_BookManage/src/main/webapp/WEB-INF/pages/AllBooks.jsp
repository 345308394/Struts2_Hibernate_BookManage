<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有图书</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".delete").click(function(){
		var  con =  confirm("你确定要删除此图书?");
		if(!con){
			return false;
		}
	});
});
</script>
</head>
<body>
<h1>图书系统</h1>
<table border="1" >
<tr>
<th>图书编号</th>
<th>图书名称</th>
<th>图书作者</th>
<th>图书价格</th>
</tr>
<s:iterator value="#session.booklist" status="indexValue" var="book">   
        <s:if test="#indexValue.odd == true">  
            <tr style="background-color:#FFFFCD">  
        </s:if>  
        <s:else>  
            <tr style="background-color:#F0FFFF">  
        </s:else>  
            <td>  
             
                <s:property value="#indexValue.index + 1"/>
            </td>  
            <td>    
                <s:property value="#book.bookname"/> 
            </td>
            <td>
                <s:property value="#book.bookauthor"/>
            </td>
            <td>
                <s:property value="#book.bookprice"/> 
            </td>  
            <td>
            <a class="delete" href="Book_DeleteBook?book.bookid=${book.bookid}">删除</a>
            </td> 
            <td>
            <a  href="Book_BookDetail?book.bookid=${book.bookid}">修改</a>
            </td>
    </s:iterator>  
</table>
<h1><a href="Book_BookAddUi">添加图书</a></h1>
</body>
</html>