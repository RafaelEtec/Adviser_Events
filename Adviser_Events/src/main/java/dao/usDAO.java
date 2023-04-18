package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class usDAO {
    public void addUser(Usuario us) {
        String sql = "INSERT INTO tb_USUARIO VALUES (?, ?)";

        try {

        } catch (Exception ex) {
            System.out.println("Cadastrado");
        }
    }
}