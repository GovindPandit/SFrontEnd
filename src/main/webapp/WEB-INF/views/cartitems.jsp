<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="sp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href='<sp:url value="/css/productgrid.css"></sp:url>'/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
    <h3 class="h3">shopping Demo-6 </h3>
	    <div class="row">
	    	<c:forEach items="${cartItems}"  var="cartItem">
	        <div class="col-md-3 col-sm-6">
	            <div class="product-grid6">
	                <div class="product-image6">
	                    <a href="${pageContext.request.contextPath}/cart/display/${cartItem.cartItemId}">
	                        <img class="pic-1" src='<sp:url value="/images/pizza.jpg"></sp:url>'>
	                    </a>
	                </div>
	                <div class="product-content">
	                    <h3 class="title"><a href="#">${cartItem.pizza.pizzaName}</a></h3>
	                    <div class="price">Rs. ${cartItem.pizza.price}
	                        <span>Rs. ${cartItem.pizza.price}</span>
	                    </div>
	                </div>
	                <ul class="social">
	                    <li><a href="" data-tip="Quick View"><i class="fa fa-search"></i></a></li>
	                    <li><a href="" data-tip="Add to Wishlist"><i class="fa fa-shopping-bag"></i></a></li>
	                    <li><a href="" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a></li>
	                </ul>
	            </div>
	        </div>
	        </c:forEach>
	    </div>
	</div>
	<hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>