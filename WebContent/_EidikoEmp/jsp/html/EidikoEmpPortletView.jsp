<%@page session="false" contentType="text/html" pageEncoding="ISO-8859-1" import="java.util.*,javax.portlet.*,com.ibm.eidikoemp.*" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>        
<%@taglib uri="http://www.ibm.com/xmlns/prod/websphere/portal/v6.1/portlet-client-model" prefix="portlet-client-model" %>        

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<portlet:defineObjects/>
<portlet:resourceURL id="resource_URL" var="resource_URL"> </portlet:resourceURL>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<DIV style="margin: 12px; margin-bottom: 36px">
<h3 align="center">Employee Data</h3>
<FORM action="<portlet:actionURL/>" method="post">
<INPUT  type="submit" value="GETResponse" style="align:center"></INPUT>
<input type="button"  id="post" value="POSTResponse" style="align:center"></INPUT></br></br>
			<div id="data">
		 Employee Id:<input type="text" name="empId" id="empId" align="center"><br/><br/><br/>
		 	</div>

<table id="table" style="display: none;">


<tr><td><label>Employee Id&emsp;&nbsp;</label><input type="text" name="employeeId" id="employeeId"> </td></tr></br>
<tr>
<td><label>Id&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="id1" id="id1"> <br></td></tr>

<tr><td><label>Category Id &emsp;&nbsp;</label><input type="text" name="categoryId" id="categoryId"> <br></td></tr>

<tr><td><label>SubCategory Id</label><input type="text" name="subCategoryId" id="subCategoryId"> <br></td></tr>

<tr><td><label>Skill Id&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="skillId" id="skillId"> <br></td></tr>

<tr><td><label>Start Date&emsp;&emsp;&nbsp;</label> <input type="text" name="startDate" id="startDate"> <br></td></tr>

<tr><td><label>End Date&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="endDate" id="endDate"> <br></td></tr>

<tr><td><label>Remarks&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label> <input type="text" name="remarks" id="remarks"> <br></td></tr>
<tr><td> <input type="button" value="CreateEmployee" id="click" > </td><br>
</table>
</FORM>

<script type="text/javascript">

$("#post").click(function(){
 $("table").show();
 $("#data").hide();
 

});
$("#click").click(function(){


 	var url='<portlet:resourceURL/>'

 employeeId=$("#employeeId").val();
 id=$("#id1").val();
 categoryId=$("#categoryId").val();
 subCategoryId=$("#subCategoryId").val();
 skillId=$("#skillId").val();
 startDate=$("#startDate").val();
 endDate=$("#endDate").val();
 remarks=$("#remarks").val();

  $.ajax({
        type: "POST",
        url: url,
		 async: false,
        data: { 

       "action":"postEmplyeeTimeline",
       "id1":id,
       "employeeId":employeeId,
     	 "categoryId":categoryId,
        "subCategoryId":subCategoryId,
        "skillId":skillId,
        "startDate":startDate,
         "endDate":endDate,
         "remarks":remarks
		
		},
        success: function(response) {
			console.log("response "+response);
			
          }

    });

});

</script>

</DIV>

