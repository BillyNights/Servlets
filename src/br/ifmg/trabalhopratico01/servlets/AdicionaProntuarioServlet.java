package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ifmg.trabalhopratico01.controle.ProntuarioControle;

import br.ifmg.trabalhopratico01.modelo.Prontuario;

public class AdicionaProntuarioServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		    ProntuarioControle pro = new ProntuarioControle();
	    	 
	    	 try {
	    		 
	    	 Boolean erro = pro.insertProntuario(new Prontuario(-1, req.getParameter("queixa"), req.getParameter("usoMedicamento"),req.getParameter("pessoais"),req.getParameter("anotacoesFinais"),Integer.parseInt(req.getParameter("codAgenda"))));
				
	    	 if(!erro){
	    		  resp.setContentType("text/html");
	    	      resp.sendRedirect("receituario.jsp?nome="+req.getParameter("nome")); 
	    	 }
	    	 else resp.sendRedirect("erroBanco.jsp");
	    	 
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("erroBanco.jsp");
			}
	    	    
	    }	

	
}
