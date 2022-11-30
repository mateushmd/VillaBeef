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
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
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
        
        <%!
            public String pegarTipo(char t) {
                if(t == 's')
                    return "Saída";
                else
                    return "Entrada";
            }

            
        %>

        <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_b695d40b1c0e531?useSSL=false" user= "b4ef7c73d61cc7"  password= "c101e0f6" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from conta
        </sql:query>

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
                            <th scope="col">Data</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${result.rows}">
                            <tr>
                                <td><c:out value = "${row.dataString}"/></td>
                                <td><c:out value = "${row.tipo}"/></td>
                                <td><c:out value = "${row.descricao}"/></td>
                                <td><c:out value = "R$ ${String.valueOf(row.valor > 0 ? row.valor : row.valor * -1).replace('.', ',')}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr style="font-weight: 700">
                            <th scope="row">Total Líquido</th>
                            <td></td>
                            <td></td>
                            <td>R$ 900,00</td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <script src="js/jquery-3.3.1.min.js"></script>
            <script src="js/popper.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/main.js"></script>
    </body>
</html>

