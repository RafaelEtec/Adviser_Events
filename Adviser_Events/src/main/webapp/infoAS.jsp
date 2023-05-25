<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/dashAS.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adviser Events</title>
    <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    body {
      font-family: Arial, sans-serif;
      background-color: white;
    }

    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
      text-align: center;
    }

    .profile-image {
      width: 200px;
      height: 200px;
      border-radius: 50%;
      margin: 0 auto;
      margin-bottom: 50px;
    }

    .profile-name {
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .profile-email {
      font-size: 18px;
      margin-bottom: 20px;
    }

    .info-text {
      font-size: 16px;
      margin-top: 40px;
      margin-bottom: 10px;
    }

    .button {
      background-color: #f2f2f2;
      color: black;
      border: none;
      padding: 10px 20px;
      width: 500px;
      text-align: left;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin-bottom: 20px;
      cursor: pointer;
    }

    .buttonE {
      background-color: #f2f2f2;
      color: black;
      border: none;
      padding: 10px 20px;
      width: 500px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin-bottom: 20px;
      cursor: pointer;
    }

    a:link {
        text-decoration: none;
    }

    .button:hover {
      background-color: #e2e2e2;
    }
  </style>
</head>
<body>
<div class="container">
    <img src="/img/defaultPFP.jpg" class="profile-image">
    <div class="profile-name">${as.nome}</div>
    <div class="profile-email">${as.email}</div>
    <div class="info-text">Informacoes</div>
    <a href="#" class="button">Endereco: ${as.end}</a><br>
    <a href="#" class="button">CPF: ${as.cpf}</a><br>
    <a href="#" class="button">Telefone: ${as.num}</a><br>
    <a href="#" class="button">Data de Nascimento: ${as.nasc}</a><br>
    <a href="#" class="button">Gerenciar Conta</a><br>
    <form action="/logout-as" method="get">
        <button type="submit" class="button">Logout</button><br>
    </form>
    <button class="buttonE"><a href="criaEV.html">Criar Evento</a></button>
</div>
<div class="divS">
            <div class="divLogo">
                <form action="/list-events-as" method="get">
                    <button class="btnLogo" type="submit"><img class="logo" src="img/logo.png" alt="Logo Adviser events"></button>
                </form>
                </div>
                <form action="/search-ev-as" method="get">
                    <input class="evP" type="search" id="ev_p" name="ev_p">
                    <button class="btnP" type="submit"><img class="imgP" src="/img/search.png"></img></button>
                </form>
            </div>

            <p class="pTotal">${total} Eventos</p>

            <div class="divPesq">
                <c:forEach var="ev" items="${ev}">
                    <table>
                        <tr>
                            <td></td>
                            <td class="tdData">${ev.data}</td>
                            <td class="tdHora">${ev.hora}Hr</td>
                            <tr>
                                <form action="/info-ev" method="get">
                                <td class="tdImg"><button class="btnInfo" type="submit"><img class="imgEV" src="/img/defaultEV.png"></button></td>
                                </form>
                                <td class="tdNome">${ev.nome}</td>
                                <td class="tdCon">
                                   <form action="/conf-presenca" method="post">
                                   <input type="hidden" id="ev_id" name="ev_id" value="${ev.id}">
                                   <button class="btnPre" type="submit"><img class="imgHeart" src="/img/heart.png"></button>
                                   </form>
                                </td>
                                <td class="tdCom">
                                   <button class="btnCom"><img class="imgCom" src="/img/share.png"></button>
                                </td>
                                <td>
                                    <form action="/delete-ev" method="post">
                                        <input type="hidden" id="ev_id" name="ev_id" value="${ev.id}">
                                        <button class="btnCom" type="submit"><img class="imgCom" src="/img/del.jpg"></button>
                                    </form>
                                </td>
                            </tr>
                            <td></td>
                            <td class="tdLocal">${ev.local}</td>
                            <td class="tdPre">${ev.pre}</td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
</body>
</html>
