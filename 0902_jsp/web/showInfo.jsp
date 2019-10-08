<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.domain.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户信息</title>
</head>
<body>

<%--<%--%>
    <%--List customers = new ArrayList();--%>
    <%--customers.add(new Customer(1,"Tom","Beijing");--%>
    <%--customers.add(new Customer(1,"Tom","Beijing");--%>
    <%--customers.add(new Customer(1,"Tom","Beijing");--%>
    <%--customers.add(new Customer(1,"Tom","Beijing");--%>
    <%--request.setAttribute("customers",customers);--%>
<%--%>--%>

<table border="1px" width="500px" align="center" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>地址</th>
    </tr>
    <c:forEach items="${customers}" varStatus="s" var="customer">
        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="#A87752 ">
                <th>${customer.id}</th>
                <th>${customer.name}</th>
                <th>${customer.address}</th>
            </tr>
        </c:if>
        <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="#6a3906">
                <th>${customer.id}</th>
                <th>${customer.name}</th>
                <th>${customer.address}</th>
            </tr>
        </c:if>

    </c:forEach>
</table>
</body>
</html>
