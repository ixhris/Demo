<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>按条件查询</title>
<style>
        div{
            margin: 100px auto;
            text-align: center;
            width: 240px;
	        height: 350px;
        }
    </style>
</head>
<body style="background: url(004.jpg) ; background-size:100% 100% ; background-attachment: fixed">
<div>
<p style="color: green;">${logInfo.loginId}</p>
   <h3>按条件查询</h3>
   <form action="/sByCon">
      
      <p style="color: red;">${message}</p>
      <table>
         <tr>
           <td>学号</td>
           <td><input type="text" name="id"/></td>
         </tr>
         <tr>
           <td>姓名</td>
           <td><input type="text" name="name"/></td>
         </tr>
         <tr>
           <td>年龄</td>
           <td><input type="text" name="age"/></td>
         </tr>
         <tr>  
           <td>性别</td>
           <td>
             <label><input name="sex" type="radio" value="m" />男 </label> 
             <label><input name="sex" type="radio" value="f" />女 </label> 
             <label><input name="sex" type="radio" value="0" checked="checked"/>不知</label> 
           </td>
         </tr> 
         <tr> 
           <td>班级</td>
           <td><input type="text" name="classId"/></td>
         </tr>
         <tr>
           <td>年级</td>
           <td><input type="text" name="grade"/></td>
         </tr>
       </table>
       <input type="submit" value="确定"/>
    </form>
    <form action="/backto">
    
      <input type="submit" value="返回">
   </form>
   <table border="1" >
         <tr>
          <td>学号</td>
          <td>姓名</td>
          <td>年龄</td>
          <td>性别</td>
          <td>班级</td>
          <td>年级</td>
        </tr>
        <c:forEach var="listValue" items="${listValue}">
        <tr>
           <td>${listValue.id}</td>
           <td>${listValue.name}</td>
           <td>${listValue.age}</td>
           <td>${listValue.sex}</td>
           <td>${listValue.classId}</td>
           <td>${listValue.grade}</td>
           <td>  
             <form action="/searchById">
                
                <input type="hidden" name="id" value="${listValue.id}">
                <input type="submit" value="编辑">
             </form>
           </td>
        </tr>   
        </c:forEach>
   </table>
</div>
</body>
</html>