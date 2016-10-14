package br.ifmg.trabalhopratico01.controle;

import java.sql.SQLException;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Consulta;
import br.ifmg.trabalhopratico01.modelo.TADListaConsulta;
import br.ifmg.trabalhopratico01.modelo.TADListaPacientesHoje;
import br.ifmg.trabalhopratico01.negocio.ConsultaDAO;

public class ConsultaControle {
   ConsultaDAO consultaDAO;
   
   public ConsultaControle(){
	   try{
		   consultaDAO = new ConsultaDAO();
	   }catch (Exception e) {
		     e.printStackTrace();
		}
   }
   
      public Boolean insertConsulta(Consulta consulta) throws SQLException{
		  return consultaDAO.insertConsulta(consulta);
	  }
	  
	  public Boolean deleteConsulta(Consulta consulta) throws SQLException{
		  return consultaDAO.deleteConsulta(consulta);
	  }
	  
	  public Boolean updateConsulta(Consulta consulta) throws SQLException{
		  return consultaDAO.updateConsulta(consulta);
	  }
	  
	  public Consulta getConsulta(int id)  throws SQLException {
		  return consultaDAO.getConsulta(id);
	  } 
	  
	  public List<Consulta> getConsultas() throws SQLException {
		  return consultaDAO.getConsultas();
	  } 
	  
	  
	  public List<TADListaPacientesHoje> getConsultasporDataMedico(String data,String nome) throws SQLException {
		  return consultaDAO.getConsultasporDataMedico(data,nome);
	  } 
	  
	  
}
