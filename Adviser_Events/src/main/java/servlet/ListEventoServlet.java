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

@WebServlet("/list-events")
public class ListEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Evento> eventos = new evDAO().listEvents();
        req.setAttribute("eventos", eventos);
        req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
    }
}