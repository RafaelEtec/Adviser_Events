package servlet;

import dao.asDAO;
import model.Assessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/senha-as")
public class SenhaAsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Assessor assC = (Assessor) req.getSession().getAttribute("assC");
        String pass = req.getParameter("as-pass"), passC = req.getParameter("as-passC");

        if (pass.equals(passC)) {
            assC.setPass(pass);
            boolean saida = new asDAO().addUser(assC);
            if (saida) {
                req.getRequestDispatcher("optionAS.html").forward(req, resp);
            } else {
                resp.sendRedirect("senhaAS.html");
            }
        } else {
            resp.sendRedirect("senhaAS.html");
        }
    }
}