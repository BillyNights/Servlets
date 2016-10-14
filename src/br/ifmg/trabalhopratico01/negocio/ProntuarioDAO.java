package br.ifmg.trabalhopratico01.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Prontuario;

public class ProntuarioDAO extends DBConnection {

	private Connection conn;

	public ProntuarioDAO() throws SQLException {
		this.conn = getConnection();
	}

	public ProntuarioDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}

	public Boolean insertProntuario(Prontuario prontuario) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("INSERT INTO prontuario (Queixa,UsoMedicamentos,Pessoais,AnotacoesFinais,Agenda_Codigo) VALUES (?,?,?,?,?);");
			ps.setString(1, prontuario.getQueixa());
			ps.setString(2, prontuario.getUsoMedicamento());
			ps.setString(3, prontuario.getPessoais());
			ps.setString(4, prontuario.getAnotecoesFinais());
			ps.setInt(5, prontuario.getAgenda_codigo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean deleteProntuario(Prontuario prontuario) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("DELETE FROM prontuario WHERE codigo = ?");
			ps.setInt(1, prontuario.getCodigo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}
/*
	public Boolean updateUsuario(Usuario usuario) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn
					.prepareStatement("UPDATE usuario SET Nome = ?,login = ?, Senha = ? , Tipo = ? WHERE Codigo = ?;");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getTipo());
			ps.setInt(5, usuario.getCodigo());

			affectedRows = ps.execute();

		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

*/
	
	
	public Prontuario getProntuario(int id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT * FROM prontuario WHERE codigo = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Prontuario(rs.getInt("Codigo"), rs.getString("Queixa"), rs.getString("UsoMedicamentos"),
						rs.getString("Pessoais"), rs.getString("AnotacoesFinais"),rs.getInt("Agenda_Codigo"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}

	public List<Prontuario> getProntuarios() throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Prontuario> prontuarios = new ArrayList<Prontuario>();

		try {
			ps = this.conn.prepareStatement("SELECT * FROM prontuarios ORDER BY codigo;");
			rs = ps.executeQuery();

			while (rs.next()) {
				prontuarios.add(new Prontuario(rs.getInt("Codigo"), rs.getString("Queixa"), rs.getString("UsoMedicamentos"),
						rs.getString("Pessoais"), rs.getString("AnotacoesFinais"),rs.getInt("Agenda_Codigo")));
			}

			return prontuarios;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

}