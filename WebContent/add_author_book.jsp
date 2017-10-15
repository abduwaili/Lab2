<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.HashMap"%>
<%@page import="author_book_Information.BookInfirmation"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Vector"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="org.apache.struts2.dispatcher.ServletActionRedirectResult"%>
<%@page import="author_book_Information.AuthorInfirmation"%>
<%@page import="java.util.List"%>

<html>

<head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Book搜索</title>


<style type="text/css">


#apDiv1 {
	position: absolute;
	width: 660px;
	height: 40px;
	z-index: 2;
	left: 135px;
	top: 10px;
}
#apDiv2 {
	position: absolute;
	width: 406px;
	height: 29px;
	z-index: 2;
	left: 143px;
	top: 77px;
}
.sousuokuang {
	height: 40px;
	width: 540px;
}
.sousuobutton {
	height: 40px;
	margin-left: -8px;
	color: #FFF;
	border-top-color: #09F;
	border-right-color: #09F;
	border-bottom-color: #09F;
	border-left-color: #09F;
	background-color: #39F;
}
.daohanglan {
	background-color: #EAEAEA;
	height: 40px;
	color: #000;
	font-weight: normal;
}

.main {
	background-color: #FFF;
	width: 1000px;
	padding-left: 135px;
}

#apDiv3 {
	position: absolute;
	width: 86px;
	height: 32px;
	z-index: 3;
	left: 241px;
	top: 75px;
}
</style>
</head>
 <body>



 <!-- 头部 -->
 <div >
 	<div ><img src="images/search_logon.png" width="135" height="50">
        <div id="apDiv1">
			<form name="form1" method="post" action="addbook_search">            
       	    	<label for="textfield"></label>          	    
           		<input name="authorname" type="text" class="sousuokuang"  id="textfield" >
           	    <input name="button" type="submit" class="sousuobutton" id="button" value="Book搜索">
   			 </form>
        </div>
  	</div>   
   	<div class="daohanglan">
        <div id="apDiv2"><a href="search.jsp">书名</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="addbook.jsp">添加图书&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
   </div>
 </div>
 
 
 
 
 
 <!-- 中间 -->
<div class="main" >
	  <div align="center"><!-- 输出输的题目 -->   
	        
	    <div align="left">
					<br>
                    	 
					<form name="form2" method="post" action="add_author_book">
                          <label for="textfield2">作者姓名：</label>
                          <input type="text" name="authorname" id="textfield2">
                          <br>
                          <label for="textfield3">年&nbsp;&nbsp;龄：</label>
                          <input type="text" name="age" id="textfield3">
                          <br>
                          <label for="textfield4">国&nbsp;&nbsp;籍</label>
                          <input type="text" name="country" id="textfield4">
                          <br> <br><br>
				      	  <label for="textfield5">书名：</label>
					      <input type="text" name="title" id="textfield5">
                          <br>
                          <label for="textfield6">ISBN:</label>
                          <input type="text" name="isbn" id="textfield6">
                          <br>
                          <label for="textfield7">出版社：</label>
                          <input type="text" name="publisher" id="textfield7">
                          
                          <br>
                          <label for="textfield8">出版日期</label>
                          <input type="text" name="publishdate" id="textfield8">
                          <br>
                          <label for="textfield9">价格：</label>
                          <input type="text" name="price" id="textfield9">
                          <br>
				      	  <input type="submit" name="button2" id="button2" value="添加">
					</form> 
			    <br>
	    </div>
	    
  	</div>
</div>
 
 
 
 
</body>
</html>