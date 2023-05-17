package servlet;

import dao.asDAO;
import model.Assessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-as")
public class LoginAsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String as_email = req.getParameter("as-email");
        String as_pass = req.getParameter("as-pass");

        System.out.println(as_email + "\t" + as_pass);
        boolean resposta = new asDAO().login(as_email, as_pass);
        if (resposta) {
            Assessor ass = new asDAO().pegaPorEmail(as_email);
            req.getSession().setAttribute("ass", ass);
            resp.sendRedirect("list-events-as");
        } else {
            resp.sendRedirect("loginAS.html");
            System.out.println("Não foi possível fazer o login");
        }
    }
}