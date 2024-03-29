package servlet;

import model.Evento;
import dao.evDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-events-us")
public class ListEventoServletUS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Evento> eventos = new evDAO().listEvents();
        int total = eventos.size();
        req.setAttribute("eventos", eventos);
        req.setAttribute("id", req.getSession().getAttribute("us_id"));
        req.setAttribute("total", total);
        req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
    }
}