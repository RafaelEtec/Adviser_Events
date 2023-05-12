package model;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String nasc;
    private String pass;

    public Usuario() {}

    public Usuario(String nome, String email, String nasc, String pass) {
        this.nome = nome;
        this.email = email;
        this.nasc = nasc;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}