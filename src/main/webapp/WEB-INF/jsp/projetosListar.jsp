
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@include file="./home.jsp"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Spring Boot + Bootstrap Table Example</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1>Tabela de Projetos</h1>
    <table class="table" >
        <caption>Tabela de projetos</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Data de Inicio</th>
            <th>Data de Previsao</th>
            <th>Data Final</th>
            <th>Descrição</th>
            <th>Status</th>
            <th>Orçamento</th>
            <th>Risco</th>
            <th scope="col">Editar</th>
            <th scope="col">Excluir</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="projetos" items="${projetos}">
            <tr>
                <td>${projetos.id}</td>
                <td>${projetos.nome}</td>

                <td> <fmt:formatDate value="${projetos.dataInicio}" pattern="dd/MM/yyyy" /></td>
                <td> <fmt:formatDate value="${projetos.dataPrevisaoFim}" pattern="dd/MM/yyyy" /></td>
                <td> <fmt:formatDate value="${projetos.dataFim}" pattern="dd/MM/yyyy" /></td>
                <td>${projetos.descricao}</td>
                <td>${projetos.status}</td>
                <td>R$ ${projetos.orcamento}</td>
                <td>${projetos.risco}</td>
                <td><a href="editarProjeto/${projetos.id}" class="btn btn-warning">
                    Edit </a></td>
                <c:if test="${projetos.status ne 'Em Andamento' and projetos.status ne 'Iniciado'}">
                <td><a href="deletarProjeto/${projetos.id}"
                       class="btn btn-danger">X</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="adicionarProjeto" class="btn btn-primary">
        Adicionar Novo Projeto </a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>
</html>