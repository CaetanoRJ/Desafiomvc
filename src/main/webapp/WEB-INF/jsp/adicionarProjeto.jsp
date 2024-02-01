
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="./base.jsp"%>
<%@include file="./home.jsp"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Adicionar Projeto</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <!-- Estilo para o DatePicker -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <script>
        (function () {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
        $(document).ready(function() {
            $("#dataInicio").datepicker({
                dateFormat: 'yyyy-mm-dd', // Formato do banco de dados
                altFormat: 'dd/mm/yy', // Formato de exibição
                altField: '#dataInicio',   // Campo oculto para armazenar o formato do banco de dados
                changeMonth: true,
                changeYear: true
            });
            $("#dataFim").datepicker({
                dateFormat: 'yyyy-mm-dd',
                altFormat: 'dd/mm/yy',
                altField: '#dataFim',
                changeMonth: true,
                changeYear: true
            });
            $("#dataPrevisaoFim").datepicker({
                dateFormat: 'yyyy-mm-dd',
                altFormat: 'dd/mm/yy',
                altField: '#dataPrevisaoFim',
                changeMonth: true,
                changeYear: true
            });
        });
    </script>
</head>
<body>


<div class="container mt-3">


    <form action="insertProjeto" method="post" >


        <h1>Adicionar Novo Projeto</h1>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="nome">Nome</label> <input type="text"
                                                          value="${projeto.nome }" class="form-control" id="nome"
                                                          name="nome" placeholder="Nome Completo" required="required">
                    <div class="valid-feedback">
                        Looks good!
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="dataInicio">dataInicio</label>
                    <input type="text"
                           class="form-control"
                           id="dataInicio" name="dataInicio"
                           value="<fmt:formatDate value='${projeto.dataInicio}' pattern='dd/MM/yyyy' />"
                           required="required">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="dataPrevisaoFim">dataPrevisaoFim</label>
                    <input type="text"
                           class="form-control"
                           id="dataPrevisaoFim" name="dataPrevisaoFim"
                           value="<fmt:formatDate value='${projeto.dataPrevisaoFim}' pattern='dd/MM/yyyy' />"
                           required="required">
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="dataFim">dataFim</label>
                    <input type="text"
                           class="form-control"
                           id="dataFim" name="dataFim"
                           value="<fmt:formatDate value='${projeto.dataFim}' pattern='dd/MM/yyyy' />"
                           required="required">
                </div>
            </div>
        </div>




        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label >risco</label>
                    <select class="form-select form-select-sm" name="risco">
                        <option value="Baixo Risco">Baixo Risco</option>
                        <option value="Medio Risco">Médio Risco</option>
                        <option value="Alto Risco">Alto Risco</option>
                    </select>
                </div>
            </div>

            <div class="col">
                <div class="form-group" >
                    <label >Status</label>
                    <select class="form-select form-select-sm" name="status" >
                        <option value="Em analise">Em análise</option>
                        <option value="Analise realizada">Planejado</option>
                        <option value="Analise aprovada">Análise aprovada</option>
                        <option value="Iniciado">Iniciado</option>
                        <option value="Planejado">Planejado</option>
                        <option value="Em Andamento">Em Andamento</option>
                        <option value="Encerrado">Encerrado</option>
                        <option value="Cancelado">Cancelado</option>
                    </select>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="descricao">descricao</label> <input
                        type="text" class="form-control" id="descricao"
                        value="${projeto.descricao }" name="descricao"
                        placeholder="descrição do projeto"
                        required="required">
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="orcamento">orcamento</label> <input
                        type="text" class="form-control" id="orcamento"
                        value="${projeto.orcamento }" name="orcamento"
                        placeholder="Digite o orçamento" required="required">
                </div>
            </div>


            <div class="col">
                <div class="form-group">
                    <label for="idGerente">idGerente</label> <input
                        type="text" class="form-control" id="idGerente"
                        value="${projeto.idGerente }" name="idGerente"
                        placeholder="${projeto.idGerente }">
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

</body>
<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</html>