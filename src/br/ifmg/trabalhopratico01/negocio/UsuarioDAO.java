package br.ifmg.trabalhopratico01.negocio;

import java.sql.*;
import java.util.*;

import br.ifmg.trabalhopratico01.modelo.Medico;
import br.ifmg.trabalhopratico01.modelo.Usuario;

public class UsuarioDAO extends DBConnection {

	private Connection conn;

	public UsuarioDAO() throws SQLException {
		this.conn = getConnection();
	}

	public UsuarioDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}

	public Boolean insertUsuario(Usuario usuario) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("INSERT INTO usuario (Login,Nome,Senha,Tipo) VALUES (?,?,?,?);");
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getTipo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean deleteUsuario(Usuario usuario) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("DELETE FROM usuario WHERE codigo = ?");
			ps.setInt(1, usuario.getCodigo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

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

	public Usuario getUsuarioByLogin(String id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT * FROM usuario WHERE Login = ?;");
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Usuario(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Login"),
						rs.getString("Senha"), rs.getString("Tipo"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}
	
	
	public Usuario getUsuario(int id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT * FROM usuario WHERE codigo = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Usuario(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Login"),
						rs.getString("Senha"), rs.getString("Tipo"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}

	public List<Usuario> getUsuarios() throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			ps = this.conn.prepareStatement("SELECT * FROM usuario ORDER BY login;");
			rs = ps.executeQuery();

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Login"),
						rs.getString("Senha"), rs.getString("Tipo")));
			}

			return usuarios;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
	
	public List<Usuario> getNomeUsuarios(String nome) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			ps = this.conn.prepareStatement("Select * From usuario WHERE Nome like ? ORDER BY Nome;");
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Login"),
						rs.getString("Senha"), rs.getString("Tipo")));
			}

			return usuarios;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

}
