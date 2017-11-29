<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>


<h1>Messages:</h1>
<ul>
<c:forEach var="message" items="${messages}">
   <li><a href="/Images/message?id=${message.id}"><c:out value="${message.text}"></c:out></a></li>
</c:forEach>
</ul>

The time is ${now}.

</body>
</html>