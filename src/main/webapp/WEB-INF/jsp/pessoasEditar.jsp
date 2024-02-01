<!DOCTYPE html>

<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="./base.jsp"%>

<html lang="pt-BR">
<head>
    <title>Editar pessoa</title>
    <meta content="text/html; charset=utf-8" />
</head>
<body>


<div class="container mt-3">

    <h1>Edit Employee Form</h1>
    <form action="updateEmployee" method="post">

        <div class="row">
            <div class="col">
                <div class="form-group invisible">
                    <label for="id">Id</label> <input type="text"
                                                      value="${pessoa.id}" class="form-control" id="id" name="id"
                                                      readonly="readonly">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="name">Name</label> <input type="text"
                                                          value="${pessoa.nome }" class="form-control" id="name"
                                                          name="name" placeholder="Enter Name">
                </div>
            </div>
                        <div class="col">
                            <div class="form-group">
                                <label for="designation">Designation</label> <input type="text"
                                                                                    value="${pessoa.cpf }" class="form-control"
                                                                                    id="designation" name="designation"
                                                                                    placeholder="Enter Designation">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <label for="department">Department</label> <input
                                    type="text" class="form-control" id="department"
                                    value="${pessoa.datanascimento }" name="department"
                                    placeholder="Enter department">
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label for="salary">Salary</label>
                                <select class="custom-select my-1 mr-sm-2" id="salary">
                                    <option value=true>Verdadeiro</option>
                                    <option value=false>falso</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <label for="address">Address</label>
                                <select class="custom-select my-1 mr-sm-2" id="address">
                                    <option value=true>Verdadeiro</option>
                                    <option value=false>falso</option>
                                </select>
                            </div>
                        </div>
                    </div>

            <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

</body>
<%--<script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>--%>
</html>