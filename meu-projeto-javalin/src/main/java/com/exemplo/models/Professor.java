package com.exemplo.models;

public class Professor extends Pessoa{

    //Atributos
    private String siape;
    
    //Construtor
    public Professor(String nome, String cpf, String email, String dataNascimento, String endereco, String telefone) {
        super(nome, cpf, email, dataNascimento, endereco, telefone);
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

}
