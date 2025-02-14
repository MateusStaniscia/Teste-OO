package com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exemplo.models.Escola;

public class EscolaDAO {

    public void inserir(Escola escola) {
        String sql = "INSERT INTO escola (nome, endereco, contato) VALUES (?,?,?)";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, escola.getNome());
            ps.setString(2, escola.getEndereco());
            ps.setString(3, escola.getContato());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Escola> listarTodos() {
        List<Escola> lista = new ArrayList<>();
        String sql = "SELECT * FROM escola";
        try (Connection conn = FabricaConexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Escola e = new Escola();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setEndereco(rs.getString("endereco"));
                e.setContato(rs.getString("contato"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Escola buscarPorId(int id) {
        Escola e = null;
        String sql = "SELECT * FROM escola WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Escola();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setEndereco(rs.getString("endereco"));
                e.setContato(rs.getString("contato"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM escola WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
