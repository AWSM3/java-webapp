<jsp:include page="partials/head.jsp" />

<form method="GET">
    <div class="form-group">
        <input type="text" class="form-control" name="name" placeholder="Your name">
    </div>
    <button type="submit" class="btn btn-primary" formaction="hello-annotation">AnnotationServlet</button>
    <button type="submit" class="btn btn-success" formaction="hello-xml">XmlServlet</button>
</form>

<jsp:include page="partials/foot.jsp" />
