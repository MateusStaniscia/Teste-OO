package com.exemplo.controllers;

import java.time.LocalDate;
import java.util.List;

import com.exemplo.dao.AlunoDAO;
import com.exemplo.models.Aluno;

import io.javalin.http.Context;

public class AlunoController {

    private static AlunoDAO alunoDAO = new AlunoDAO();

    public static void listarAlunos(Context ctx) {
        List<Aluno> lista = alunoDAO.listarAlunos();
        ctx.json(lista);
    }

    public static void buscarAluno(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Aluno aluno = alunoDAO.buscarAluno(id);
        if (aluno != null) {
            ctx.json(aluno);
        } else {
            ctx.status(404).result("Aluno não encontrado");
        }
    }

    public static void inserirAluno(Context ctx) {
        Aluno aluno = new Aluno();
        aluno.setMatricula(ctx.formParam("matricula"));
        aluno.setNome(ctx.formParam("nome"));
        aluno.setCpf(ctx.formParam("cpf"));
        aluno.setDataNascimento(LocalDate.parse(ctx.formParam("dataNascimento")));
        aluno.setEndereco(ctx.formParam("endereco"));
        aluno.setTelefone(ctx.formParam("telefone"));
        aluno.setEmail(ctx.formParam("email"));

        alunoDAO.inserirAluno(aluno);
        ctx.redirect("/alunos"); 
    }

    public static void excluirAluno(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        alunoDAO.excluirAluno(id);
        ctx.redirect("/alunos");
    }
}
