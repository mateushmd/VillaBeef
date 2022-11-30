<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Villa Beef</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="icon" href="imgs/icon.png" type="image/png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/form.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
    <body>
        
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
              <th scope="col">Data</th>
              <th scope="col">Produto</th>
              <th scope="col">Valor</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">
                <label class="control control--checkbox">
                  <input type="checkbox"/>
                  <div class="control__indicator"></div>
                </label>
              </th>
              <td>001</td>
              <td>26/11</td>
              <td>Carne</td>
              <td>R$ 29,00</td>
            </tr>
            <tr>
              <th scope="row">
                <label class="control control--checkbox">
                  <input type="checkbox"/>
                  <div class="control__indicator"></div>
                </label>
              </th>
              <td>002</td>
              <td>23/11</td>
              <td>Carne</td>
              <td>R$ 47,90</td>
            </tr>
            <tr>
              <th scope="row">
                <label class="control control--checkbox">
                  <input type="checkbox"/>
                  <div class="control__indicator"></div>
                </label>
              </th>
              <td>003</td>
              <td>27/11</td>
              <td>Carne</td>
              <td>R$ 15,50</td>
            </tr>
            <tr>
              <th scope="row">
                <label class="control control--checkbox">
                  <input type="checkbox"/>
                  <div class="control__indicator"></div>
                </label>
              </th>
              <td>004</td>
              <td>24/11</td>
              <td>Carne</td>
              <td>R$ 7,60</td>
            </tr>
          </tbody>
        </table>
        <div id="commands">
          <p class="commands-text" onclick="document.getElementById('cadastroVen').classList.toggle('visible')" id="commands-cadastrar">Cadastrar</p>
          <p class="commands-text" onclick="document.getElementById('editarVen').classList.toggle('visible')">Editar</p>
          <p class="commands-text" onclick="document.getElementById('removerVen').classList.toggle('visible')">Remover</p>
        </div>
      </div>
      <div class="modal modal-wrap" id="cadastroVen">
        <div class="wrap">
          <form>
              <div class="form-body">
                  <fieldset>
                      <legend><i class="fa fa-user"></i> Cadastrar Venda</legend>
                      <label for="id">ID</label>
                      <input type="number" id="id" name="id" required="">
                      <label for="data">Data</label>
                      <input type="date" id="data" name="data" required="">
                      <label for="produto">Produto</label>
                      <input type="text" id="produto" name="produto">
                      <label for="valor">Valor</label>
                      <input type="number" id="valor" name="valor" required="">
                  </fieldset>
              </div>
              <div class="form-footer">
                  <input type="submit" value="Cadastrar">
                  <p class="btn-cancelar" onclick="document.getElementById('cadastroVen').classList.toggle('visible')">Cancelar</p>
              </div>
          </form>
        </div>
      </div>
      <div class="modal modal-wrap" id="editarVen">
        <div class="wrap">
          <form>
              <div class="form-body">
                  <fieldset>
                      <legend><i class="fa fa-user"></i> Editar Venda</legend>
                      <label for="id">ID</label>
                      <input type="number" id="id" name="id" required="">
                      <label for="data">Data</label>
                      <input type="date" id="data" name="data" required="">
                      <label for="produto">ID do Produto</label>
                      <input type="text" id="produto" name="produto" required="">
                      <label for="valor">Valor</label>
                      <input type="number" id="valor" name="valor" required="">
                  </fieldset>
              </div>
              <div class="form-footer">
                  <input type="submit" value="Confirmar">
                  <p class="btn-cancelar" onclick="document.getElementById('editarVen').classList.toggle('visible')">Cancelar</p>
              </div>
          </form>
        </div>
      </div>
      <div class="modal modal-wrap" id="removerVen">
        <div class="wrap">
          <form>
              <div class="form-body">
                  <legend><i class="fa fa-user"></i> Remover Venda</legend>
                  <p>Deseja mesmo remover a venda <span id="span-remover-ven" style="font-weight: 600;">001</span>?</p>
              </div>
              <div class="form-footer">
                <input type="submit" value="Remover">
                <p class="btn-cancelar" onclick="document.getElementById('removerVen').classList.toggle('visible')">Cancelar</p>
              </div>
          </form>
        </div>
      </div>
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/mask.js"></script>
    </body>
</html>
