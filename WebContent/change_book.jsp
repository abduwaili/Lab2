<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.book.action.Show_information"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改图书内容</title>
<style type="text/css">
body {
	background-image: url();
	background-color: #999;
}
body,td,th {
	color: #0F0;
	font-size: 24px;
}
.big {
	margin-bottom: 0px;
	padding-bottom: 0px;
}


</style>
</head>
<body>
<div class="big" >
	<div class="\"><a href="index.jsp">首页</a></div>

	<p>
	  <%String isbn=(String)session.getAttribute("isbn"); 
		Show_information show_inf=new Show_information();
	    show_inf.setISBN(isbn);
	    show_inf.execute();
	%>
  </p>
  <div >
	  <form name="form1" method="post" action="changebook">
    <p align="center">修改书的内容</p>
    <p align="center">
      <label for="textfield2">ISBN&nbsp;</label>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" name="isbn" id="textfield2" value="<%=show_inf.getISBN()%>">
    </p>
    <p align="center">
      <label for="textfield">Title</label>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" name="title" id="textfield" value="<%=show_inf.getTitle()%>">
    </p>
    <p align="center">
      <label for="textfield3">AuthorID</label>
      &nbsp;&nbsp;
      <input type="text" name="id" id="textfield3" value="<%=show_inf.getAuthorID()%>">
    </p>
    <p align="center">
      <label for="textfield4">Publisher</label>
      &nbsp;&nbsp;&nbsp;
      <input type="text" name="publisher" id="textfield4" value="<%=show_inf.getPublisher()%>">
    </p>
    <p align="center">
      <label for="textfield5">PublishDate</label>
      <input type="text" name="publishdate" id="textfield5" value="<%=show_inf.getPublishDate()%>">
    </p>
    <p align="center">
      <label for="textfield6">Price</label>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" name="price" id="textfield6" value="<%=show_inf.getPrice()%>">
    </p>
    <p align="center">
      <input type="submit" name="button" id="button" value="确认修改">
    </p>
  </form>
</div>

</div>
</body>
</html>