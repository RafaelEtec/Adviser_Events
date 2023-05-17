package servlet;

import dao.evDAO;
import model.Assessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conf-presenca")
public class ConfPresServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ev_id = req.getParameter("ev_id");
        String as_id = "1";
        System.out.println(ev_id + "\t" + as_id);
        boolean saida = new evDAO().alterarPresenca(ev_id, as_id);

        System.out.println(saida);
        resp.sendRedirect("list-events-as");
    }
}