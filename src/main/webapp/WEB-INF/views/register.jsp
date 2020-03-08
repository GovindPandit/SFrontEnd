<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<sp:form modelAttribute="user" action="${pageContext.request.contextPath}/user/add" method="post">
		<div class="form-group">
			<label>Enter Username</label>
			<sp:input path="username" placeholder="Enter Username" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter Email</label>
			<sp:input path="email" placeholder="Enter Email" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Enter Password</label>
			<sp:password path="password" placeholder="Enter Password" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" value="Register" class="btn btn-primary btn-block"/>
			<input type="submit" value="Reset" class="btn btn-danger btn-block"/>
		</div>
	</sp:form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>