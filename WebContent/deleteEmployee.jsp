<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="GetEmployeeById.do" method="GET">
			Id:<input type="text" name="id" value=""/>
		<input type="submit" value="Delete Employee"/>
	</form>
	<br><br>
	<form action="GetEmployeeById2.do" method="GET">
			Id:<input type="text" name="id" value=""/>
		<input type="submit" value="Update Employee"/>
	</form>
</body>
</html>