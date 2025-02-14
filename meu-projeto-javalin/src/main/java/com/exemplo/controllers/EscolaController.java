package com.exemplo.controllers;

import com.exemplo.dao.EscolaDAO;
import com.exemplo.models.Escola;

import io.javalin.http.Context;

public class EscolaController {

    private static EscolaDAO escolaDAO = new EscolaDAO();

    public static void inserir(Context ctx) {
        Escola escola = new Escola();
        escola.setNome(ctx.formParam("nome"));
        escola.setEndereco(ctx.formParam("endereco"));
        escola.setContato(ctx.formParam("contato"));

        escolaDAO.inserir(escola);
        ctx.redirect("/escolas");
    }
}
