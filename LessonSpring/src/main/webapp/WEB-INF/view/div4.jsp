<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新学生信息</title>
<style>
   div{
            margin: 200px auto;
            text-align: center;
            width: 260px;
	        height: 350px;
	    }
</style>

<script>

    function s(rName,rValue){
        /*通过传递的元素名获取元素对象*/
        var rObj = document.getElementsByName(rName);
        /*获取到的对象是数组对象，逐一进行遍历，寻找值等于所获取数据值的子对象*/
        for(var i = 0;i < rObj.length;i++){
             if(rObj[i].value == rValue){
                 /*寻找到子对象后，对他进行如下操作就可以实现后台数据显示到单选钮中*/
                 rObj[i].checked =  'checked';
             }
        }
    }
</script>

</head>
<body style="background: url(004.jpg) ; background-size:100% 100% ; background-attachment: fixed" onload="s('sex','${value.sex}')">
<div>
   <p style="color: green;">${logInfo.loginId}</p>
   <h3>更新学生信息</h3>
   <form action="/searchById">
      
      请输入学号:<input type="text" name="id">
      <input type="submit" value="确定" >
   </form>
   <form action="/backto">
      
      <input type="submit" value="返回">
   </form>
   <p style="color: red;">${message}</p>
 <form action="/upStu"> 
 
   <table>
      <tr>
        <td>学号</td>
        <td><input type="text" name="id" value="${value.id}" readonly="readonly"></td>
      </tr> 
      <tr> 
        <td>姓名</td>
        <td><input type="text" name="name" value="${value.name}"></td>
      </tr> 
      <tr>
        <td>年龄</td>
        <td><input type="text" name="age" value="${value.age}"></td>
      </tr> 
      <tr>
        <td>性别</td>
        <td>
        <label><input name="sex" value="m" type="radio" />男 </label> 
        <label><input name="sex" value="f" type="radio" />女 </label> 
        </td>
      </tr> 
      <tr>
        <td>班级</td>
        <td><input type="text" name="classId" value="${value.classId}"></td>
      </tr> 
      <tr>
        <td>年级</td>
        <td><input type="text" name="grade" value="${value.grade}"></td>
      </tr>
    </table>
    <input type="submit" value="修改">
  </form> 
</div>
</body>
</html>