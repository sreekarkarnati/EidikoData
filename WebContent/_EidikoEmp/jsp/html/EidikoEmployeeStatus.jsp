<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt_rt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>
<%@page import="java.util.Map"%>
<portlet:defineObjects />
<portlet:resourceURL id="resource_URL" var="resource_URL"> </portlet:resourceURL>

<form action="<portlet:actionURL/>" method="post">
<table>
<tr>
<td><label>Id&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="id" id ="id"> <br></td></tr>

<tr><td><label>Employee Id&emsp;&nbsp;</label><input type="text" name="employeeId" id="employeeId"> </td></tr></br>

<tr><td><label>Category Id &emsp;&nbsp;</label><input type="text" name="categoryId" id="categoryId"> <br></td></tr>

<tr><td><label>SubCategory Id</label><input type="text" name="subCategoryId" id="subCategoryId"> <br></td></tr>

<tr><td><label>Skill Id&emsp;&emsp;&emsp;&emsp;</label><input type="text" name="skillId" id="skillId"> <br></td></tr>

<tr><td><label>Start Date&emsp;&emsp;&nbsp;</label> <input type="text" name="startDate" id="startDate"> <br></td></tr>

<tr><td><label>End Date&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="endDate" id="endDate"> <br></td></tr>

<tr><td><label>Remarks&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label> <input type="text" name="remarks" id="remarks"> <br></td></tr>
 <input type="submit" > <br>
</table>
</form>
