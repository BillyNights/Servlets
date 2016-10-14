package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.MedicoControle;
import br.ifmg.trabalhopratico01.modelo.Medico;

public class EditaMedicoServlet extends HttpServlet {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
			 MedicoControle med = new MedicoControle();
	    	 
	    	 try {
	    		 
	    	 Boolean erro = med.updateMedico(new Medico(Integer.parseInt(req.getParameter("codigo")), req.getParameter("nome"), req.getParameter("endereco"), req.getParameter("telefone"), req.getParameter("crm"),req.getParameter("especialidade")));
				
	    	 if(!erro){
	    		  resp.setContentType("text/html");
	    	      resp.sendRedirect("listademedicos.jsp?buscar=todos");
	    	 }
	    	 else resp.sendRedirect("erroBanco.jsp");
	    	 
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("erroBanco.jsp");
			}
	    	    
	    }	
    }