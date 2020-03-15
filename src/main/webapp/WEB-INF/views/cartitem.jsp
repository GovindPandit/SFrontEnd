<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<link href='<sp:url value="/css/product.css"></sp:url>' rel="stylesheet"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
			<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" /></div>
						</div>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${cartItem.pizza.pizzaName}</h3>
						<p class="product-description">${cartItem.pizza.description}</p>
						<h4 class="price">current price: <span>Rs. ${cartItem.pizza.price}</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						<div class="action">
							<a href="${pageContext.request.contextPath}/buy/index/${cartItem.pizza.pizzaid}" class="add-to-cart btn btn-primary" type="button">Buy</a>
							<a class="add-to-cart btn btn-secondary" href="${pageContext.request.contextPath}/cart/delete/${cartItem.cartItemId}">Delete</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>