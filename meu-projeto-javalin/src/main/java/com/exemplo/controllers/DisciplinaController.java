package com.exemplo.controllers;

import java.util.List;

import com.exemplo.dao.DisciplinaDAO;
import com.exemplo.models.Disciplina;

import io.javalin.http.Context;

public class DisciplinaController {

    private static DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

    public static void listarDisciplinas(Context ctx) {
        List<Disciplina> lista = disciplinaDAO.listarDisciplinas();
        ctx.json(lista);
    }

    public static void buscarDisciplina(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Disciplina d = disciplinaDAO.buscarDisciplina(id);
        if (d != null) {
            ctx.json(d);
        } else {
            ctx.status(404).result("Disciplina não encontrada");
        }
    }

    public static void inserirDisciplina(Context ctx) {
        Disciplina d = new Disciplina();
        d.setCodigo(ctx.formParam("codigo"));
        d.setNome(ctx.formParam("nome"));
        d.setEmenta(ctx.formParam("ementa"));
        d.setCargaHoraria(Integer.parseInt(ctx.formParam("cargaHoraria")));
        d.setProfessorId(Integer.parseInt(ctx.formParam("professorId")));
        disciplinaDAO.inserirDisciplina(d);

        ctx.redirect("/disciplinas");
    }

    public static void excluirDisciplina(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        disciplinaDAO.excluirDisciplina(id);
        ctx.redirect("/disciplinas");
    }
}
