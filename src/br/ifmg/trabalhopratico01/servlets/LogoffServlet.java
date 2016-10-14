package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoffServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
	    ResourceBundle messages = (ResourceBundle)session.getAttribute("Saindo do sistema.");

	    // Payment received -- invalidate the session
	    session.invalidate();
	    resp.sendRedirect("index.jsp");
	}
	
}
