<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<style>
        div{
            margin: 150px auto;
            text-align: center;
            width: 300px;
	        height: 190px;
	        box-shadow: black 10px 10px 20px;
	    }
    </style>
</head>
<body style="background: url(002.jpg) ; background-size:100% 100% ; background-attachment: fixed">
<div>
   
   <form action="/enter">
     <legend>登录学生管理系统</legend>
     <p><label for="name">账号:</label><input type="text" name="username"></p>
     <p><label for="pwd">密码:</label><input type="password" name="password"></p>
     
     <input type="submit" value="登录">
   </form>
   
   <p style="color: red;"> ${message}</p>
    
   <form action="/toregister">
         <input type="submit" value="注册"/>
   </form> 
</div>
</body>
</html>