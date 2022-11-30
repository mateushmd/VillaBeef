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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/form.css">
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
        <div class="form-body wrap-input">
          <label for="fname">ID do Produto</label>
          <input type="number" id="id-prod" name="id-prod" required="" class="input-add-prod">
        </div>
        <div class="form-body wrap-input">
          <label for="fname">Quantidade</label>
          <input type="number" id="quantidade" name="quantidade" required="" class="input-add-prod">
        </div>
        <?xml version="1.0" ?><svg class="btn-add-prod" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><path d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256C397.4 512 512 397.4 512 256S397.4 0 256 0zM352 280H280V352c0 13.2-10.8 24-23.1 24C242.8 376 232 365.2 232 352V280H160C146.8 280 136 269.2 136 256c0-13.2 10.8-24 24-24H232V160c0-13.2 10.8-24 24-24C269.2 136 280 146.8 280 160v72h72C365.2 232 376 242.8 376 256C376 269.2 365.2 280 352 280z"/></svg>
        <?xml version="1.0" ?><svg style="transform: rotate(45deg);" class="btn-add-prod" id="btn-clear-prod" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><path d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256C397.4 512 512 397.4 512 256S397.4 0 256 0zM352 280H280V352c0 13.2-10.8 24-23.1 24C242.8 376 232 365.2 232 352V280H160C146.8 280 136 269.2 136 256c0-13.2 10.8-24 24-24H232V160c0-13.2 10.8-24 24-24C269.2 136 280 146.8 280 160v72h72C365.2 232 376 242.8 376 256C376 269.2 365.2 280 352 280z"/></svg>
        <table class="table custom-table">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Tipo</th>
              <th scope="col">Marca</th>
              <th scope="col">Quantidade</th>
              <th scope="col">Valor</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>001</td>
              <td>Alcatra</td>
              <td>Friboi</td>
              <td>x22</td>
              <td>29/03/2023</td>
            </tr>
            <tr>
              <td>002</td>
              <td>Fraldinha</td>
              <td>Ao Ponto</td>
              <td>x13</td>
              <td>10/03/2023</td>
            </tr>
            <tr>
              <td>003</td>
              <td>Picanha</td>
              <td>Montanha</td>
              <td>x69</td>
              <td>16/02/2023</td>
            </tr>
            <tr>
              <td>004</td>
              <td>Linguiça de Churrasco</td>
              <td>Minerva</td>
              <td>x17</td>
              <td>17/02/2023</td>
            </tr>
          </tbody>
        </table>
        <div class="caixa-footer">
          <input type="submit" value="Confirmar Venda">
        </div>
      </div>
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/mask.js"></script>
    <script>
      
        let inputs = document.querySelectorAll(".input-add-prod");
        let btnadd = document.getElementById("btn-clear-prod");

        btnadd.addEventListener('click', clear);

        function clear() {
            inputs.forEach(input => {
                input.value = "";
            });
        }
    </script>
    </body>
</html>
