package dao;

import model.Assessor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}