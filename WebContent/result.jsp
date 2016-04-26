<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action=deleteEmployee.do method="POST">
    		${employee.firstName} ${employee.lastName}
    		<br>
    		ID#: ${employee.id}
			<input type="hidden" name="id" value="${employee.id}"></input>
			<input type="hidden" name="firstName" value="${employee.firstName}"></input>
			<input type="hidden" name="lastName" value="${employee.lastName}"></input>
			<input type="hidden" name="dept_id" value="${employee.dept_id}"></input>
			<input type="hidden" name="job_id" value="${employee.job_id}"></input>
			<br>
			<button type="submit" name="delete" value="remove">Delete</button>
	</form>

</body>
</html> 