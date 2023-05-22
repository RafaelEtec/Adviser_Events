package servlet;

import dao.usDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/senha-us")
public class SenhaUsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usC = (Usuario) req.getSession().getAttribute("usC");
        String pass = req.getParameter("us-pass"), passC = req.getParameter("us-passC");

        if (pass.equals(passC)) {
            usC.setPass(pass);
            boolean saida = new usDAO().addUser(usC);
            if (saida) {
                req.getRequestDispatcher("optionUS.html").forward(req, resp);
            } else {
                resp.sendRedirect("senhaUS.html");
            }
        } else {
            resp.sendRedirect("senhaUS.html");
        }
    }
}