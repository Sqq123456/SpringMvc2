<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/18 0018
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<from:form modelAttribute="Producto" action="/selectAll/insert2.do">
    商品名称：<form:input path="name"></form:input>
    商品价格：<from:input path="price"></from:input>
    商品类型：<from:select path="productType.id"
                            items="${lx}"
                            itemLabel="name"
                            itemValue="id"></from:select>
    <button>添加</button>

</from:form>


</body>
</html>
