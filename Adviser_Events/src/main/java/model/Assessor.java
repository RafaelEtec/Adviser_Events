package model;

public class Assessor {
    private String nome;
    private String email;
    private String cpf;
    private String num;
    private String nasc;
    private String end;

    public Assessor() {}

    public Assessor(String nome, String email, String cpf, String num, String nasc, String end) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.num = num;
        this.nasc = nasc;
        this.end = end;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}