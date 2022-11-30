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
        <?xml version="1.0" ?><svg viewBox="0 0 64 64" class="icon" id="header-logo" xmlns="http://www.w3.org/2000/svg"><title/><g data-name="Layer 10" id="Layer_10"><path d="M20,21a5,5,0,0,0-5,5v1.59L21.59,21Z"/><path d="M16.28,32.31,32.22,16.37a7.48,7.48,0,0,0-3,1.84,9.5,9.5,0,0,1-4.53,2.52l-9.51,9.51A5.13,5.13,0,0,0,16.28,32.31Z"/><path d="M22,40v1a1,1,0,0,0,1,1h1a3,3,0,0,1,3,3v2a1,1,0,0,0,2,0V45a3,3,0,0,1,6,0v6a1,1,0,0,0,2,0V49a3,3,0,0,1,3-3h3a1,1,0,0,0,1-1V39.54A10,10,0,0,1,41,40Z"/><path d="M32.59,34,48,18.63A6,6,0,0,0,46.37,17l-17,17Z"/><path d="M26.59,34,44.41,16.17A5.92,5.92,0,0,0,43,16H41.41l-18,18Z"/><path d="M20,34h.59l18-18H35.41L17.89,33.52A5,5,0,0,0,20,34Z"/><path d="M49,26.44,41.44,34A8,8,0,0,0,49,26.44Z"/><path d="M41,36H20a7,7,0,0,1-4.9-2A5,5,0,0,0,20,38H41a8,8,0,0,0,7.6-5.52A10,10,0,0,1,41,36Z"/><path d="M32,7A25,25,0,1,0,57,32,25,25,0,0,0,32,7ZM51,27v3a10,10,0,0,1-5,8.65V45a3,3,0,0,1-3,3H40a1,1,0,0,0-1,1v2a3,3,0,0,1-6,0V45a1,1,0,0,0-2,0v2a3,3,0,0,1-6,0V45a1,1,0,0,0-1-1H23a3,3,0,0,1-3-3V40a7,7,0,0,1-7-7V26a7,7,0,0,1,7-7h2.46a7.45,7.45,0,0,0,5.33-2.21A9.48,9.48,0,0,1,34.54,14H43a8,8,0,0,1,8,8v4c0,.34,0,.67,0,1Z"/><path d="M32,3A29,29,0,1,0,61,32,29,29,0,0,0,32,3Zm0,56A27,27,0,1,1,59,32,27,27,0,0,1,32,59Z"/><path d="M35.41,34h3.18L49,23.59V22a5.92,5.92,0,0,0-.17-1.41Z"/></g></svg>
        <h1 id="header-title">VILLA</h1></a>
    </header>
    <div id="wrap-container">
        <article>
            <a href="funcionarios.jsp">
                <div class="container">
                    <?xml version="1.0" ?><svg class="icon" style="enable-background:new 0 0 24 24;" version="1.1" viewBox="0 0 24 24" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><g id="info"/><g id="icons"><g id="user"><ellipse cx="12" cy="8" rx="5" ry="6"/><path d="M21.8,19.1c-0.9-1.8-2.6-3.3-4.8-4.2c-0.6-0.2-1.3-0.2-1.8,0.1c-1,0.6-2,0.9-3.2,0.9s-2.2-0.3-3.2-0.9    C8.3,14.8,7.6,14.7,7,15c-2.2,0.9-3.9,2.4-4.8,4.2C1.5,20.5,2.6,22,4.1,22h15.8C21.4,22,22.5,20.5,21.8,19.1z"/></g></g></svg>
                    <p>Funcionários</p>
                </div>
            </a>
            <a href="estoque.jsp">
                <div class="container">
                    <?xml version="1.0" ?><svg class="icon" style="height: 112px;" viewBox="0 0 384 512" xmlns="http://www.w3.org/2000/svg"><path d="M336 64h-80c0-35.3-28.7-64-64-64s-64 28.7-64 64H48C21.5 64 0 85.5 0 112v352c0 26.5 21.5 48 48 48h288c26.5 0 48-21.5 48-48V112c0-26.5-21.5-48-48-48zM96 424c-13.3 0-24-10.7-24-24s10.7-24 24-24 24 10.7 24 24-10.7 24-24 24zm0-96c-13.3 0-24-10.7-24-24s10.7-24 24-24 24 10.7 24 24-10.7 24-24 24zm0-96c-13.3 0-24-10.7-24-24s10.7-24 24-24 24 10.7 24 24-10.7 24-24 24zm96-192c13.3 0 24 10.7 24 24s-10.7 24-24 24-24-10.7-24-24 10.7-24 24-24zm128 368c0 4.4-3.6 8-8 8H168c-4.4 0-8-3.6-8-8v-16c0-4.4 3.6-8 8-8h144c4.4 0 8 3.6 8 8v16zm0-96c0 4.4-3.6 8-8 8H168c-4.4 0-8-3.6-8-8v-16c0-4.4 3.6-8 8-8h144c4.4 0 8 3.6 8 8v16zm0-96c0 4.4-3.6 8-8 8H168c-4.4 0-8-3.6-8-8v-16c0-4.4 3.6-8 8-8h144c4.4 0 8 3.6 8 8v16z"/></svg>
                    <p>Estoque</p>
                </div>
            </a>
            <a href="rentabilidade.jsp">
                <div class="container">
                    <?xml version="1.0" ?><svg class="icon" style="height: 112px;" viewBox="0 0 384 512" xmlns="http://www.w3.org/2000/svg"><path d="M336 0h-288C22.38 0 0 22.38 0 48v416C0 489.6 22.38 512 48 512h288c25.62 0 48-22.38 48-48v-416C384 22.38 361.6 0 336 0zM64 208C64 199.2 71.2 192 80 192h32C120.8 192 128 199.2 128 208v32C128 248.8 120.8 256 112 256h-32C71.2 256 64 248.8 64 240V208zM64 304C64 295.2 71.2 288 80 288h32C120.8 288 128 295.2 128 304v32C128 344.8 120.8 352 112 352h-32C71.2 352 64 344.8 64 336V304zM224 432c0 8.801-7.199 16-16 16h-128C71.2 448 64 440.8 64 432v-32C64 391.2 71.2 384 80 384h128c8.801 0 16 7.199 16 16V432zM224 336c0 8.801-7.199 16-16 16h-32C167.2 352 160 344.8 160 336v-32C160 295.2 167.2 288 176 288h32C216.8 288 224 295.2 224 304V336zM224 240C224 248.8 216.8 256 208 256h-32C167.2 256 160 248.8 160 240v-32C160 199.2 167.2 192 176 192h32C216.8 192 224 199.2 224 208V240zM320 432c0 8.801-7.199 16-16 16h-32c-8.799 0-16-7.199-16-16v-32c0-8.801 7.201-16 16-16h32c8.801 0 16 7.199 16 16V432zM320 336c0 8.801-7.199 16-16 16h-32c-8.799 0-16-7.199-16-16v-32C256 295.2 263.2 288 272 288h32C312.8 288 320 295.2 320 304V336zM320 240C320 248.8 312.8 256 304 256h-32C263.2 256 256 248.8 256 240v-32C256 199.2 263.2 192 272 192h32C312.8 192 320 199.2 320 208V240zM320 144C320 152.8 312.8 160 304 160h-224C71.2 160 64 152.8 64 144v-64C64 71.2 71.2 64 80 64h224C312.8 64 320 71.2 320 80V144z"/></svg>
                    <p>Rentabilidade</p>
                </div>
            </a>
        </article>
    </div>
</body>
</html>