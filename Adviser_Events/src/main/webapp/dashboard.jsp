<!DOCTYPE html>
<html>
    <%@ page contentType="text/html; charset=UTF-8" %>
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
                <table>
                    <c:forEach var="ev" items="${eventos}">
                        <div class="divContent">
                            <tr>
                                <td class="tdImg">#IMAGEM#</td>
                                    <td class="tdData">${ev.data}</td>
                                    <td class="tdHora">${ev.hora}Hr</td>
                                <tr>
                                    <td class="tdNome">${ev.nome}</td>
                                    <td class="tdDesc">${ev.desc}</td>
                                </tr>
                                <tr>
                                    <td class="tdLocal">${ev.local}</td>
                                    <td class="tdPre">${ev.pre}</td>
                                </tr>
                                <td>
                                   <form action="/conf-presenca" method="post">
                                   <input type="hidden" id="id" name="id" value="${ev.id}">
                                   <button type="submit">confirmar</button>
                                </td>
                                <td>
                                   <button>compartilhar</button>
                                </td>
                            </tr>
                        </div>
                    </c:forEach>
                </table>
            </div>
        </header>
        <form action="/list-events-us" method="get">
            <button type="submit">Atualizar</a></button>
        </form>
    </body>
</html>