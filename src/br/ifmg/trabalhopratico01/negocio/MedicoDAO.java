package br.ifmg.trabalhopratico01.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Medico;
import br.ifmg.trabalhopratico01.modelo.Produto;

public class MedicoDAO extends DBConnection {

	private Connection conn;

	public  MedicoDAO() throws SQLException {
		this.conn = getConnection();
	}

	public MedicoDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}

	public Boolean insertMedico(Medico Medico) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("INSERT INTO Medico (Nome,Endereco,Telefone,CRM,Especialidade) VALUES (?,?,?,?,?);");
			ps.setString(1, Medico.getNome());
			ps.setString(2, Medico.getEndereco());
			ps.setString(3, Medico.getTelefone());
			ps.setString(4, Medico.getCrm());
			ps.setString(5, Medico.getEspecialidade());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean deleteMedico(Medico Medico) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("DELETE FROM Medico WHERE codigo = ?");
			ps.setInt(1, Medico.getCodigo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean updateMedico(Medico Medico) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("UPDATE medico SET Nome = ?,Endereco = ?, Telefone = ? , CRM = ?,  Especialidade = ? WHERE Codigo = ?;");
			ps.setString(1, Medico.getNome());
			ps.setString(2, Medico.getEndereco());
			ps.setString(3, Medico.getTelefone());
			ps.setString(4, Medico.getCrm());
			ps.setString(5, Medico.getEspecialidade());
			ps.setInt(6, Medico.getCodigo());

			affectedRows = ps.execute();

		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}


	
	public Medico getMedico(int id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT * FROM Medico WHERE codigo = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Medico(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Endereco"),
						rs.getString("Telefone"), rs.getString("CRM"),rs.getString("Especialidade"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}

	public List<Medico> getMedicos() throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Medico> Medicos = new ArrayList<Medico>();

		try {
			ps = this.conn.prepareStatement("SELECT * FROM Medico ORDER BY Nome;");
			rs = ps.executeQuery();

			while (rs.next()) {
				Medicos.add(new Medico(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Endereco"),
						rs.getString("Telefone"), rs.getString("CRM"),rs.getString("Especialidade")));
			}

			return Medicos;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

	public List<Medico> getNomeMedicos(String nome) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Medico> medicos = new ArrayList<Medico>();

		try {
			ps = this.conn.prepareStatement("Select * From medico WHERE Nome like ? ORDER BY Nome;");
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				medicos.add(new Medico(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Endereco"),
						rs.getString("Telefone"), rs.getString("CRM"),rs.getString("Especialidade")));
			}

			return medicos;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
}
