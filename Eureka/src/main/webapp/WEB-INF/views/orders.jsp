<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 12/20/16
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="<spring:url value="/resource/js/controllers.js"/>"></script>
    <title>Orders</title>
</head>
<body>
<section class="container">
    <div class="row">
        <div class="row">
            <div class="col-md-2">
                <label>First Name</label>
            </div>
            <div class="col-md-2">
                <label>Last name</label>
            </div>
            <div class="col-md-4">
                <label>Address</label>
            </div>
            <div class="col-md-2">
                <label>Order Date</label>
            </div>
            <%--<div class="col-md-1">--%>
                <%--<label>Total Amount</label>--%>
            <%--</div>--%>
            <div class="col-md-2">
                <label>Action</label>
            </div>
        </div>
        <c:forEach items="${orders}" var="order">
            <div class="row">
                <div class="col-md-2">
                    <label>${order.customerInfo.firstName}</label>
                </div>
                <div class="col-md-2">
                    <label>${order.customerInfo.lastName}</label>
                </div>
                <div class="col-md-4">
                    <label>${order.customerInfo.address}</label>
                </div>
                <div class="col-md-2">
                    <label>${order.orderDate}</label>
                </div>
                <%--<div class="col-md-1">--%>
                    <%--<label>-</label>--%>
                <%--</div>--%>
                <div class="col-md-2">
                    <a
                            href=" <spring:url value="/orders/view?id=${order.id}" /> "
                            class="btn btn-primary"> <span
                            class="glyphicon-triangle-right glyphicon"/></span> Detail
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <a href="/welcome">Home</a>
    </div>
</section>
</body>
</html>
