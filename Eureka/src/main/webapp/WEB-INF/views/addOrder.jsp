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
    <title>Cart</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Cart</h1>
        </div>
    </div>
</section>
<section class="container">

    <div class="row">
        <h1>Order</h1>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="row">
                <label>Order Date</label></div>
            <div class="row">
                <label>${order.orderDate}</label>
            </div>
        </div>
        <div class="col-md-4">
            <div class="row">
                <label>Order Total</label></div>
            <div class="row">
                <label>${order.amount}</label>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="row" >
            <div class="col-md-2">
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
            <div class="col-md-1">
                <label>Total</label>
            </div>
            <div class="col-md-2">
                <label>Action</label>
            </div>
        </div>
        <c:forEach items="${order.orderDetails}" var="orderDetail">
            <div class="row">
                <div class="col-md-2">
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
                <div class="col-md-1">
                    <label>${orderDetail.amount}USD</label>
                </div>
                <div class="col-md-2">
                    <a
                            href=" <spring:url value="/orders/removeorderdetail?tempId=${orderDetail.tempId}" /> "
                            class="btn btn-primary"> <span
                            class="glyphicon-remove glyphicon"/></span> Remove
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <a href="/products">Goto Products</a>
    </div>
    <div class="row">
        <section class="container">
            <form:form modelAttribute="customerInfo" class="form-horizontal" >
                <fieldset>
                    <legend>Customer Info</legend>

                    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="firstName"><spring:message code="customerInfo.form.firstName.label"/></label>
                        <div class="col-lg-10">
                            <form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
                            <form:errors path="firstName" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="lastName"><spring:message code="customerInfo.form.lastName.label"/></label>
                        <div class="col-lg-10">
                            <form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
                            <form:errors path="lastName" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="address"><spring:message code="customerInfo.form.address.label"/></label>
                        <div class="col-lg-10">
                            <div class="form:input-prepend">
                                <form:textarea id="address" path="address" rows = "2"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="email"><spring:message code="customerInfo.form.email.label"/></label>
                        <div class="col-lg-10">
                            <form:input id="email" path="email" type="email" class="form:input-large"/>
                            <form:errors path="email" cssClass="text-danger"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="phone"><spring:message code="customerInfo.form.phone.label"/></label>
                        <div class="col-lg-10">
                            <form:input id="phone" path="phone" type="number" class="form:input-large"/>
                            <form:errors path="phone" cssClass="text-danger"/>

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnSubmit" class="btn btn-primary" value ="Create Order"/>
                        </div>
                    </div>

                </fieldset>
            </form:form>
        </section>
    </div>
</section>
</body>
</html>
