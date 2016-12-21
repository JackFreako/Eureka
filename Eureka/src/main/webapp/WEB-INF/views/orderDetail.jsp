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
    <title>Order Detail</title>
</head>
<body>
<section class="container">

    <div class="row">
        <div class="row">

            <div class="col-md-3">
                <label>First Name</label>
            </div>
            <div class="col-md-3">
                <label>Last Name</label>
            </div>
            <div class="col-md-3">
                <label>Order Date</label>
            </div>
            <div class="col-md-3">
                <label>Order Total</label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label>${order.customerInfo.firstName}</label>
            </div>
            <div class="col-md-3">
                <label>${order.customerInfo.lastName}</label>
            </div>
            <div class="col-md-3">
                <label>${order.orderDate}</label>
            </div>
            <div class="col-md-3">
                <label>--</label>
            </div>
        </div>
        <div class="row">
            <label>Address</label>
        </div>
        <div class="row">
            <label>${order.customerInfo.address}</label>
        </div>
        <div class="row">
            <div class="row">
                <div class="col-md-3">
                    <label>Name</label>
                </div>
                <div class="col-md-5">
                    <label>Description</label>
                </div>
                <div class="col-md-1">
                    <label>Quantity</label>
                </div>
                <div class="col-md-1">
                    <label>Price</label>
                </div>
                <div class="col-md-2">
                    <label>Total</label>
                </div>
            </div>
            <c:forEach items="${order.orderDetails}" var="orderDetail">
                <div class="row">
                    <div class="col-md-3">
                        <label>${orderDetail.product.name}</label>
                    </div>
                    <div class="col-md-5">
                        <label>${orderDetail.product.description}</label>
                    </div>
                    <div class="col-md-1">
                        <label>${orderDetail.quantity}</label>
                    </div>
                    <div class="col-md-1">
                        <label>${orderDetail.price}USD</label>
                    </div>
                    <div class="col-md-2">
                        <label>${orderDetail.amount}USD</label>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row">
            <a href="/orders">Goto Orders</a>
        </div>
</section>
</body>
</html>
