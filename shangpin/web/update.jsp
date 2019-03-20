<%--
  Created by IntelliJ IDEA.
  User: feng
  Date: 2019/3/18
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form:form modelAttribute="pro" action="/selectAll/update2.do">
    <form:hidden path="id"></form:hidden>
    产品名称:<form:input path="name"></form:input><br/>
    产品价格:<form:input path="price"></form:input><br/>
    产品类型:<form:select path="productType.id"
                      items="${lx}"
                      itemLabel="name"
                      itemValue="id"></form:select><br/>
    <button>提交更新</button>
</form:form>
</body>
</html>
