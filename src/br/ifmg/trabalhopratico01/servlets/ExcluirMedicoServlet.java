package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.MedicoControle;
import br.ifmg.trabalhopratico01.modelo.Medico;



public class ExcluirMedicoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
   	 MedicoControle med = new MedicoControle();
   	 
   	 try {
   		 
			Boolean erro = med.deleteMedico(new Medico(Integer.parseInt(req.getParameter("codigo")),"","","","",""));
			
			if(!erro){
	    		  resp.setContentType("text/html");
	    	      resp.sendRedirect("listademedicos.jsp?buscar=todos");
	    	 }
	    	 else resp.sendRedirect("erroBanco.jsp");
	    	 
		} catch (Exception e) {
			resp.sendRedirect("erroBanco.jsp");
		}
   	  
   }
}
