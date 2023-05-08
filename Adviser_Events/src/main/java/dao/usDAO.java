package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class usDAO {
    public void addUser(Usuario us) {
        String sql = "INSERT INTO tb_USUARIO (us_NOME, us_EMAIL, us_NASC, us_PASS) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us.getNome());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getNasc());
            ps.setString(4, us.getPass());
            ps.execute();
            System.out.println("Sucesso no cadastro!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
    }

    public boolean login(String email, String pass) {
        String sql = "SELECT us_PASS FROM tb_USUARIO WHERE us_EMAIL = ? AND us_PASS = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                return true;
            } else {
                return false;
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return false;
    }
}