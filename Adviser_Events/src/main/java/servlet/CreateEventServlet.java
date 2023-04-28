package servlet;

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
        System.out.println(ev_nome);
        String ev_desc = req.getParameter("ev-desc");
        System.out.println(ev_desc);
        String ev_data = req.getParameter("ev-data");
        System.out.println(ev_data);
        String ev_hora = req.getParameter("ev-hora");
        String ev_local = req.getParameter("ev-local");
        int ev_ass = 1;

        Evento ev = new Evento(ev_nome, ev_desc, ev_data, ev_hora, ev_local, ev_ass);
        new evDAO().addEvent(ev);
        resp.sendRedirect("list-events");
    }
}
