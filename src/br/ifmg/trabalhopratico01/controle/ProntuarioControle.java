package br.ifmg.trabalhopratico01.controle;

import java.sql.SQLException;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Prontuario;
import br.ifmg.trabalhopratico01.negocio.ProntuarioDAO;

public class ProntuarioControle {

	 ProntuarioDAO prontuarioDAO;
	  
	  public ProntuarioControle(){
		  
		  try {
			prontuarioDAO = new ProntuarioDAO();
		} catch (Exception e) {
		     e.printStackTrace();
		}
	  }
	  
	  public Boolean insertProntuario(Prontuario prontuario) throws SQLException{
		  return prontuarioDAO.insertProntuario(prontuario);
	  }
	  
	  public Boolean deleteProntuario(Prontuario prontuario) throws SQLException{
		  return prontuarioDAO.deleteProntuario(prontuario);
	  }
	  
	 /*public Boolean updateProntuario(Prontuario prontuario) throws SQLException{
		  return prontuarioDAO.updateProntuario(prontuario);
	  }*/
	  
	  public Prontuario getProntuario(int id)  throws SQLException {
		  return prontuarioDAO.getProntuario(id);
	  } 
	  
	  public List<Prontuario> getProntuarios() throws SQLException {
		  return prontuarioDAO.getProntuarios();
	  } 
	
}
