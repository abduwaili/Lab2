<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.book.action.Show_information"%>
<%@page import="author_book_Information.BookInfirmation"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Vector"%>
<%@page import="author_book_Information.AuthorInfirmation"%>
<%@page import="java.util.List"%>

<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title><%=(String)request.getParameter("Title") %></title>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.topdiv {
	background-color: #FFF;
	background-image: url(images/searchinformationtop.png);
	padding-left: 540px;
}
.bottomdiv {
	background-color: #E7E7E7;
	background-image: url(images/1.jpg);
	height: 50px;
	margin-right: 0px;
	margin-left: 0px;
}
.left {
	margin-right: 1090px;
	margin-top: 0px;
	width: 225px;
	position: absolute;
	height: 443px;
	margin-bottom: 0px;
	padding: 0px;
	margin-left: 0px;
	left: 0px;
}
.book_author_div {
	background-color: #EBEBEB;
	margin-top: 20px;
	color: #000;
	font-size: 18px;
	padding: 10px;
	height: 183px;
}
.centerdiv {
	margin-top: 20px;
	margin-right: 230px;
	margin-bottom: 21px;
	margin-left: 230px;
}
.right {
	width: 225px;
	margin-left: 1030px;
	height: 443px;
	position: absolute;
	right: 0px;
	top: 100px;
}
.delete_change {
	color: #F00;
	background-color: #FFF;
}
.delete_change_ad {
	color: #F00;
	background-color: #0CF;
	font-weight: bold;
	width: 100px;
}
.zuiwaiceng {
	height: auto;
	width: auto;
}
.change {
	color: #F00;
	font-weight: bold;
}
#apDiv1 {
	position: absolute;
	width: 141px;
	height: 26px;
	z-index: 1;
	left: 717px;
	top: 310px;
	background-color: #00CCFF;
}
</style>
</head>
<body>


<div class="zuiwaiceng" >
        	
	  <div class="topdiv"><img src="images/searchlogon.png" width="180" height="100"></div>
	  
	  
	  <div class="left"> </div>
	  <div class="right" ></div>
	  
	  
	  <div class="centerdiv">    
    
	    		<!-- 书的详细信息 -->    
	  	  <div class="book_author_div">
	  			  <div align="center"><strong>书的详细信息</strong></div> <hr>
	  			  <%  
	                  String bookinsb=(String)request.getParameter("isbn");
	                  Show_information show_inf=new Show_information();
	                  show_inf.setISBN(bookinsb);
	                  show_inf.execute();
	               %> 
	 
	              <%="ISBN号				"+show_inf.getISBN() %><br>
	              <%="书Title			"+show_inf.getTitle() %><br>
	              <%="作者ID				"+show_inf.getAuthorID() %><br>
	              <%="出版社				"+show_inf.getPublisher() %><br>
	              <%="出版日期				"+show_inf.getPublishDate() %><br>
	              <%="价格                    		"+show_inf.getPrice() %>
	                  
	              <form action="deletebook" method="post" name="form1">
               		<div align="center">
	                   		<%session.setAttribute("Delete", show_inf.getISBN()); %>
	                      	<input name="button1" type="submit" class="delete_change_ad" id="button" value="删除书">
&nbsp;&nbsp;&nbsp;
                      <span class="change">
                        <%session.setAttribute("isbn", bookinsb); %>
                      <a href="change_book.jsp" style='text-decoration:none; color:#F00'> <div id="apDiv1">修改书的内容</div></a></span>
                          
	               		</div>
	              </form>  		
	               		
  	    </div>
	         
	         
	      
	        <!-- 作者的信息 -->      
	        <div class="book_author_div">
	             <div align="center"><strong>作者的详细信息</strong></div>
	             <hr>
	               	  <%="作者ID				"+ show_inf.getAuthorID() %><br>
	                  <%="姓名				"+show_inf.getName() %><br>
	                  <%="年龄				"+show_inf.getAge() %><br>
	                  <%="国籍				"+show_inf.getCountry() %>
	        </div>
     </div>        
   		 <div class="bottomdiv"></div>
         
</div>



</body>
</html>