<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生成绩</title>
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
  <h3>添加学生成绩</h3>
  <form action="/insSco"> 
   
   <table>
      <tr>
        <td>学号</td>
        <td><input type="text" name="id" ></td>
      </tr> 
      <tr> 
        <td>学期</td>
        <td>
          <select  name="period" > 
            <option value="202104">202104</option> 
            <option value="202110">202110</option> 
          </select> 
        </td>
      </tr> 
      <tr>
        <td>数学</td>
        <td><input type="text" name="math" ></td>
      </tr> 
      <tr>
        <td>英语</td>
        <td><input type="text" name="eng" ></td>
      </tr> 
      <tr>
        <td>物理</td>
        <td><input type="text" name="phy" ></td>
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