package servlet;

import dao.evDAO;
import model.Assessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conf-presenca")
public class ConfPresServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ev_id = Integer.parseInt(req.getParameter("ev_id"));
        Assessor ass = (Assessor) req.getSession().getAttribute("ass");
        System.out.println(ev_id + "\t" + ass.getId() + "\t");
        new evDAO().alterarPresenca(ev_id, ass.getId());

        resp.sendRedirect("list-events-as");
    }
}