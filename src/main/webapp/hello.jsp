<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<jsp:include page="partials/head.jsp"/>

<form method="GET">
    <div class="form-group">
        <input type="text" class="form-control" name="name" placeholder="<fmt:message key="label.your-name" />">
    </div>
    <button type="submit" class="btn btn-primary" formaction="hello-annotation"><fmt:message
            key="label.btn-annotation-servlet"/></button>
    <button type="submit" class="btn btn-success" formaction="hello-xml"><fmt:message
            key="label.btn-xml-servlet"/></button>
</form>

<jsp:include page="partials/foot.jsp"/>
