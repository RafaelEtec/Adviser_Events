package servlet;

import dao.evDAO;
import model.Assessor;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conf-presenca-us")
public class ConfPresAs extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ev_id = Integer.parseInt(req.getParameter("ev_id"));
        Usuario us = (Usuario) req.getSession().getAttribute("us");
        System.out.println(ev_id + "\t" + us.getId() + "\t");
        new evDAO().alterarPresenca(ev_id, us.getId());

        resp.sendRedirect("list-events-us");
    }
}