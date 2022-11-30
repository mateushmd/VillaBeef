<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="imgs/icon.png" type="image/png">
    <title>Login - VillaBeef</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>
    <link href="css/signin.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    
<main class="form-signin w-100 m-auto">
  <form method="POST" action="Login">
      <div class="text-center">
            <div class="mb-4">
                  <?xml version="1.0" ?><svg viewBox="0 0 64 64" class="icon-login" style="width: 50%" xmlns="http://www.w3.org/2000/svg"><title/><g data-name="Layer 10" id="Layer_10"><path d="M20,21a5,5,0,0,0-5,5v1.59L21.59,21Z"/><path d="M16.28,32.31,32.22,16.37a7.48,7.48,0,0,0-3,1.84,9.5,9.5,0,0,1-4.53,2.52l-9.51,9.51A5.13,5.13,0,0,0,16.28,32.31Z"/><path d="M22,40v1a1,1,0,0,0,1,1h1a3,3,0,0,1,3,3v2a1,1,0,0,0,2,0V45a3,3,0,0,1,6,0v6a1,1,0,0,0,2,0V49a3,3,0,0,1,3-3h3a1,1,0,0,0,1-1V39.54A10,10,0,0,1,41,40Z"/><path d="M32.59,34,48,18.63A6,6,0,0,0,46.37,17l-17,17Z"/><path d="M26.59,34,44.41,16.17A5.92,5.92,0,0,0,43,16H41.41l-18,18Z"/><path d="M20,34h.59l18-18H35.41L17.89,33.52A5,5,0,0,0,20,34Z"/><path d="M49,26.44,41.44,34A8,8,0,0,0,49,26.44Z"/><path d="M41,36H20a7,7,0,0,1-4.9-2A5,5,0,0,0,20,38H41a8,8,0,0,0,7.6-5.52A10,10,0,0,1,41,36Z"/><path d="M32,7A25,25,0,1,0,57,32,25,25,0,0,0,32,7ZM51,27v3a10,10,0,0,1-5,8.65V45a3,3,0,0,1-3,3H40a1,1,0,0,0-1,1v2a3,3,0,0,1-6,0V45a1,1,0,0,0-2,0v2a3,3,0,0,1-6,0V45a1,1,0,0,0-1-1H23a3,3,0,0,1-3-3V40a7,7,0,0,1-7-7V26a7,7,0,0,1,7-7h2.46a7.45,7.45,0,0,0,5.33-2.21A9.48,9.48,0,0,1,34.54,14H43a8,8,0,0,1,8,8v4c0,.34,0,.67,0,1Z"/><path d="M32,3A29,29,0,1,0,61,32,29,29,0,0,0,32,3Zm0,56A27,27,0,1,1,59,32,27,27,0,0,1,32,59Z"/><path d="M35.41,34h3.18L49,23.59V22a5.92,5.92,0,0,0-.17-1.41Z"/></g></svg>
            </div>
      </div>
    <h1 class="h3 mb-3 fw-normal">Iniciar Sessão</h1>

    <div class="form-floating">
      <label for="floatingInput">Usuário</label>
      <input type="text" class="form-control" name="usuario" id="floatingInput" placeholder="123.456.789-01">
    </div>
    <div class="form-floating">
      <label for="floatingPassword">Senha</label>
      <input type="password" class="form-control" name="senha" id="floatingPassword" placeholder="Senha">
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
    <p class="text-center" style="padding-top: 1em">
        <c:if test="${not empty errorMessage}">
            <c:out value="${errorMessage}"/>
            <br>
            <c:out value="${errorMessage1}"/>
        </c:if>
    </p>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2022 VillaBeef</p>
  </form>
    
</main>
  </body>
</html>
