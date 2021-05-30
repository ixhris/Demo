<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>按学号查询</title>
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
   <h3>按学号查询</h3>
   <form action="/sByid">
      
      请输入学号:<input type="text" name="id">
      <input type="submit" value="确定">
   </form>
   <form action="/backto">
      
      <input type="submit" value="返回">
   </form>
   <form action="/toSByCon">
      
      <input type="submit" value="按条件查询">
   </form>
   <p style="color: red;">${message}</p>
   <table>
      <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>班级</td>
        <td>年级</td>
        <td>学期</td>
        <td>数学</td>
        <td>英语</td>
        <td>物理</td>
      </tr>
      <tr>
        <td>${value.id}</td>
        <td>${value.name}</td>
        <td>${value.age}</td>
        <td>${value.sex}</td>
        <td>${value.classId}</td>
        <td>${value.grade}</td>
        <td>${value.score.period}</td>
        <td>${value.score.math}</td>
        <td>${value.score.eng}</td>
        <td>${value.score.phy}</td>
      </tr>
    </table>
   
   
</div>

</body>
</html>