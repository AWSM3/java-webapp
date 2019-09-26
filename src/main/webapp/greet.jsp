<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.lanit.webapp.servlet.HelloServlet" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>


<jsp:include page="partials/head.jsp"/>

<h3>
    <fmt:message key="label.greeting">
        <fmt:param value="${requestScope.get(HelloServlet.NAME_PARAMETER)}"/>
        <fmt:param value="${requestScope.get(HelloServlet.CLASS_PARAMETER)}"/>
    </fmt:message>
</h3>

<jsp:include page="partials/foot.jsp"/>
