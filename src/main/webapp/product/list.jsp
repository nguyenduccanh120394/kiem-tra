<%--
  Created by IntelliJ IDEA.
  User: as
  Date: 12/07/2021
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>LIST PRODUCT</h1>
    <a href="/products?action=create">Create</a>
    <form method="get">
        <input type="hidden" value="action" name="search">
        <input type="text" name="search">
        <input type="submit" value="Search">
    </form>
    <div class = "row">
        <div class="col-mb-4"></div>
        <div class="col-mb-4">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
<%--                <tr>--%>
<%--                    <c:forEach begin="0" var="i" end="${products.size()-1}">--%>
<%--                        <tr>--%>
<%--                            <td>${products.get(i).getName()}</td>--%>
<%--                            <td>${products.get(i).getPrice()}</td>--%>
<%--                            <td>${products.get(i).getQuantity()}</td>--%>
<%--                            <td>${products.get(i).getColor()}</td>--%>
<%--                            <td>${products.get(i).getDescription()}</td>--%>
<%--                <c:if test="${products.get(i).getIdCategory()==categories.get(i).getId()}">--%>
<%--                            <td>${categories.get(i).getName()}</td>--%>
<%--                </c:if>--%>
<%--                            <td><a href="/products?action=edit&id=${products.get(i).getId()}"></a></td>--%>
<%--                            <td><a href="/products?action=delete&id=${products.get(i).getId()}"></a></td>--%>
<%--                        </tr>--%>
<%--                    </c:forEach>--%>
<%--                </tr>--%>
            </table>

        </div>
        <div class="col-mb-4"></div>
    </div>
</div>
</body>
</html>
