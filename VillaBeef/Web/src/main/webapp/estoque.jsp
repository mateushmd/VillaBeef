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
        <title>Villa Beef</title>
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

        <% if(session.getAttribute("usuario") == null){
                request.setAttribute("errorMessage", "Você não tem acesso à essa página.");
                request.setAttribute("errorMessage1", "Por favor faça Login.");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
             } 
        %>

        <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_b695d40b1c0e531?useSSL=false" user= "b4ef7c73d61cc7"  password= "c101e0f6" />
        <sql:query dataSource="${conexao}" var="itens" >
            select * from estoque
        </sql:query>
        <sql:query dataSource="${conexao}" var="produtos" >
            select * from produtos
        </sql:query>

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
                                    Produto <label class="result-info"><c:out value="${res}"/></label> cadastrado com sucesso!
                                </c:when>
                                <c:when test = "${op eq 'e'}">
                                    Produto <label class="result-info"><c:out value="${res}"/></label> editado com sucesso!
                                </c:when>
                                <c:when test = "${op eq 'ex'}">
                                    Produto <label class="result-info"><c:out value="${res}"/></label> excluído com sucesso!
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
                            <th scope="col">Tipo</th>
                            <th scope="col">Marca</th>
                            <th scope="col">ID</th>
                            <th scope="col">Validade</th>
                            <th scope="col">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${itens.rows}">
                            <tr>
                                <th scope="row">
                                    <label class="control control--checkbox">
                                        <input type="checkbox"/>
                                        <div class="control__indicator"></div>
                                    </label>
                                </th>
                                <td><c:out value = "${produtos.rows[row.id_produto - 1].tipo}"/></td>
                                <td><c:out value = "${produtos.rows[row.id_produto - 1].marca}"/></td>
                                <td><c:out value = "${row.id}"/></td>
                                <td><c:out value = "${row.validade}"/></td>
                                <td><c:out value = "R$ ${String.valueOf(row.valor).replace('.', ',')}"/></td>
                                <td>
                                    <button type="button" class="btn btn-outline-primary" name="editar" data-bs-toggle="modal" data-bs-target="#editarProd" data-backdrop="false" data-id="<c:out value = "${row.id}"/>" role="button" onclick="document.getElementById('editarProd').classList.toggle('visible')">Editar</button>
                                    <button type="button" class="btn btn-outline-primary" name="excluir" data-bs-toggle="modal" data-bs-target="#removerProd" data-backdrop="false" data-id="<c:out value = "${row.id}"/>" data-nome="<c:out value = "${row.nome}"/>" role="button" onclick="document.getElementById('removerProd').classList.toggle('visible')">Excluir</button>
                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
                <div id="commands">
                    <p class="commands-text" onclick="document.getElementById('cadastroProd').classList.toggle('visible')" id="commands-cadastrar">Cadastrar</p>
                </div>
            </div>
            <div class="modal modal-wrap" id="cadastroProd">
                <div class="wrap">
                    <form method="post" action="ProdutosServlet?op=a">
                        <div class="form-body">
                            <fieldset>
                                <legend><i class="fa fa-user"></i>Cadastrar Produto</legend>
                                <label for="tipo">Tipo</label>
                                <input type="text" id="tipo" name="tipo" required="">
                                <label for="marca">Marca</label>
                                <input type="text" id="marca" name="marca" required="">
                                <label for="id">ID</label>
                                <input type="text" id="id" name="id" required="">
                                <label for="validade">Validade</label>
                                <input type="date" id="validade" name="validade" required="">
                                <label for="valor">Valor de Compra</label>
                                <input type="text" id="valor" name="valor" required="">
                                <label for="valor-venda">Valor de Venda</label>
                                <input type="text" id="valor-venda" name="valor-venda" required="">
                            </fieldset>
                        </div>
                        <div class="form-footer">
                            <input type="submit" value="Cadastrar">
                            <p class="btn-cancelar" onclick="document.getElementById('cadastroProd').classList.toggle('visible')">Cancelar</p>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal modal-wrap" id="editarProd">
                <div class="wrap">
                    <form  method="post" action="ProdutosServlet?op=e">
                        <div class="form-body">
                            <fieldset>
                                <legend><i class="fa fa-user"></i>Editar Produto</legend>
                                <label for="tipo">Tipo</label>
                                <input type="text" id="tipo" name="tipo" required="">
                                <label for="marca">Marca</label>
                                <input type="text" id="marca" name="marca" required="">
                                <label for="id">ID</label>
                                <input type="text" id="identificacao" name="identificacao" required="">
                                <label for="validade">Validade</label>
                                <input type="date" id="validade" name="validade" required="">
                                <label for="valor">Valor De Compra</label>
                                <input type="text" id="valor" name="valor" required="">
                                <label for="valor-venda">Valor de Venda</label>
                                <input type="text" id="valor-venda" name="valor-venda" required="">
                            </fieldset>
                        </div>
                        <div class="form-footer">
                            <input type="submit" value="Confirmar">
                            <p class="btn-cancelar" onclick="document.getElementById('editarProd').classList.toggle('visible')">Cancelar</p>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal modal-wrap" id="removerProd">
                <div class="wrap">
                    <form  method="post" action="ProdutosServlet?op=ex">
                        <div class="form-body">
                            <legend><i class="fa fa-user"></i> Remover Produto</legend>
                            <p>Deseja mesmo remover o produto?</p>
                            <fieldset> 
                                <label for="identificacao">ID</label>
                                <input type="text" id="identificacao2" name="identificacao2" required="" max="11">
                            </fieldset>
                        </div>
                        <div class="form-footer">
                            <input type="submit" value="Remover">
                            <p class="btn-cancelar" onclick="document.getElementById('removerProd').classList.toggle('visible')">Cancelar</p>
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
                                let editarModal = document.getElementById('editarProd')
                                editarModal.addEventListener('show.bs.modal', event => {
                                    let button = event.relatedTarget
                                    let recipient = button.getAttribute('data-id')
                                    let modalBodyInput = editarModal.querySelector('#identificacao')
                                    modalBodyInput.value = recipient
                                })

                                let excluirModal = document.getElementById('removerProd')
                                excluirModal.addEventListener('show.bs.modal', event => {
                                  let button = event.relatedTarget
                                  let recipient = button.getAttribute('data-id')
                                  let modalBodyInput = excluirModal.querySelector('#identificacao2')
                                  modalBodyInput.value = recipient
                                })
        </script>
    </body>
</html>

