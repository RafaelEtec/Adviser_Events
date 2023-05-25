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
import java.util.List;

@WebServlet("/info-as")
public class InfoAss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Assessor as = (Assessor) req.getSession().getAttribute("ass");
        List<Evento> ev = new evDAO().listEventsByAss(as.getId());
        int total = ev.size();
        req.setAttribute("ev", ev);
        req.setAttribute("id", req.getSession().getAttribute("as_id"));
        req.setAttribute("total", total);
        req.setAttribute("as", as);
        req.getRequestDispatcher("infoAS.jsp").forward(req, resp);
    }
}