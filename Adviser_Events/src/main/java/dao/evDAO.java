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
    public boolean addEvent(Evento ev) {
        String sql = "INSERT INTO TB_EVENTO (ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASSESSOR, ev_PRESENCAS) VALUES (?,?,?,?,?,?,?)";
        boolean saida = false;
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
            ps.setInt(7, ev.getPre());
            ps.execute();
            saida = true;
            System.out.println("Sucesso no cadastro!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
        return saida;
    }

    public boolean deleteEvent(int ev, int id) {
        String sql = "DELETE tb_EVENTO WHERE ev_ID = ? and ev_ASS = ?";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ev);
            ps.setInt(2, id);
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

    public List<Evento> listEvents() {
        String sql = "SELECT ev_ID, ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASSESSOR, ev_PRESENCAS FROM tb_EVENTO";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Evento> ev = new ArrayList<>();

            while (rs.next()) {
                int ev_ID = rs.getInt("ev_ID");
                String ev_NOME = rs.getString("ev_NOME");
                String ev_DESC = rs.getString("ev_DESC");
                String ev_DATA = rs.getString("ev_DATA");
                String ev_HORA = rs.getString("ev_HORA");
                String ev_LOCAL= rs.getString("ev_LOCAL");
                int ev_ASS = rs.getInt("ev_ASSESSOR");
                int ev_PRE = rs.getInt("ev_PRESENCAS");

                Evento evento = new Evento(ev_ID, ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASS, ev_PRE);
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

    public List<Evento> search(String txt) {
        String sql = "SELECT ev_ID, ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASSESSOR, ev_PRESENCAS FROM tb_EVENTO WHERE ev_NOME LIKE ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txt + "%");
            ResultSet rs = ps.executeQuery();
            List<Evento> ev = new ArrayList<>();

            while (rs.next()) {
                int ev_ID = rs.getInt("ev_ID");
                String ev_NOME = rs.getString("ev_NOME");
                String ev_DESC = rs.getString("ev_DESC");
                String ev_DATA = rs.getString("ev_DATA");
                String ev_HORA = rs.getString("ev_HORA");
                String ev_LOCAL= rs.getString("ev_LOCAL");
                int ev_ASS = rs.getInt("ev_ASSESSOR");
                int ev_PRE = rs.getInt("ev_PRESENCAS");

                Evento evento = new Evento(ev_ID, ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASS, ev_PRE);
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

    public List<Evento> listEventsByAss(int id) {
        String sql = "SELECT ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASSESSOR, ev_PRESENCAS FROM tb_EVENTO WHERE id_ASS = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Evento> ev = new ArrayList<>();

            while (rs.next()) {
                String ev_NOME = rs.getString("ev_NOME");
                String ev_DESC = rs.getString("ev_DESC");
                String ev_DATA = rs.getString("ev_DATA");
                String ev_HORA = rs.getString("ev_HORA");
                String ev_LOCAL= rs.getString("ev_LOCAL");
                int ev_ASS = rs.getInt("ev_ASSESSOR");
                int ev_PRE = rs.getInt("ev_PRESENCAS");

                Evento evento = new Evento(ev_NOME, ev_DESC, ev_DATA, ev_HORA, ev_LOCAL, ev_ASS, ev_PRE);
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

    public boolean conferirPresenca(int id_ev, int id_us) {
        String sql = "SELECT pr_us_id FROM tb_PRESENCAS WHERE pr_ev_id = ? and pr_us_id = ?";
        boolean saida = false;
        int resp;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_ev);
            ps.setInt(2, id_us);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                resp = rs.getInt("pr_us_id");
                if (resp == id_us) {
                    System.out.println("Já tem");
                    excluirPresenca(id_ev, id_us);
                    con.close();
                    return true;
                }
            }
            System.out.println("Não tem");
            criarPresenca(id_ev, id_us);
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
        return saida;
    }

    public void criarPresenca(int id_ev, int id_us) {
        String sql = "INSERT INTO tb_PRESENCAS VALUES (?, ?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_ev);
            ps.setInt(2, id_us);
            ps.execute();
            System.out.println("Sucesso na criação");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na criação!");
        }
    }

    public void excluirPresenca(int id_ev, int id_us) {
        String sql = "DELETE tb_PRESENCAS WHERE pr_ev_id = ? AND pr_us_id = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_ev);
            ps.setInt(2, id_us);
            int l = ps.executeUpdate();
            if (l > 0) {
                System.out.println("Sucesso na exclusão");
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na exclusão");
        }
    }

    public void alterarPresenca(int id_ev, int id_us) {
        String sqlNao = "UPDATE tb_EVENTO SET ev_PRESENCAS = ev_PRESENCAS + 1 WHERE ev_ID = ?";
        String sqlSim = "UPDATE tb_EVENTO SET ev_PRESENCAS = ev_PRESENCAS - 1 WHERE ev_ID = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps;
            if (conferirPresenca(id_ev, id_us)) {
                ps = con.prepareStatement(sqlSim);
                System.out.println("Presença confirmada");
            } else {
                ps = con.prepareStatement(sqlNao);
                System.out.println("Presença cancelada");
            }
            ps.setInt(1, id_ev);
            ps.execute();
            System.out.println("Presença alterada");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
    }
}