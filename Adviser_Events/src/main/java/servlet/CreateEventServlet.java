package servlet;

import model.Assessor;
import model.Evento;
import dao.evDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-ev")
public class CreateEventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ev_nome = req.getParameter("ev-nome");
        String ev_desc = req.getParameter("ev-desc");
        String ev_data = req.getParameter("ev-data");
        String ev_hora = req.getParameter("ev-hora");
        String ev_local = req.getParameter("ev-local");
        Assessor ass = (Assessor) req.getSession().getAttribute("ass");
        int ev_ass = ass.getId();
        int ev_pre = 0;


        Evento ev = new Evento(ev_nome, ev_desc, ev_data, ev_hora, ev_local, ev_ass, ev_pre);
        boolean saida = new evDAO().addEvent(ev);
        if (saida) {
            resp.sendRedirect("list-events-as");
        } else {
            resp.sendRedirect("criaEV.html");
        }
    }
}
