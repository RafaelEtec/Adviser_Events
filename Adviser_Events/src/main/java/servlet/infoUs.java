package servlet;

import model.Assessor;
import model.Evento;
import dao.evDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/info-us")
public class infoUs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario us = (Usuario) req.getSession().getAttribute("us");
        req.setAttribute("id", req.getSession().getAttribute("us_id"));
        req.setAttribute("us", us);
        req.getRequestDispatcher("infoUS.jsp").forward(req, resp);
    }
}