package servlet;

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

        req.getRequestDispatcher("prox.html").forward(req, resp);
    }
}