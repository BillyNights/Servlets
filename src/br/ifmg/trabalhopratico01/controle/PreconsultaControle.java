package br.ifmg.trabalhopratico01.controle;

import java.sql.SQLException;

import br.ifmg.trabalhopratico01.modelo.Medico;
import br.ifmg.trabalhopratico01.modelo.Preconsulta;
import br.ifmg.trabalhopratico01.negocio.MedicoDAO;
import br.ifmg.trabalhopratico01.negocio.PreconsultaDAO;

public class PreconsultaControle {
        
	 PreconsultaDAO preconsultaDAO;
	  
	   public PreconsultaControle() {
		
		  
		  try {
			preconsultaDAO = new PreconsultaDAO();
		} catch (Exception e) {
		     e.printStackTrace();
		}
	  }
	  
	  public Boolean insertPreconsulta(Preconsulta preconsulta) throws SQLException{
		  return preconsultaDAO.insertPreconsulta(preconsulta);
	  }
	  
	  public Preconsulta verPreconsulta(int id) throws SQLException{
		  return preconsultaDAO.verPreconsulta(id);
	  }
	  
	  
	
}
