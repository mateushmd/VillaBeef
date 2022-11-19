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
    </head>
    <body>

        <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_b695d40b1c0e531?useSSL=false" user= "b4ef7c73d61cc7"  password= "c101e0f6" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from equipe
        </sql:query>

        <header>
            <a href="menuGerencia.html">
                <?xml version="1.0" ?><svg viewBox="0 0 64 64" class="icon" id="header-logo" xmlns="http://www.w3.org/2000/svg"><title/><g data-name="Layer 10" id="Layer_10"><path d="M20,21a5,5,0,0,0-5,5v1.59L21.59,21Z"/><path d="M16.28,32.31,32.22,16.37a7.48,7.48,0,0,0-3,1.84,9.5,9.5,0,0,1-4.53,2.52l-9.51,9.51A5.13,5.13,0,0,0,16.28,32.31Z"/><path d="M22,40v1a1,1,0,0,0,1,1h1a3,3,0,0,1,3,3v2a1,1,0,0,0,2,0V45a3,3,0,0,1,6,0v6a1,1,0,0,0,2,0V49a3,3,0,0,1,3-3h3a1,1,0,0,0,1-1V39.54A10,10,0,0,1,41,40Z"/><path d="M32.59,34,48,18.63A6,6,0,0,0,46.37,17l-17,17Z"/><path d="M26.59,34,44.41,16.17A5.92,5.92,0,0,0,43,16H41.41l-18,18Z"/><path d="M20,34h.59l18-18H35.41L17.89,33.52A5,5,0,0,0,20,34Z"/><path d="M49,26.44,41.44,34A8,8,0,0,0,49,26.44Z"/><path d="M41,36H20a7,7,0,0,1-4.9-2A5,5,0,0,0,20,38H41a8,8,0,0,0,7.6-5.52A10,10,0,0,1,41,36Z"/><path d="M32,7A25,25,0,1,0,57,32,25,25,0,0,0,32,7ZM51,27v3a10,10,0,0,1-5,8.65V45a3,3,0,0,1-3,3H40a1,1,0,0,0-1,1v2a3,3,0,0,1-6,0V45a1,1,0,0,0-2,0v2a3,3,0,0,1-6,0V45a1,1,0,0,0-1-1H23a3,3,0,0,1-3-3V40a7,7,0,0,1-7-7V26a7,7,0,0,1,7-7h2.46a7.45,7.45,0,0,0,5.33-2.21A9.48,9.48,0,0,1,34.54,14H43a8,8,0,0,1,8,8v4c0,.34,0,.67,0,1Z"/><path d="M32,3A29,29,0,1,0,61,32,29,29,0,0,0,32,3Zm0,56A27,27,0,1,1,59,32,27,27,0,0,1,32,59Z"/><path d="M35.41,34h3.18L49,23.59V22a5.92,5.92,0,0,0-.17-1.41Z"/></g></svg>
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>

