package com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exemplo.models.Disciplina;

public class DisciplinaDAO {

    public void inserirDisciplina(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina (codigo, nome, ementa, carga_horaria, professor_id) VALUES (?,?,?,?,?)";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, disciplina.getCodigo());
            ps.setString(2, disciplina.getNome());
            ps.setString(3, disciplina.getEmenta());
            ps.setInt(4, disciplina.getCargaHoraria());
            ps.setInt(5, disciplina.getProfessorId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Disciplina> listarDisciplinas() {
        List<Disciplina> lista = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        try (Connection conn = FabricaConexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Disciplina d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setCodigo(rs.getString("codigo"));
                d.setNome(rs.getString("nome"));
                d.setEmenta(rs.getString("ementa"));
                d.setCargaHoraria(rs.getInt("carga_horaria"));
                d.setProfessorId(rs.getInt("professor_id"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Disciplina buscarDisciplina(int id) {
        Disciplina d = null;
        String sql = "SELECT * FROM disciplina WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d = new Disciplina();
                d.setId(rs.getInt("id"));
                d.setCodigo(rs.getString("codigo"));
                d.setNome(rs.getString("nome"));
                d.setEmenta(rs.getString("ementa"));
                d.setCargaHoraria(rs.getInt("carga_horaria"));
                d.setProfessorId(rs.getInt("professor_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    public void excluirDisciplina(int id) {
        String sql = "DELETE FROM disciplina WHERE id = ?";
        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
