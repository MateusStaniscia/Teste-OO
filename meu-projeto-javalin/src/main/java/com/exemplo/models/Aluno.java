package com.exemplo.models;

public class Aluno extends Pessoa{

    //Atributos
    private String matricula;

    //Construtor
    public Aluno(String nome, String cpf, String email, String dataNascimento, String endereco, String telefone) {
        super(nome, cpf, email, dataNascimento, endereco, telefone);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}