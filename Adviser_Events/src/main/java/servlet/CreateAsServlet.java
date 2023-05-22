package servlet;
import dao.asDAO;
import model.Assessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/create-as")
public class CreateAsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String as_img = null;
        String as_nome = req.getParameter("as-nome");
        String as_email = req.getParameter("as-email");
        String as_cpf = req.getParameter("as-cpf");
        String as_num = req.getParameter("as-num");
        String as_nasc = req.getParameter("as-nasc");
        String as_end = req.getParameter("as-end");
        String as_pass = "";

        Assessor as = new Assessor(as_img, as_nome, as_email, as_cpf, as_num, as_nasc, as_end, as_pass);
        req.getSession().setAttribute("assC", as);
        req.getRequestDispatcher("senhaAS.html").forward(req, resp);
    }
}