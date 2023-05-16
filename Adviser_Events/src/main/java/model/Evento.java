package model;

public class Evento {
    private int id;
    private String nome;
    private String desc;
    private String data;
    private String hora;
    private String local;
    private int ass;
    private int pre;

    public Evento() {}

    public Evento(int id, String nome, String desc, String data, String hora, String local, int ass, int pre) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.ass = ass;
        this.pre = pre;
    }

    public Evento(String nome, String desc, String data, String hora, String local, int ass, int pre) {
        this.nome = nome;
        this.desc = desc;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.ass = ass;
        this.pre = pre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getAss() {
        return ass;
    }

    public void setAss(int ass) {
        this.ass = ass;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }
}