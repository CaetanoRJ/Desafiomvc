<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Desafio Java</title>

    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
          rel="stylesheet">

</head>
<body>
</body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/listarProjetos">Listar Projetos</a><br/>
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/listarPessoas">Listar Projetos</a><br/>
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">teste</a>
            </div>
        </div>
    </div>
</nav>



<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</html>