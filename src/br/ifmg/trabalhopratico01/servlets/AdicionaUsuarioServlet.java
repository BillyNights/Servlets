package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.UsuarioControle;
import br.ifmg.trabalhopratico01.modelo.Usuario;

public class AdicionaUsuarioServlet extends HttpServlet {
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		String login = req.getParameter("login");
	    String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");
		String senha2 = req.getParameter("senha2");
		String tipo = req.getParameter("tipo");
		
		if (login.equals("") || senha.equals("") || nome.equals("") || senha2.equals("") || tipo.equals(""))
			resp.sendRedirect("formUsuario.jsp?erro=Campos a serem preenchidos");
		
		else if(!(senha.equals(senha2))) {
			resp.sendRedirect("formUsuario.jsp?erro=senhas não corespondem");
		}
		else {
			 UsuarioControle usu = new UsuarioControle();
	    	 
	    	 try {
	    		 
	    	 Boolean erro = usu.insertUsuario(new Usuario(-1, req.getParameter("nome"), req.getParameter("login"), req.getParameter("senha"), req.getParameter("tipo")));
				
	    	 if(!erro){
	    		  resp.setContentType("text/html");
	    	      resp.sendRedirect("listadeusuarios.jsp?buscar=todos");
	    	 }
	    	 else resp.sendRedirect("erroBanco.jsp");
	    	 
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("erroBanco.jsp");
			}
	    	    
	    }
		
    }
}
