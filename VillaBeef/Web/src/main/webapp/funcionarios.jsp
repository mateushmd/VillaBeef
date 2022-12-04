<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="icon" href="imgs/icon.png" type="image/png">
        <title>Gerenciar Funcionários - Villa Beef</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/table.css">
        <link rel="stylesheet" href="css/form.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>
    <body>

        <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_b695d40b1c0e531?useSSL=false" user= "b4ef7c73d61cc7"  password= "c101e0f6" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from equipe
        </sql:query>

        <% if(session.getAttribute("usuario") == null){
               request.setAttribute("errorMessage", "Você não tem acesso à essa página.");
               request.setAttribute("errorMessage1", "Por favor faça Login.");
               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
               rd.forward(request, response);
            } 
        %>

        <header>
            <a href="menuGerencia.jsp">
                <?xml version="1.0" ?><?xml version="1.0" ?><svg class="icon" id="header-back" style="enable-background:new 0 0 16 16;" version="1.1" viewBox="0 0 16 16" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M8,0C3.582,0,0,3.582,0,8s3.582,8,8,8s8-3.582,8-8S12.418,0,8,0z M10.354,12.646l-0.707,0.707L4.293,8l5.354-5.354  l0.707,0.707L5.707,8L10.354,12.646z"/></svg>
                <h1 id="header-title">VILLA</h1></a>
        </header>
        <div class="content">
            <div class="table-responsive">
                <p class="result"><c:if test = "${not empty op}">
                            <c:choose> 
                                <c:when test = "${op eq 'a'}">
                                    Usuário <label class="result-info"><c:out value="${res}"/></label> cadastrado com sucesso!
                                </c:when>
                                <c:when test = "${op eq 'e'}">
                                    Usuário <label class="result-info"><c:out value="${res}"/></label> editado com sucesso!
                                </c:when>
                                <c:when test = "${op eq 'ex'}">
                                    Usuário <label class="result-info"><c:out value="${res}"/></label> excluído com sucesso!
                                </c:when>
                            </c:choose>
                      </c:if>
                </p>
                <table class="table custom-table">
                    <thead>
                        <tr>
                            <th scope="col">
                                <label class="control control--checkbox">
                                    <input type="checkbox" class="js-check-all"/>
                                    <div class="control__indicator"></div>
                                </label>
                            </th>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Ocupação</th>
                            <th scope="col">Salário</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${result.rows}">
                            <tr>
                                <th scope="row">
                                    <label class="control control--checkbox">
                                        <input type="checkbox"/>
                                        <div class="control__indicator"></div>
                                    </label>
                                </th>
                                <td><c:out value = "${row.id}"/></td>
                                <td><c:out value = "${row.nome}"/></td>
                                <td><c:out value = "${row.funcao}"/></td>
                                <td><c:out value = "R$ ${String.valueOf(row.salario).replace('.', ',')}"/></td>
                                <td>
                                    <button type="button" class="btn btn-outline-primary" name="editar" data-bs-toggle="modal" data-bs-target="#editarFun" data-backdrop="false" data-id="<c:out value = "${row.id}"/>" role="button" onclick="document.getElementById('editarFun').classList.toggle('visible')">Editar</button>
                                    <button type="button" class="btn btn-outline-primary" name="excluir" data-bs-toggle="modal" data-bs-target="#removerFun" data-backdrop="false" data-id="<c:out value = "${row.id}"/>" data-nome="<c:out value = "${row.nome}"/>" role="button" onclick="document.getElementById('removerFun').classList.toggle('visible')">Excluir</button>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div id="commands">
                    <button class="btn" onclick="document.getElementById('cadastroFun').classList.toggle('visible')" id="commands-cadastrar">Cadastrar</button>
                </div>
            </div>
            
            <div class="modal modal-wrap" id="cadastroFun">
                <div class="wrap">
                    <form method="post" action="FuncionarioServlet?op=a">
                        <div class="form-body">
                            <fieldset>
                                <legend><i class="fa fa-user"></i> Cadastrar Novo Funcionário</legend>
                                <label for="fname">Nome Completo</label>
                                <input type="text" id="fname" name="fname" required="">
                                <label for="cpf">CPF</label>
                                <input type="text" id="cpf" name="cpf" required="" max="11">
                                <label for="address">Conta Bancária</label>
                                <input type="text" id="conta" name="conta" required="">
                                <label for="funcao">Função</label>
                                <input type="text" id="funcao" name="funcao" required="">
                                <label for="zip">Salário</label>
                                <input type="text" id="salario" name="salario" required="">
                            </fieldset>
                            <fieldset>
                                <legend><i class="fa fa-lock"></i> Login</legend>
                                <label for="cr_password">Senha</label>
                                <input type="password" id="cr_password" name="cr_password" required="">
                            </fieldset>
                        </div>
                        <div class="form-footer">
                            <input type="submit" value="Cadastrar">
                            <p class="btn-cancelar" onclick="document.getElementById('cadastroFun').classList.toggle('visible')">Cancelar</p>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-wrap modal" id="editarFun" data-backdrop="false" aria-labelledby="modalEditarTitle" aria-hidden="true">
                <div class="wrap">
                    <form method="post" action="FuncionarioServlet?op=e">
                        <div class="form-body">
                            <fieldset>
                                <legend><i class="fa fa-user"></i> Editar Funcionário</legend>
                                <label for="fname">Nome Completo</label>
                                <input type="text" id="fname" name="fname" required="">
                                <label for="identificacao">ID</label>
                                <input type="text" id="identificacao" class="form-control" name="identificacao" placeholder="">
                                <label for="address">Conta Bancária</label>
                                <input type="text" id="conta" name="conta" required="">
                                <label for="funcao">Função</label>
                                <input type="text" id="funcao" name="funcao" required="">
                                <label for="zip">Salário</label>
                                <input type="text" id="salario" name="salario" required="">
                            </fieldset>
                        </div>
                        <div class="form-footer">
                            <input type="submit" value="Confirmar">
                            <p class="btn-cancelar" onclick="document.getElementById('editarFun').classList.toggle('visible')">Cancelar</p>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal modal-wrap" id="removerFun">
                <div class="wrap">
                    <form method="post" action="FuncionarioServlet?op=ex">
                        <div class="form-body">
                            <legend><i class="fa fa-user"></i>Remover Funcionário</legend>
                            <p>Deseja mesmo remover o funcionário?</p>
                            <fieldset> 
                                <label for="identificacao2">ID</label>
                                <input type="text" id="identificacao2" name="identificacao2" required="" max="11">
                            </fieldset>
                        </div>
                        <div class="form-footer">
                            <input type="submit" value="Remover">
                            <p class="btn-cancelar" onclick="document.getElementById('removerFun').classList.toggle('visible')">Cancelar</p>
                        </div>
                    </form>
                </div>
            </div>
            
        </div>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="js/main.js"></script>
        <script src="js/mask.js"></script>

        <script>
        const editarModal = document.getElementById('editarFun')
            editarModal.addEventListener('show.bs.modal', event => {

              const button = event.relatedTarget
              const recipient = button.getAttribute('data-id')
              const modalBodyInput = editarModal.querySelector('#identificacao')

              modalBodyInput.value = recipient
            })
            
        const excluirModal = document.getElementById('removerFun')
        excluirModal.addEventListener('show.bs.modal', event => {
            
          const button = event.relatedTarget
          const recipient = button.getAttribute('data-id')
          const modalBodyInput = excluirModal.querySelector('#identificacao2')

          modalBodyInput.value = recipient
        })
        </script>
    </body>
</html>


