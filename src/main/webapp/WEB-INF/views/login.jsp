<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<Div class="container">
	<form action='<sp:url value="/loginaction"></sp:url>' method="post">
		<div class="form-group">
			<label>Username</label>
			<input type="text" name="username" placeholder="Enter Username" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Password</label>
			<input type="password" name="password" placeholder="Enter Password" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" value="Login" class="btn btn-primary btn-block"/>
			<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
		</div>
	</form>
	</Div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>