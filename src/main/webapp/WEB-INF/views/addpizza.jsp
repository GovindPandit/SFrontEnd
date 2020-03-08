<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${p==null}">
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
			<label>Enter Pizza Description</label>
			<spform:textarea path="description" class="form-control" placeholder="Enter Description"/>
		</div>
		<div class="formgroup">
			<input type="submit" value="Add Pizza" class="btn btn-primary btn-block"/>
			<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
		</div>
	</spform:form>
	</c:if>
	
	<c:if test="${p!=null}">
	<spform:form modelAttribute="p" action="${pageContext.request.contextPath}/pizza/update" method="post">
		<div class="formgroup">
			<label>Enter Pizza id</label>
			<spform:input path="pizzaid" class="form-control" placeholder="Enter id"/>
		</div>
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
			<label>Enter Pizza Description</label>
			<spform:textarea path="description" class="form-control" placeholder="Enter Description"/>
		</div>
		<div class="formgroup">
			<input type="submit" value="Update Pizza" class="btn btn-primary btn-block"/>
			<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
		</div>
	</spform:form>
	</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>