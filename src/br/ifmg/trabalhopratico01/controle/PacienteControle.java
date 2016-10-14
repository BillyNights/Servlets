package br.ifmg.trabalhopratico01.controle;

import java.sql.SQLException;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Paciente;
import br.ifmg.trabalhopratico01.negocio.PacienteDAO;



public class PacienteControle {
	
	PacienteDAO pacienteDAO;
	  
	  public PacienteControle(){
		  
		  try {
			pacienteDAO = new PacienteDAO();
		} catch (Exception e) {
		     e.printStackTrace();
		}
	  }
	  
	  public Boolean insertPaciente(Paciente paciente) throws SQLException{
		  return pacienteDAO.insertPaciente(paciente);
	  }
	  
	  public Boolean deletePaciente(Paciente paciente) throws SQLException{
		  return pacienteDAO.deletePaciente(paciente);
	  }
	  
	  public Boolean updatePaciente(Paciente Paciente) throws SQLException{
		  return pacienteDAO.updatePaciente(Paciente);
	  }
	  
	  public Paciente getPaciente(int id)  throws SQLException {
		  return pacienteDAO.getPaciente(id);
	  } 
	  
	
	  
	  
	  public List<Paciente> getPacientes() throws SQLException {
		  return pacienteDAO.getPacientes();
	  } 
	  
	
}

