package br.ifmg.trabalhopratico01.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Paciente;
import br.ifmg.trabalhopratico01.modelo.Preconsulta;
import sun.net.www.content.text.plain;

public class PreconsultaDAO extends DBConnection {

	private Connection conn;

	public  PreconsultaDAO() throws SQLException {
		this.conn = getConnection();
	}

	public PreconsultaDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}

	public Boolean insertPreconsulta(Preconsulta preconsulta) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("INSERT INTO preconsulta (Peso,Altura,Temperatura,PressaoArterial,Agenda_Codigo,Sexo,Idade) VALUES (?,?,?,?,?,?,?);");
			ps.setString(1, preconsulta.getPeso());
			ps.setString(2, preconsulta.getAltura());
			ps.setString(3, preconsulta.getTemperatura());
			ps.setString(4, preconsulta.getPressao());
			ps.setInt(5, preconsulta.getAgenda_codigo());
			ps.setString(6, preconsulta.getSexo());
			ps.setString(7, preconsulta.getIdade());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	
	public Preconsulta verPreconsulta(int id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT  preconsulta.Codigo,preconsulta.Peso, preconsulta.Altura, preconsulta.Sexo, preconsulta.Idade,"
	                                         +"preconsulta.PressaoArterial, preconsulta.Temperatura, preconsulta.Agenda_Codigo "
                                             +"FROM preconsulta " 
		                                     +"INNER JOIN agenda ON (agenda.Codigo = preconsulta.Agenda_Codigo)"
		                                     +" WHERE (agenda.Paciente_Codigo = ?);");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Preconsulta pre = new Preconsulta();
				pre.setCodigo(rs.getInt("Codigo"));
				pre.setIdade(rs.getString("Idade"));
				pre.setPeso(rs.getString("Peso"));
				pre.setAltura(rs.getString("Altura"));
				pre.setTemperatura(rs.getString("Temperatura"));
				pre.setSexo(rs.getString("Sexo"));
				pre.setPressao(rs.getString("PressaoArterial"));
				pre.setAgenda_codigo(rs.getInt("Agenda_Codigo"));
				
				
				/*pre = new Preconsulta(rs.getInt("Codigo"), rs.getString("Idade"), rs.getString("Peso"),rs.getString("Altura"), rs.getString("Temperatura"),
						rs.getString("Sexo"),rs.getString("PressaoArterial"),
);*/
				
			return pre;	
			}
			
			
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}	

}