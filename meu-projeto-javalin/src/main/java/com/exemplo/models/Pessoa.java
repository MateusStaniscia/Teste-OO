package com.exemplo.models;

public class Pessoa {
    
    //Atributos
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;
    private String endereco;
    private String telefone;

    //Constrtutor
    public Pessoa(String dataNascimento, String cpf, String email, String endereco, String nome, String telefone) {
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.dataNascimento = DataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
