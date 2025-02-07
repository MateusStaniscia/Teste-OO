package com.exemplo.models;

public class Disciplina {
    
    //Atributos
    private String codigo;
    private String nome;
    private String ementa;
    private double cargaHoraria;
    private String responsavel;

    //Construtor
    public Disciplina(double cargaHoraria, String codigo, String ementa, String nome, String responsavel) {
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.ementa = ementa;
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
}
