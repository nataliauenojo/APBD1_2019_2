package model;

public class Clientes {

    private int id;
    private String nome; 
    private String telefone;


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
