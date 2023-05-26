package dao;

import model.Assessor;
import model.Usuario;

import java.sql.*;
import java.util.Collections;

public class usDAO {
    public boolean addUser(Usuario us) {
        String sql = "INSERT INTO tb_USUARIO (us_IMG, us_NOME, us_EMAIL, us_NASC, us_PASS) VALUES (?, ?, ?, ?, ?)";
        boolean saida = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us.getImg());
            ps.setString(2, us.getNome());
            ps.setString(3, us.getEmail());
            ps.setString(4, us.getNasc());
            ps.setString(5, us.getPass());
            ps.execute();
            saida = true;
            System.out.println("Sucesso no cadastro!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
        return saida;
    }

    public boolean login(String email, String pass) {
        String sql = "SELECT us_PASS FROM tb_USUARIO WHERE us_EMAIL = ? AND us_PASS = ?";
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
                    resposta = rs.getString("us_PASS");
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

    public Usuario pegaPorID(int id) {
        String sql = "SELECT * FROM tb_USUARIO WHERE us_ID = ?";
        Usuario us = new Usuario();

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String us_IMG = rs.getString("us_IMG");
                String us_NOME = rs.getString("us_NOME");
                String us_EMAIL = rs.getString("us_EMAIL");
                String us_NASC = rs.getString("us_NASC");

            }
            System.out.println("Sucesso na pesquisa!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return us;
    }

    public boolean excluir(String nome) {
        String sql = "DELETE tb_USUARIO WHERE us_NOME = ?";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);

            int l = ps.executeUpdate();
            if (l > 0) {
                saida = true;
                System.out.println("Sucesso na exclusão");
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na exclusão!");
        }
        return saida;
    }

    public Usuario pegaPorEmail(String email) {
        String sql = "SELECT us_ID, us_IMG, us_NOME, us_EMAIL, as_NASC, as_PASS FROM tb_USUARIO WHERE us_EMAIL = ?";
        Usuario us = new Usuario();
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int us_ID = rs.getInt("us_ID");
                String us_IMG = rs.getString("us_IMG");
                String us_NOME = rs.getString("us_NOME");
                String us_EMAIL = rs.getString("us_EMAIL");
                String us_NASC = rs.getString("us_NASC");
                String us_PASS = rs.getString("us_PASS");

                us = new Usuario(us_ID, us_IMG, us_NOME, us_EMAIL, us_NASC, us_PASS);
            }
            System.out.println("Sucesso na pesquisa!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return us;
    }
}