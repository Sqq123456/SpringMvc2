<%--
  Created by IntelliJ IDEA.
  User: feng
  Date: 2019/3/15
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>展示</title>
</head>
<body>
<center>
    <h1>数据展示</h1>
    <hr/>
<form:form modelAttribute="Producto" action="/selectAll/selectname.do">
    <form:input path="name"></form:input>
    <button>查询</button>
</form:form>
    <form action="" method="post">
    <table border="1">
        <tr>

            <td>ID</td>
            <td>产品名称</td>
            <td>产品价格</td>
            <td>产品类型</td>
            <td>操作</td>
        </tr>
        <c:forEach var="pro" items="${prolist}">
            <tr>
                <td><input type="checkbox" name="id" value="${pro.id}"></td>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td>${pro.price}</td>
                <td>${pro.productType.name}</td>
                <td>
                    <a href="/selectAll/delete.do?id=${pro.id}">删除</a>
                    <a href="/selectAll/update.do?id=${pro.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <a href="/selectAll/insert1.do">添加数据</a>
</center>
</body>
</html>



