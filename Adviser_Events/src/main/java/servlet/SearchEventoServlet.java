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

@WebServlet("/search-ev")
public class SearchEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txt = req.getParameter("ev_p");
        List<Evento> eventos = new evDAO().search(txt);
        int total = eventos.size();
        req.setAttribute("eventos", eventos);
        req.setAttribute("id", req.getSession().getAttribute("as_id"));
        req.setAttribute("total", total);
        req.getRequestDispatcher("dashboardAS.jsp").forward(req, resp);
    }
}