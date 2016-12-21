<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <form method="get" action="/products/search">
            <div class="row">
                <div class="col-md-4">
                    <input type="text" id="name" name="name" placeholder="Product Name">
                </div>
                <div class="col-md-4">
                    <input type="number" id="min" name="min" value="0" placeholder="Minimum Price">
                </div>
                <div class="col-md-4">
                    <input type="number" id="max" name="max" value="0" placeholder="Maximum Price">
                </div>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <input type="text" id="desc" name="desc" placeholder="Product Description">
                </div>
                <div class="col-md-2">
                    <button id="search" type="submit">Search</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row">
        <label>Search result for Product Name=${name}, Description=${desc}, Price Range from=${min}-${max} </label>
    </div>
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>${product.price}USD</p>
                        <p>
                            <a
                                    href=" <spring:url value="/products/product?id=${product.id}" /> "
                                    class="btn btn-primary"> <span
                                    class="glyphicon-info-sign glyphicon"/></span> Details
                            </a>
                            &nbsp;
                            <a
                                    href=" <spring:url value="/products/delete?id=${product.id}" /> "
                                    class="btn btn-primary"> <span
                                    class="glyphicon-remove glyphicon"/></span> Remove
                            </a>
                            <a
                                    href=" <spring:url value="/orders/addorderdetail?productId=${product.id}" /> "
                                    class="btn btn-primary"> <span
                                    class="glyphicon-remove glyphicon"/></span> Add to order
                            </a>
                        </p>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <br/>
    <p>
        <a href="/products/all">Show all</a>
    </p>
    <br/>
    <p>
        <button type=button onclick=window.location.href="<spring:url value="/welcome"/>">Home</button>
    </p>
</section>
</body>
</html>
