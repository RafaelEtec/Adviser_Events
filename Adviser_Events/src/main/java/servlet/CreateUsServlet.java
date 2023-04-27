package servlet;

import dao.usDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-us")
public class CreateUsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String us_nome = req.getParameter("us-nome");
        String us_email = req.getParameter("us-email");
        String us_nasc = req.getParameter("us-nasc");
        String us_pass = "@123";

        Usuario us = new Usuario(us_nome, us_email, us_nasc, us_pass);
        new usDAO().addUser(us);
        req.getRequestDispatcher("optionUS.html").forward(req, resp);
    }
}