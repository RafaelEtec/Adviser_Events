package servlet;

import dao.evDAO;
import model.Assessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-ev")
public class DeleteEv extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idS = req.getParameter("ev_id");
        int id = Integer.parseInt(idS);
        Assessor as = (Assessor) req.getSession().getAttribute("ass");
        new evDAO().deleteEvent(id, as.getId());

        resp.sendRedirect("/list-events-as");
    }
}