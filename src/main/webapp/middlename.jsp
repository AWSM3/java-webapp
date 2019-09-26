<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<jsp:include page="partials/head.jsp" />

<%@ page import="com.lanit.webapp.servlet.NamingServlet" %>

<form method="POST" action="naming">
    <div class="form-group">
        <input type="hidden" name="type" value="<%= NamingServlet.PARAMETER_MIDDLENAME %>">
        <input type="text" class="form-control" name="value" placeholder="<fmt:message key="label.middlename" />">
    </div>
    <button type="submit" class="btn btn-success"><fmt:message key="label.next" /></button>
</form>

<jsp:include page="partials/foot.jsp" />
