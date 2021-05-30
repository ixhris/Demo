<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入spring标签库-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>

<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="125" />
<title>登录成功界面</title>
<style type="text/css">
        div{
            margin: 0 auto;
            text-align: center;
            width: 300px;
	        height: 190px;
	    }
	    #div1{
              width:200px;
              height:200px;
              position:absolute;
              top:100px;
              left:200px;
              box-shadow: red 10px 10px 20px;
              border-radius:50%;
        }   
        #div2{
              width:200px;
              height:200px;
              position:absolute;
              top:100px;
              left:600px;
              box-shadow: blue 10px 10px 20px;
              border-radius:50%;
        }
        #div3{
              width:200px;
              height:200px;
              position:absolute;
              top:100px;
              left:1000px;
              box-shadow: green 10px 10px 20px;
              border-radius:50%;
        }
        #div4{
              width:200px;
              height:200px;
              position:absolute;
              top:400px;
              left:200px;
              box-shadow: orange 10px 10px 20px;
              border-radius:50%;
        }
        #div5{
              width:200px;
              height:200px;
              position:absolute;
              top:400px;
              left:600px;
              box-shadow: brown 10px 10px 20px;
              border-radius:50%;
        }
        #div6{
              width:200px;
              height:200px;
              position:absolute;
              top:400px;
              left:1000px;
              box-shadow: purple 10px 10px 20px;
              border-radius:50%;
         }  
    </style>
<script type="text/javascript">
       function reload(){
    	   var a='<%=session.getAttribute("logInfo")%>';
    	   if(a==""||a=="null"){
    		   alert("会话已超时,请重新登陆!");
    		   window.location.href="hello";
    	   }
       }
</script>

</head>
<body style="background: url(004.jpg) ; background-size:100% 100% ; background-attachment: fixed" onload="reload()">
<div>
   <p style="color: green;">${logInfo.loginId}</p>
   <form action="hello">
      <input type="submit" value="退出">
   </form>
</div>
<div id="div1">
      <form action="div1">
          
          <input type="submit" value="查询学生数据" style="width:200px;height:200px;border:0;border-radius:50%;background-image:url('31561294108_.pic_hd.jpg');background-size:100% 100% ;cursor:pointer;"/>
      </form>
</div>
<div id="div2">
      <form action="div2">
          
          <input type="submit" value="添加学生信息" style="width:200px;height:200px;border:0;border-radius:50%;background-image:url('41561294109_.pic_hd.jpg');background-size:100% 100% ;cursor:pointer;"/>
      </form> 
 </div>
 <div id="div3">
      <form action="div3">
          
          <input type="submit" value="添加学生成绩" style="width:200px;height:200px;border:0;border-radius:50%;background-image:url('51561294110_.pic_hd.jpg');background-size:100% 100% ;cursor:pointer;"/>
      </form> 
 </div>
 <div id="div4">
      <form action="div4">
          
          <input type="submit" value="更新学生信息" style="width:200px;height:200px;border:0;border-radius:50%;background-image:url('81561294113_.pic_hd.jpg');background-size:100% 100% ;cursor:pointer;"/>
      </form>
 </div>
 <div id="div5">
      <form action="div5">
          
          <input type="submit" value="更新学生成绩" style="width:200px;height:200px;border:0;border-radius:50%;background-image:url('71561294112_.pic_hd.jpg');background-size:100% 100% ;cursor:pointer;"/>
      </form>
 </div>
 <div id="div6">
      <form action="div6">
          
          <input type="submit" value="删除学生数据" style="width:200px;height:200px;border:0;border-radius:50%;background-image:url('61561294111_.pic_hd.jpg');background-size:100% 100% ;cursor:pointer;"/>
      </form>
 </div>

</body>
</html>