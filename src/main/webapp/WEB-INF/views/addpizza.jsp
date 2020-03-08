<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<spform:form modelAttribute="pizza" action="${pageContext.request.contextPath}/pizza/add" method="post">
		<div class="formgroup">
			<label>Enter Pizza Name</label>
			<spform:input path="pizzaName" class="form-control" placeholder="Enter Name"/>
		</div>
		<div class="formgroup">
			<label>Enter Pizza Price</label>
			<spform:input path="price" class="form-control" placeholder="Enter Price"/>
		</div>
		<div class="formgroup">
			<label>Enter Pizza Quantity</label>
			<spform:input path="quantity" class="form-control" placeholder="Enter Quantity"/>
		</div>
		<div class="formgroup">
			<input type="submit" value="Add Pizza" class="btn btn-primary btn-block"/>
			<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
		</div>
	</spform:form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>