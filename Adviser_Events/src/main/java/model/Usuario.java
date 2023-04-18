package model;

public class Usuario {
    private String nome;
    private String email;
    private String nasc;

    public Usuario() {}

    public Usuario(String nome, String email, String nasc) {
        this.nome = nome;
        this.email = email;
        this.nasc = nasc;
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
}