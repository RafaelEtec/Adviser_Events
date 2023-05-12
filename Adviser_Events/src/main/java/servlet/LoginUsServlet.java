package servlet;

import dao.usDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-us")
public class LoginUsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String us_email = req.getParameter("us-email");
        String us_pass = req.getParameter("us-pass");

        System.out.println(us_email + "\t" + us_pass);
        boolean resposta = new usDAO().login(us_email, us_pass);
        if (resposta) {
            resp.sendRedirect("dashboard.jsp");
        } else {
            resp.sendRedirect("loginUS.html");
            System.out.println("Não foi possível fazer o login");
        }
    }
}