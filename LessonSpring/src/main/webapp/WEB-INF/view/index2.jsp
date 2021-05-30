<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>

test
<form action="/test">
  <input type="text" name="count" value="${count}">
  <input type="submit" value="click">
</form>




${username}<br>

<c:forEach var="listValue" items="${listValue}">
   学号<li>${listValue.id}</li>
   姓名<li>${listValue.name}</li>
   年龄<li>${listValue.age}</li>
</c:forEach>

</body>
</html>