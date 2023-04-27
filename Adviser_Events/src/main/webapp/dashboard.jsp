<!DOCTYPE html>
<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="UTF-8">
        <title>Adviser Events</title>
    </head>
    <body>
        <div>
            <h1>Eventos</h1>
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Data</th>
                    <th>Hora</th>
                    <th>Local</th>
                    <th>Assessor</th>
                </tr>
                <c:forEach var="ev" items="${ev}">
                    <tr>
                        <td>${ev.ev_NOME}</td>
                        <td>${ev.ev_DESC}</td>
                        <td>${ev.ev_DATA}</td>
                        <td>${ev.ev_HORA}</td>
                        <td>${ev.ev_LOCAL}</td>
                        <td>${ev.ev_ASSESSOR}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <form action="/list-events" method="get">
            <button><a href="dashboard.jsp">Atualizar</a></button>
        </form>
        <button><a href="criaEV.html">Criar Evento</a></button>
    </body>
</html>