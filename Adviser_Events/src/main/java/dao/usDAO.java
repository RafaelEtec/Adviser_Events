package dao;

import model.Usuario;

import java.sql.*;
import java.util.Collections;

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
        String sql = "";
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
        } catch (Exception ex) {
            System.out.println("Erro na exclusão!");
        }
        return saida;
    }
}