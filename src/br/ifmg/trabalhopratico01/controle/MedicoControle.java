package br.ifmg.trabalhopratico01.controle;

import java.sql.SQLException;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Medico;
import br.ifmg.trabalhopratico01.negocio.MedicoDAO;

public class MedicoControle {
	
	 MedicoDAO medicoDAO;
	  
	  public MedicoControle(){
		  
		  try {
			medicoDAO = new MedicoDAO();
		} catch (Exception e) {
		     e.printStackTrace();
		}
	  }
	  
	  public Boolean insertMedico(Medico Medico) throws SQLException{
		  return medicoDAO.insertMedico(Medico);
	  }
	  
	  public Boolean deleteMedico(Medico Medico) throws SQLException{
		  return medicoDAO.deleteMedico(Medico);
	  }
	  
	  public Boolean updateMedico(Medico Medico) throws SQLException{
		  return medicoDAO.updateMedico(Medico);
	  }
	  
	  public Medico getMedico(int id)  throws SQLException {
		  return medicoDAO.getMedico(id);
	  } 
	  
	  public List<Medico> getMedicos() throws SQLException {
		  return medicoDAO.getMedicos();
	  } 
	  
	
}
