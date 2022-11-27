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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
    <body>
        <header>
            <a href="menuGerencia.html">
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
              <th scope="col">Nome</th>
              <th scope="col">Ocupação</th>
              <th scope="col">Contato</th>
              <th scope="col">Formação</th>
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
              <td>Mateus Henrique</td>
              <td>Gerente</td>
              <td>+63 983 0962 971</td>
              <td>NY University</td>
            </tr>
            <tr>
              <th scope="row">
                <label class="control control--checkbox">
                  <input type="checkbox"/>
                  <div class="control__indicator"></div>
                </label>
              </th>
              <td>002</td>
              <td>Gustavo Henrique</td>
              <td>Graphic Designer</td>
              <td>+02 020 3994 929</td>
              <td>London College</td>
            </tr>
            <tr>
              <th scope="row">
                <label class="control control--checkbox">
                  <input type="checkbox"/>
                  <div class="control__indicator"></div>
                </label>
              </th>
              <td>003</td>
              <td>Sofia Luiz</td>
              <td>Caixa</td>
              <td>+01 352 1125 0192</td>
              <td>Senior High</td>
            </tr>
            <tr>
              <th scope="row">
                <label class="control control--checkbox">
                  <input type="checkbox"/>
                  <div class="control__indicator"></div>
                </label>
              </th>
              <td>004</td>
              <td>Davi Assunção</td>
              <td>Funcionário</td>
              <td>+92 020 3994 929</td>
              <td>College</td>
            </tr>
          </tbody>
        </table>
        <div id="commands">
          <p class="commands-text" onclick="document.getElementById('cadastroFun').classList.toggle('visible')" id="commands-cadastrar">Cadastrar</p>
          <p class="commands-text">Editar</p>
          <p class="commands-text">Remover</p>
        </div>
      </div>
      <div class="modal modal-wrap" id="cadastroFun">
        <div class="wrap">
          <form>
              <div class="form-body">
                  <fieldset>
                      <legend><i class="fa fa-user"></i> Cadastrar Venda</legend>
                      <label for="id">ID</label>
                      <input type="text" id="id" name="id" required="">
                      <label for="data">Data</label>
                      <input type="text" id="cpf" name="cpf" required="" placeholder="123.456.789-01">
                      <label for="address">Conta Bancária</label>
                      <input type="text" id="conta" name="conta" required="">
                      <label for="funcao">Função</label>
                      <select id="funcao" name="funcao" required="">
                          <option value=""></option>
                          <option value="AL">Gerente</option>
                          <option value="AK">Caixa</option>
                          <option value="AZ">Funcionário</option>
                      </select>
                      <label for="zip">Salário</label>
                      <input type="number" id="zip" name="zip" required="">
                  </fieldset>
              </div>
              <div class="form-footer">
                  <input type="submit" value="Cadastrar">
                  <p class="btn-cancelar" onclick="document.getElementById('cadastroFun').classList.toggle('visible')">Cancelar</p>
              </div>
          </form>
        </div>
      </div>
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    </body>
</html>
