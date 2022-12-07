<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="icon" href="imgs/icon.png" type="image/png">
        <title>Gerenciar Rentabilidade - Villa Beef</title>
        <link rel="stylesheet" href="https://cdn.discordapp.com/attachments/870019938511880232/1049902430587990116/coreui-min.css">
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>

        <% if(session.getAttribute("usuario") == null){
                request.setAttribute("errorMessage", "Você não tem acesso à essa página.");
                request.setAttribute("errorMessage1", "Por favor faça Login.");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
             }
             
             int soma = 0;
             
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
            
        <sql:query dataSource="${conexao}" var="result2" >
            select * from dados
        </sql:query>

        <header>
            <a href="menuGerencia.jsp">
                <?xml version="1.0" ?><?xml version="1.0" ?><svg class="icon" id="header-back" style="enable-background:new 0 0 16 16;" version="1.1" viewBox="0 0 16 16" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M8,0C3.582,0,0,3.582,0,8s3.582,8,8,8s8-3.582,8-8S12.418,0,8,0z M10.354,12.646l-0.707,0.707L4.293,8l5.354-5.354  l0.707,0.707L5.707,8L10.354,12.646z"/></svg>
                <h1 id="header-title">VILLA</h1></a>
        </header>
        <div class="content">
            <div class="content">
                <div class="cards">
                    <div class="card mb-4" id="card-st-1">
                        <div class="card-body pb-0 d-flex justify-content-between align-items-start">
                            <div>
                                <div class="fs-4 fw-semibold">160K <span class="fs-6 fw-normal"></span></div>
                                <div>Vendas</div>
                            </div>
                        </div>
                        <div class="c-chart-wrapper mt-3 mx-3" style="height:70px;">
                            <canvas class="chart" id="card-chart1" height="70"></canvas>
                        </div>
                    </div>
                    <div class="card mb-4" id="card-st-2">
                        <div class="card-body pb-0 d-flex justify-content-between align-items-start">
                            <div>
                                <div class="fs-4 fw-semibold">56K <span class="fs-6 fw-normal"></span></div>
                                <div>Gastos</div>
                            </div>
                        </div>
                        <div class="c-chart-wrapper mt-3 mx-3" style="height:70px;">
                            <canvas class="chart" id="card-chart2" height="70"></canvas>
                        </div>
                    </div>
                </div>
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
                        <c:set var="totalEntrada" value="${0.00}"></c:set>
                        <c:set var="totalSaida" value="${0.00}"></c:set>
                        <c:forEach var="row" items="${result.rows}">
                            <tr>
                                <td><c:out value = "${row.dataString}"/></td>
                                <td>
                                    <c:choose>
                                            <c:when test = "${row.tipo eq 's'}">
                                                <c:out value = "Saída"/></td>
                                                <c:set var="totalSaida" value="${totalSaida + String.valueOf(row.valor > 0 ? row.valor : row.valor * -1)}"></c:set>
                                            </c:when>
                                            <c:when test = "${row.tipo eq 'e'}">
                                                <c:out value = "Entrada"/></td>
                                                <c:set var="totalEntrada" value="${totalEntrada + String.valueOf(row.valor > 0 ? row.valor : row.valor * -1)}"></c:set>
                                            </c:when>
                                    </c:choose>
                                <td><c:out value = "${row.descricao}"/></td>
                                <td><fmt:formatNumber value = "${row.valor > 0 ? row.valor : row.valor * -1}" type = "currency"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr style="font-weight: 700">
                            <th scope="row">Total Líquido</th>
                            <td></td>
                            <td></td>
                            <c:forEach var="row" items="${result2.rows}">
                                <td><fmt:formatNumber value = "${row.saldo}" type = "currency"/></td>
                            </c:forEach>
                        </tr>
                        <tr style="font-weight: 700">
                            <th scope="row">Total de Entrada</th>
                            <td></td>
                            <td></td>
                            <td><fmt:formatNumber value = "${totalEntrada}" type = "currency"/></td>
                        </tr>
                        <tr style="font-weight: 700">
                            <th scope="row">Total de Saída</th>
                            <td></td>
                            <td></td>
                            <td><fmt:formatNumber value = "${totalSaida}" type = "currency"/></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <script src="js/jquery-3.3.1.min.js"></script>
            <script src="js/popper.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/main.js"></script>
            <script src="js/chart.min.js"></script>
            <script src="js/coreui-chartjs.js"></script>
            <script src="js/coreui-utils.js"></script>
            <script src="js/coreui-main.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    </body>
</html>

