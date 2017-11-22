<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
{ "images": [
<c:forEach var="image" items="${images}" varStatus="row">
{ 
 "id":   "${image.id}",
  "name": "${image.name}"
 }
 <c:if test="${! row.isLast()}">,</c:if>
</c:forEach>
] }
