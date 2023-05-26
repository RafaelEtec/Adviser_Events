<!DOCTYPE html>
<html lang="en">
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

            <div class="divS">
                <form action="/search-ev-us" method="get">
                    <input class="evP" type="search" id="ev_p" name="ev_p">
                    <button class="btnP" type="submit"><img class="imgP" src="/img/search.png"></img></button>
                </form>
            </div>

            <div class="divInfo">
                <form action="/info-us" method="get">
                    <button class="btnInfo" type="submit"><img class="imgFoto" src="/img/defaultPFP.jpg"></img></button>
                </form>
            </div>

            <p class="pTotal">${total} Eventos</p>

            <div class="divPesq">
                <c:forEach var="ev" items="${eventos}">
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
                                   <form action="/conf-presenca-us" method="post">
                                   <input type="hidden" id="ev_id" name="ev_id" value="${ev.id}">
                                   <button class="btnPre" type="submit"><img class="imgHeart" src="/img/heart.png"></button>
                                   </form>
                                </td>
                                <td class="tdCom">
                                   <button class="btnCom"><img class="imgCom" src="/img/share.png"></button>
                                </td>
                            </tr>
                            <td></td>
                            <td class="tdLocal">${ev.local}</td>
                            <td class="tdPre">${ev.pre}</td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
        </header>
    </body>
</html>