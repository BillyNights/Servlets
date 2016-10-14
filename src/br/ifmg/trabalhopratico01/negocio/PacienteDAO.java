package br.ifmg.trabalhopratico01.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Medico;
import br.ifmg.trabalhopratico01.modelo.Paciente;

public class PacienteDAO extends DBConnection {

	private Connection conn;

	public  PacienteDAO() throws SQLException {
		this.conn = getConnection();
	}

	public PacienteDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}

	public Boolean insertPaciente(Paciente paciente) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("INSERT INTO paciente (Nome,CPF,RG,Endereco,Telefone) VALUES (?,?,?,?,?);");
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getCpf());
			ps.setString(3, paciente.getRg());
			ps.setString(4, paciente.getEndereco());
			ps.setString(5, paciente.getTelefone());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean deletePaciente(Paciente paciente) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("DELETE FROM paciente WHERE codigo = ?");
			ps.setInt(1, paciente.getCodigo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean updatePaciente(Paciente paciente) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("UPDATE paciente SET Nome = ?, CPF = ?,  RG = ? , Endereco = ?, Telefone = ?  WHERE Codigo = ?;");
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getCpf());
			ps.setString(3, paciente.getRg());
			ps.setString(4, paciente.getEndereco());
			ps.setString(5, paciente.getTelefone());
			ps.setInt(6, paciente.getCodigo());

			affectedRows = ps.execute();

		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	
	
	public Paciente getPaciente(int id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT * FROM paciente WHERE codigo = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new  Paciente(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("CPF"),rs.getString("RG"), rs.getString("Endereco"),
						rs.getString("Telefone"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}

	public int getPacienteNome(String nome) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT codigo FROM paciente WHERE nome = ?;");
			ps.setString(1, nome);
			rs = ps.executeQuery();

			if (rs.next()){
				return rs.getInt("codigo");
			}
			
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		return 0;

	}
	
	
	public List<Paciente> getPacientes() throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Paciente> Pacientes = new ArrayList<Paciente>();

		try {
			ps = this.conn.prepareStatement("SELECT * FROM paciente ORDER BY Nome;");
			rs = ps.executeQuery();

			while (rs.next()) {
				Pacientes.add(new Paciente(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("CPF"),rs.getString("RG"), rs.getString("Endereco"),
						rs.getString("Telefone")));
			}

			return Pacientes;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

	public List<Paciente> getNomePacientes(String nome) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		try {
			ps = this.conn.prepareStatement("Select * From paciente WHERE Nome like ? ORDER BY Nome;");
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				pacientes.add(new Paciente(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("CPF"),rs.getString("RG"), rs.getString("Endereco"),
						rs.getString("Telefone")));
			}

			return pacientes;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
}
