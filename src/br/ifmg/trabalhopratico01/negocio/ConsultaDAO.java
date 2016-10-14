package br.ifmg.trabalhopratico01.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Consulta;
import br.ifmg.trabalhopratico01.modelo.Paciente;
import br.ifmg.trabalhopratico01.modelo.TADListaConsulta;
import br.ifmg.trabalhopratico01.modelo.TADListaPacientesHoje;
import javafx.scene.control.Tab;


public class ConsultaDAO extends DBConnection{
	
	private Connection conn;
	
	public ConsultaDAO() throws SQLException{
		this.conn = getConnection();
	}
	
	public ConsultaDAO(Connection conn) throws SQLException{
		this.conn = conn;
	}
	
	public Boolean insertConsulta(Consulta consulta) throws SQLException{
		PreparedStatement ps = null;
		Boolean affectedRows = false;
		
		try{
			ps = this.conn.prepareStatement("INSERT INTO `maoamiga`.`agenda` (`Data`, `Horario`, `TipoConsulta`, `Medico_Codigo`, `Paciente_Codigo`) VALUES (?,?,?,?,?);");
			SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");
			ps.setString(1,sdfr.format(consulta.getDate()));
			ps.setString(2, consulta.getHorario());
			ps.setString(3, consulta.getTipoConsulta());
			ps.setString(4, Integer.toString(consulta.getCodMedico()));
			ps.setString(5, Integer.toString(consulta.getCodPaciente()));
			affectedRows = ps.execute();
		}finally {
			ps.close();
			conn.close();
		}
		
		return affectedRows;
	}

	public Boolean deleteConsulta(Consulta consulta) throws SQLException{
		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("DELETE FROM `maoamiga`.`agenda` WHERE `codigo` = ?");
			ps.setInt(1, consulta.getCodigo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

    public Boolean updateConsulta(Consulta consulta) throws SQLException{
    	PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("UPDATE `maoamiga`.`agenda` SET `Data`=?, `Horario`=?, `TipoConsulta`=?, `Medico_Codigo`=?, `Paciente_Codigo`=? WHERE `Codigo`=?;");
			SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
			ps.setString(1, sdfr.format(consulta.getDate()));			
            ps.setString(2, consulta.getHorario());
			ps.setString(3, consulta.getTipoConsulta());
			ps.setString(4, Integer.toString(consulta.getCodMedico()));
			ps.setString(5, Integer.toString(consulta.getCodPaciente()));

			affectedRows = ps.execute();

		} finally {
			ps.close();
			conn.close();
		}
		return affectedRows;
    }

    public Consulta getConsulta(int id)throws SQLException{
    	PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT * FROM `maoamiga`.`agenda` WHERE codigo = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return new Consulta(rs.getInt("Codigo"), rs.getDate("Data"), rs.getString("Horario"),
						rs.getString("TipoConsulta"), rs.getInt("Medico_Codigo"),rs.getInt("Paciente_Codigo"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}

   
    
    public List<Consulta> getConsultas() throws SQLException{
    	PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		
		try {
			ps = this.conn.prepareStatement("SELECT * FROM `maoamiga`.`agenda`;");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				consultas.add(new Consulta(rs.getInt("Codigo"), rs.getDate("Data"), rs.getString("Horario"),
						rs.getString("TipoConsulta"), rs.getInt("Medico_Codigo"),rs.getInt("Paciente_Codigo")));
			}
			return consultas;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
    }
    
    public List<Consulta> getConsultasporData(String date) throws SQLException{
    	PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		
		try {
			ps = this.conn.prepareStatement("SELECT * FROM maoamiga.agenda WHERE Data = ?;");
			ps.setString(1, date);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				consultas.add(new Consulta(rs.getInt("Codigo"), rs.getDate("Data"), rs.getString("Horario"),
						rs.getString("TipoConsulta"), rs.getInt("Medico_Codigo"),rs.getInt("Paciente_Codigo")));
			}
			return consultas;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
    }
    
    public List<TADListaConsulta> getConsultasporD(String date) throws SQLException{
    	this.conn = getConnection();
    	PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TADListaConsulta> TADlista = new ArrayList<TADListaConsulta>();
		
		try {
			ps = this.conn.prepareStatement("SELECT agenda.Codigo, paciente.Nome, medico.Nome FROM agenda "
					                      + "INNER JOIN paciente ON (agenda.Paciente_Codigo = paciente.Codigo)"
					                      + "INNER JOIN medico ON (agenda.Medico_Codigo = medico.Codigo)"
					                      + "WHERE (agenda.Data = ?);");
			ps.setString(1, date);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				TADListaConsulta aux = new TADListaConsulta(rs.getInt("agenda.Codigo"), rs.getString("medico.Nome"), rs.getString("paciente.Nome"));
				TADlista.add(aux);
			}
			return TADlista;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
    }
    
	public List<TADListaConsulta> ListaTabela(String data) throws SQLException{
		
		MedicoDAO med = new MedicoDAO();
		PacienteDAO pac = new PacienteDAO();
		ConsultaDAO con = new ConsultaDAO();
		List<TADListaConsulta> listaFinal = null;
		
		List<Consulta> listaC = con.getConsultasporData(data);
		
		for(int i=0; i < listaC.size(); i++){
			TADListaConsulta aux = null;
			aux.setCodigo(listaC.get(i).getCodigo());
			aux.setMedico(med.getMedico(listaC.get(i).getCodMedico()).getNome());
			aux.setPaciente(pac.getPaciente(listaC.get(i).getCodPaciente()).getNome());
		    listaFinal.add(aux);
		}
		return listaFinal;
	}
	
	//--------------------------------------------------------------------------------
	
	 public List<TADListaPacientesHoje> getConsultasporDataMedico(String data, String nome) throws SQLException{
	    	PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<TADListaPacientesHoje> lista = new ArrayList<TADListaPacientesHoje>();
			
			try {
				ps = this.conn.prepareStatement("SELECT agenda.Codigo as codAgenda, paciente.Codigo as Codigo, paciente.Nome as Nome , agenda.Horario as Horario FROM agenda" + 
                                                                 " INNER JOIN paciente ON (paciente.Codigo = agenda.Paciente_Codigo)" +
                                                                 " INNER JOIN medico ON (medico.Codigo = agenda.Medico_Codigo)" +
                                                                 " WHERE Data = ? and medico.Nome = ? "+
                                                                  " group by horario;");
				ps.setString(1, data);
				ps.setString(2, nome);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					lista.add(new TADListaPacientesHoje(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Horario"), rs.getString("codAgenda")));
				}
				return lista;

			} finally {
				rs.close();
				ps.close();
				conn.close();
			}
	    }
	 
	 public List<TADListaPacientesHoje> getConsultasporDataPreconsulta(String data) throws SQLException{
	    	PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<TADListaPacientesHoje> lista = new ArrayList<TADListaPacientesHoje>();
			
			try {
				ps = this.conn.prepareStatement("SELECT agenda.Codigo as codAgenda, paciente.Codigo as Codigo, paciente.Nome as Nome , agenda.Horario as Horario FROM agenda" + 
                                                              " INNER JOIN paciente ON (paciente.Codigo = agenda.Paciente_Codigo)" +
                                                              " INNER JOIN medico ON (medico.Codigo = agenda.Medico_Codigo)" +
                                                              " WHERE Data = ? "+
                                                               " group by horario;");
				ps.setString(1, data);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					lista.add(new TADListaPacientesHoje(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Horario"), rs.getString("codAgenda")));
				}
				return lista;

			} finally {
				rs.close();
				ps.close();
				conn.close();
			}
	    }
	
}




