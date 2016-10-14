package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.UsuarioControle;
import br.ifmg.trabalhopratico01.modelo.Usuario;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		if (login == null  || senha ==null)
			resp.sendRedirect("login.jsp?erro=Senha ou usuario invalido");
		else{
			UsuarioControle uc = new UsuarioControle();
			try {
				Usuario user = uc.login(login, senha);
				if(user != null){
					if(user.getTipo().equals("S")){
					   req.getSession().setAttribute("user", user);
					   resp.sendRedirect("menuSecretaria.jsp");
					} else if(user.getTipo().equals("M")){
						req.getSession().setAttribute("user", user);
						req.getSession().setAttribute("nome", user.getNome());
						resp.sendRedirect("menuMedico.jsp");
					}
				} else resp.sendRedirect("login.jsp?erro=Senha ou usuario invalido");
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
