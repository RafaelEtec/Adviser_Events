<!DOCTYPE html>
<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/dash.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
        <title>Adviser Events</title>
    </head>
    <body>
        <header>
            <div class="divLogo">
                <img class="logo" src="img/logo.png" alt="Logo Adviser events">
            </div>


            <div class="divPesq">
                <c:forEach var="ev" items="${eventos}">
                    <table>
                        <tr>
                            <img class="imgEV" src="/img/defaultEV.png">
                            <td class="tdData">${ev.data}</td>
                            <td class="tdHora">${ev.hora}Hr</td>
                            <td>
                               <form action="/conf-presenca" method="post">
                               <input type="hidden" id="ev_id" name="ev_id" value="${ev.id}">
                               <button class="btnPre" type="submit"></button>
                               </form>
                            </td>
                            <td>
                               <button class="btnCom"></button>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdNome">${ev.nome}</td>
                        </tr>
                        <tr>
                            <td class="tdLocal">${ev.local}</td>
                            <td class="tdPre">${ev.pre}</td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
        </header>
        <form action="/list-events-as" method="get">
            <button type="submit">Atualizar</a></button>
        </form>
        <button><a href="criaEV.html">Criar Evento</a></button>
    </body>
</html>