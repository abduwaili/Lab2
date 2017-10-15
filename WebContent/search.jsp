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
	width: 790px;
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
			<form name="form1" method="post" action="search">            
       	    	<label for="textfield"></label>          	    
           		<input name="AuthorName" type="text" class="sousuokuang"  id="textfield" >
           	    <input name="button" type="submit" class="sousuobutton" id="button" value="Book搜索">
   			 </form>
        </div>
  	</div>   
   	<div class="daohanglan">
        <div id="apDiv2"><a href="search.jsp">书名&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="addbook.jsp">添加图书&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
   </div>
 </div>
 
 
 
 <!-- 中间 -->
<div class="main" >
	  <div align="center"><!-- 输出输的题目 -->         
	    <div align="left">
	      <%      
	  		Map<BookInfirmation, AuthorInfirmation>book_author=(Map<BookInfirmation, AuthorInfirmation>)session.getAttribute("book_author");
	        if(book_author==null||book_author.size()<1)
            {
	        	out.println("无数据");  	
		    }
	        else{
		       	int i=0;
		      	 	 //依次遍历每本书
		         for (Map.Entry<BookInfirmation, AuthorInfirmation> entry : book_author.entrySet())
		         {  
		          	//报每本书的书的信息和作者信息加到session中
		           	String ISBN=entry.getKey().getISBN();//书的insb号
		            String url="show_information.jsp?isbn="+ISBN;
		    %>   
		    <br>    
	      <a href=<%=url %>><%=entry.getKey().getTitle() %> </a>
	       <br>		   
	      <% 		
		           }
		      }
		    %>
        </div>
	    
  	</div>
</div>
 
</body>
</html>