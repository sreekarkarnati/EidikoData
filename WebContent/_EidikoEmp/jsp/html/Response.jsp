<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List,com.ibm.eidikoemp.Employee"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

var x='<%= request.getAttribute("empList")%>';

</script>

<% List eList = (List)request.getAttribute("empList");
   request.setAttribute("eList", eList);
%>
<div>
<table width="500" border=1 id="content">
   
 				<thead>
				<tr>
				<th><b>Employee ID</b></th>
				<th><b>Employee Pass</b></th>
        		<th><b>SkillId</b></th>
				<th><b>StartDate</b></th>
				<th><b>EndDate</b></th>
				<th><b>Remarks</b></th>
			</tr>
		</thead>
     <c:forEach items="${eList}" var="employee" >
 			<tbody>
 
        <tr>
            <td><c:out value="${employee.employeeId}"/></td>
            <td><c:out value="${employee.categoryId}"/></td> 
            <td><c:out value="${employee.skillId}"></c:out></td> 
           	<td><c:out value="${employee.startDate}"></c:out></td>
           	<td><c:out value="${employee.endDate}"></c:out></td>
            <td><c:out value="${employee.remarks}"></c:out></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</div>
<form action='<portlet:renderURL></portlet:renderURL>' method="get">
<input type="submit" value="Back"></form>

</body>
