<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Book首页</title>


<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 1260px;
	height: 625px;
	z-index: 1;
	left: 0;
	top: 0;
}
#apDiv2 {
	position: absolute;
	width: 660px;
	height: 68px;
	z-index: 2;
	left: 300px;
	top: 210px;
}
#apDiv3 {
	position: absolute;
	width: 230px;
	height: 100px;
	z-index: 3;
	left: 515px;
	top: 80px;
}
.bookb {	font-size: 100px;
	color: #009;
}
.bookk {	font-size: 100px;
	color: #0F3;
}
.booko {	font-size: 100px;
	color: #E60000;
}
.booko1 {	font-size: 100px;
	color: #592D00;
}
.sousuokuang {
	color: #000;
	border-top-color: #03F;
	border-right-color: #03F;
	border-bottom-color: #03F;
	border-left-color: #03F;
	height: 40px;
	width: 550px;
}
.sousuobutton {
	color: #FFF;
	height: 40px;
	width: 100px;
	margin-left: -6px;
	margin-top: -2px;
	font-weight: bold;
	background-color: #6CB6FF;
	font-size: 14px;
	border-top-color: #6CB6FF;
	border-right-color: #6CB6FF;
	border-bottom-color: #6CB6FF;
	border-left-color: #6CB6FF;
}

</style>
</head>


<body>



	<div id="apDiv1">
	   	  <div id="apDiv3">
	      	  <div align="center"><span class="bookb">B</span><span class="booko">o</span><span class="booko1">o</span><span class="bookk">k</span></div>
	      	</div>
	   	  	<div id="apDiv2">
				<form name="form1" method="post" action="search">
	           		<label for="textfield"></label>
	           		<input type="text" name="AuthorName"  class="sousuokuang" id="textfield">         		 
					<input type="submit" name="button"  class="sousuobutton" id="button" value="搜索">
		      </form>
	  	  </div>
	</div>	


    
</body>
</html>