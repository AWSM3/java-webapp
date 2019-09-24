<jsp:include page="partials/head.jsp" />

<%@ page import="com.lanit.webapp.servlet.NamingServlet" %>

<form method="POST" action="naming">
    <div class="form-group">
        <input type="hidden" name="type" value="<%= NamingServlet.PARAMETER_LASTNAME %>">
        <input type="text" class="form-control" name="value" placeholder="Lastname">
    </div>
    <button type="submit" class="btn btn-success">Next</button>
</form>

<jsp:include page="partials/foot.jsp" />
