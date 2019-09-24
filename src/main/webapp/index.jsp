<html>

<head>
    <title>"Hello" app</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<form method="GET">
    <div class="form-group">
        <input type="text" class="form-control" name="name" placeholder="Your name">
    </div>
    <button type="submit" class="btn btn-primary" formaction="hello-annotation">AnnotationServlet</button>
    <button type="submit" class="btn btn-success" formaction="hello-xml">XmlServlet</button>
</form>

</body>
</html>