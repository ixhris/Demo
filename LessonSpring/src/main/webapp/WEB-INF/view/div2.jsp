<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生信息</title>
<style>
        div{
            margin: 200px auto;
            text-align: center;
            width: 200px;
	        height: 600px;
        }
    </style>
</head>
<body style="background: url(004.jpg) ; background-size:100% 100% ; background-attachment: fixed">
<div>
<p style="color: green;">${logInfo.loginId}</p>
   <h3>添加学生信息</h3>
  <form action="/insStu"> 
   
   <table>
      <tr>
        <td>学号</td>
        <td><input type="text" name="id" ></td>
      </tr> 
      <tr> 
        <td>姓名</td>
        <td><input type="text" name="name" ></td>
      </tr> 
      <tr>
        <td>年龄</td>
        <td><input type="text" name="age" ></td>
      </tr> 
      <tr>
        <td>性别</td>
        <td>
        <label><input name="sex" value="m" type="radio" checked="checked"/>男 </label> 
        <label><input name="sex" value="f" type="radio" />女 </label> 
        </td>
      </tr> 
      <tr>
        <td>班级</td>
        <td><input type="text" name="classId" ></td>
      </tr> 
      <tr>
        <td>年级</td>
        <td><input type="text" name="grade" ></td>
      </tr>
    </table>
    <input type="submit" value="提交">
  </form> 
  
  <p style="color: red;">${message}</p>
  
  <form action="/backto">
      
      <input type="submit" value="返回">
   </form>
</div>
</body>
</html>