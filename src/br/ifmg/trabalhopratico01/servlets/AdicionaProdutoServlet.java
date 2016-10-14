package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.ProdutoControle;
import br.ifmg.trabalhopratico01.modelo.Produto;


public class AdicionaProdutoServlet extends HttpServlet {

	 
		private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			    ProdutoControle pro = new ProdutoControle();
		    	 
		    	 try {
		    		 
		    	 Boolean erro = pro.insertProduto(new Produto(-1, req.getParameter("nome"), req.getParameter("status")));
					
		    	 if(!erro){
		    		  resp.setContentType("text/html");
		    	      resp.sendRedirect("listademedicamentos.jsp?buscar=todos");
		    	 }
		    	 else resp.sendRedirect("erroBanco.jsp");
		    	 
				} catch (Exception e) {
					e.printStackTrace();
					resp.sendRedirect("erroBanco.jsp");
				}
		    	    
		    }	
	
}
