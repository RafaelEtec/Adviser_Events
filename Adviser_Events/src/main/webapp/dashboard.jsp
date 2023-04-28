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
                <c:forEach var="ev" items="${eventos}">
                    <tr>
                        <td>${ev.nome}</td>
                        <td>${ev.desc}</td>
                        <td>${ev.data}</td>
                        <td>${ev.hora}</td>
                        <td>${ev.local}</td>
                        <td>${ev.ass}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <form action="/list-events" method="post">
            <button><a href="dashboard.jsp">Atualizar</a></button>
        </form>
        <button><a href="criaEV.html">Criar Evento</a></button>
    </body>
</html>