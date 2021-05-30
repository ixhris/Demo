<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新学生成绩</title>
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
<body style="background: url(004.jpg) ; background-size:100% 100% ; background-attachment: fixed" onload="s('period','${value2.period}')">
<div>
   <p style="color: green;">${logInfo.loginId}</p>
   <h3>更新学生成绩</h3>
   <form action="/sScoById">
      
      请输入学号:<input type="text" name="id">
      <input type="submit" value="确定" >
   </form>
   <form action="/backto">
      
      <input type="submit" value="返回">
   </form>
   <p style="color: red;">${message}</p>
 <form action="/upSco"> 
  
   <table>
      <tr>
        <td>学号</td>
        <td><input type="text" name="id" value="${value1.id}" readonly="readonly"></td>
      </tr> 
      <tr> 
        <td>学期</td>
        <td>
        <label><input name="period" value="202104" type="radio" />202104 </label> 
        <label><input name="period" value="202110" type="radio" />202110 </label> 
        </td>
      </tr> 
      <tr>
        <td>数学</td>
        <td><input type="text" name="math" value="${value2.math}"></td>
      </tr> 
      <tr>
        <td>英语</td>
        <td><input type="text" name="eng" value="${value2.eng}"></td>
      </tr> 
      <tr>
        <td>物理</td>
        <td><input type="text" name="phy" value="${value2.phy}"></td>
      </tr>
    </table>
    <input type="submit" value="修改">
  </form> 
</div>
</body>
</html>