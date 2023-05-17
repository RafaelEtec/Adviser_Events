package dao;

import model.Assessor;
import model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class asDAO {
    public void addUser(Assessor as) {
        String sql = "INSERT INTO TB_ASSESSOR (as_NOME, as_EMAIl, as_CPF, as_NUM, as_NASC, as_END, as_PASS) VALUES (?,?,?,?,?,?,?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, as.getNome());
            ps.setString(2, as.getEmail());
            ps.setString(3, as.getCpf());
            ps.setString(4, as.getNum());
            ps.setString(5, as.getNasc());
            ps.setString(6, as.getEnd());
            ps.setString(7, as.getPass());
            ps.execute();
            System.out.println("Sucesso no cadastro!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
    }

    public boolean login(String email, String pass) {
        String sql = "SELECT as_PASS FROM tb_ASSESSOR WHERE as_EMAIL = ? AND as_PASS = ?";
        boolean saida = false;
        String resposta = "";
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            System.out.println(email + "\t" + pass);
            if (!email.trim().equals("") && !pass.trim().equals("")) {
                while (rs.next()) {
                    resposta = rs.getString("as_PASS");
                }
                if (resposta.equals(pass)) {
                    saida = true;
                }
                System.out.println(saida);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return saida;
    }

    public Assessor pegaPorEmail(String email) {
        String sql = "SELECT * FROM tb_ASSESSOR WHERE us_ID = ?";
        Assessor ass = new Assessor();
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int as_ID = rs.getInt("as_ID");
                String as_IMG = rs.getString("as_IMG");
                String as_NOME = rs.getString("as_NOME");
                String as_EMAIL = rs.getString("as_EMAIL");
                String as_CPF = rs.getString("as_CPF");
                String as_NUM = rs.getString("as_NUM");
                String as_NASC = rs.getString("as_NASC");
                String as_END = rs.getString("as_END");

                ass = new Assessor(as_ID, as_IMG, as_NOME, as_EMAIL, as_CPF, as_NUM, as_NASC, as_END);
            }
            System.out.println("Sucesso na pesquisa!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return ass;
    }
}