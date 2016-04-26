<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form" action="updateEmployee.do" Method="POST">
		<table>
		<tr><td>First Name:<input type="text" name="firstName" value="${fn}"></td></tr>
	
		<tr><td>Last Name:<input type="text" name="lastName" value="${ln}"></td></tr>
	
	    <tr></td>Department ID:<input type="text" name="dept_id" value="${d_id}"></td></tr>		
	    
	    <tr><td>Job ID:<input type="text" name="job_id" value="${j_id}"></td></tr>
	
		<tr><td><input type="hidden" name="id" value="${employee.id}"></td></tr>
		<tr><td><button type="submit" name="edit" value="edit">Update</button></td></tr>
		</table>
	</form>	


</body>
</html>