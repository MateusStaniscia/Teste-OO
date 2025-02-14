package com.exemplo.models;

public class Disciplina {
    private int id;
    private String codigo;
    private String nome;
    private String ementa;
    private int cargaHoraria;
    private int professorId; 
 
    public Disciplina() {
    }
    
    public Disciplina(int id, String codigo, String nome, String ementa, int cargaHoraria, int professorId) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.professorId = professorId;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getProfessorId() {
        return professorId;
    }
    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
