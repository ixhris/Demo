<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>按学号删除</title>
<style>
   div{
            margin: 200px auto;
            text-align: center;
            width: 300px;
	        height: 350px;
	    }
</style>
</head>
<body style="background: url(004.jpg) ; background-size:100% 100% ; background-attachment: fixed">
<div>
   <p style="color: green;">${logInfo.loginId}</p>
   <h3>按学号删除</h3>
   
   <form action="/delById">
      
      请输入学号:<input type="text" name="id">
      <input type="submit" value="确定">
   </form>
   
   <form action="/backto">
      
      <input type="submit" value="返回">
   </form>
   
   <p style="color: red;">${message}</p>
</div>

</body>
</html>