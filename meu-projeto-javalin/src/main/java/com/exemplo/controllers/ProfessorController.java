package com.exemplo.controllers;

import java.time.LocalDate;
import java.util.List;

import com.exemplo.dao.ProfessorDAO;
import com.exemplo.models.Professor;

import io.javalin.http.Context;

public class ProfessorController {

    private static ProfessorDAO professorDAO = new ProfessorDAO();

    public static void listarProfessores(Context ctx) {
        List<Professor> lista = professorDAO.listarProfessores();
        ctx.json(lista);
    }

    public static void buscarProfessor(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Professor prof = professorDAO.buscarProfessor(id);
        if (prof != null) {
            ctx.json(prof);
        } else {
            ctx.status(404).result("Professor não encontrado");
        }
    }

    public static void inserirProfessor(Context ctx) {
        Professor prof = new Professor();
        prof.setSiape(ctx.formParam("siape"));
        prof.setNome(ctx.formParam("nome"));
        prof.setCpf(ctx.formParam("cpf"));
        prof.setDataNascimento(LocalDate.parse(ctx.formParam("dataNascimento")));
        prof.setEndereco(ctx.formParam("endereco"));
        prof.setTelefone(ctx.formParam("telefone"));
        prof.setEmail(ctx.formParam("email"));

        professorDAO.inserirProfessor(prof);
        ctx.redirect("/professores");
    }

    public static void excluirProfessor(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        professorDAO.excluirProfessor(id);
        ctx.redirect("/professores");
    }
}
