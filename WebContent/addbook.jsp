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
.table {
	color: #000;
	text-align: center;
}
.meigeneirong {
	background-color: #CCC;
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
        <div id="apDiv2"><a href="search.jsp">书名</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="addbook.jsp">添加图书&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
   </div>
 </div>
 
 
 

 
 <!-- 中间 -->
<div class="main" >
	  <div align="center"><!-- 输出输的题目 -->   
	        
	    <div align="left">
        			<br>
                    
   					<%Vector<AuthorInfirmation>authorvec=(Vector<AuthorInfirmation>)session.getAttribute("authorinf");
					if(authorvec==null || authorvec.size()<1)
					{%>
						<a href="add_author_book.jsp">此作者不存在，请先添加作者信息</a>
				  <%} else{%>
							<%for(int i=0;i<authorvec.size();i++)
							{%>
								<div class="meigeneirong"><br>
                                <table width="866" border="1" align="left" cellpadding="0" cellspacing="0" class="table">
                                  <tr>
                                    <td width="250">作者ID</td>
                                    <td width="250">作者姓名</td>
                                    <td width="250">年龄</td>
                                    <td width="250">国籍</td>
                                  </tr>
                                  <tr>
                                    <td width="250"><%=authorvec.get(i).getAuthorID() %></td>
                                    <td width="250"><%=authorvec.get(i).getName() %></td>
                                    <td width="250"><%=authorvec.get(i).getAge() %></td>
                                    <td width="250"><%=authorvec.get(i).getCountry() %></td>
                                  </tr>
                                </table>
                                <br>
                                <br><br>
								<form name="form2" method="post" action="addbook">
   	   								 <label for="textfield5">&nbsp;&nbsp;&nbsp;&nbsp;书&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
								      <input type="text" name="title" id="textfield5">
								      &nbsp;&nbsp;&nbsp;&nbsp;
<label for="textfield6"> ISBN:</label>
			                          &nbsp;&nbsp;&nbsp;
<input type="text" name="isbn" id="textfield6">
			                        
			                          &nbsp;&nbsp;&nbsp;&nbsp;
<label for="textfield5">作者ID：&nbsp;&nbsp;&nbsp;&nbsp;</label>
								      <input type="text" name="id" id="textfield5" value="<%=authorvec.get(i).getAuthorID() %>">
								      <br>
			                          <label for="textfield7">&nbsp;&nbsp;&nbsp;&nbsp;出版社&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			                          <input type="text" name="publisher" id="textfield7">
			                          
			                          
			                          <label for="textfield8">&nbsp;&nbsp;&nbsp;&nbsp;出版日期</label>
			                          <input type="text" name="publishdate" id="textfield8">
			                          
			                          <label for="textfield9">&nbsp;&nbsp;&nbsp;&nbsp;价&nbsp;&nbsp;&nbsp;格：</label>
			                          <input type="text" name="price" id="textfield9">
			                          <br>
							      	  <input type="submit" name="button2" id="button2" value="添加">
								  </form>
		 
						    	</div><br>			
							<%} %>	
					<%} %>
					 
	      			
			    <br><br>
	    </div>
	    
  	</div>
</div>
 
 
 
 
</body>
</html>