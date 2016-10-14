package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.ProdutoControle;
import br.ifmg.trabalhopratico01.modelo.Produto;



public class EditaProdutoServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        Boolean erro;
		 ProdutoControle pro = new ProdutoControle();
   	 
		 try {
		String aux = req.getParameter("codigo");
		String status = pro.getStatus(Integer.parseInt(req.getParameter("codigo")));	 
		 
		 if (status.equals("S")){

	          erro = pro.updateProduto(new Produto(Integer.parseInt(req.getParameter("codigo")),req.getParameter("nome"),"N"));
		 }
		 
		 else{
			 
			  erro = pro.updateProduto(new Produto(Integer.parseInt(req.getParameter("codigo")),req.getParameter("nome"),"S"));
			 
		 }
		 
		 
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
