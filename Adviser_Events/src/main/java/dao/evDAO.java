package dao;

import model.Evento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class evDAO {
    public void addEvent(Evento ev) {
        String sql = "INSERT INTO TB_EVENTO (ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASSESSOR) VALUES (?,?,?,?,?,?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ev.getNome());
            ps.setString(2, ev.getDesc());
            ps.setString(3, ev.getData());
            ps.setString(4, ev.getHora());
            ps.setString(5, ev.getLocal());
            ps.setInt(6, ev.getAss());
            ps.execute();
            System.out.println("Sucesso no cadastro!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
    }

    public List<Evento> listEvents() {
        String sql = "SELECT ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASSESSOR FROM tb_EVENTO";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Evento> ev = new ArrayList<>();

            while (rs.next()) {
                String ev_NOME = rs.getString("ev_NOME");
                String ev_DESC = rs.getString("ev_DESC");
                String ev_DATA = rs.getString("ev_DATA");
                String ev_HORA = rs.getString("ev_HORA");
                String ev_LOCAL= rs.getString("ev_LOCAL");
                int ev_ASS = rs.getInt("ev_ASSESSOR");

                Evento evento = new Evento(ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASS);
                ev.add(evento);
            }
            System.out.println("Sucesso na pesquisa!");
            con.close();

            return ev;
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa");
            return Collections.emptyList();
        }
    }
}