<%--
  Created by IntelliJ IDEA.
  User: as
  Date: 12/07/2021
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="text" name="quantity" value="${product.quantity}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="text" name="color" value="${product.color}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="text" name="description" value="${product.description}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="text" name="idCategory" value="${product.idCategory}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </table>
</form>
</body>
</html>
