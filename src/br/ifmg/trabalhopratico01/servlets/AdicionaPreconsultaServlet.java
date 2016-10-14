package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.PreconsultaControle;
import br.ifmg.trabalhopratico01.modelo.Preconsulta;
;

public class AdicionaPreconsultaServlet extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 Date data1 = null;
     SimpleDateFormat simpledf = new SimpleDateFormat("yyyy-MM-dd");
     data1 = new Date(System.currentTimeMillis());  
     String dataC = "";
	 dataC = simpledf.format(data1);
	    
	
	
			PreconsultaControle pre = new PreconsultaControle();
	    	 
	    	 try {
	    		 
	    	 Boolean erro = pre.insertPreconsulta(new Preconsulta(-1,req.getParameter("idade"),req.getParameter("peso"),req.getParameter("altura"),req.getParameter("temperatura"),
	    			          req.getParameter("sexo"),req.getParameter("pressao"),Integer.parseInt(req.getParameter("codigo"))));
				
	    	 if(!erro){
	    		  resp.setContentType("text/html");
	    	      resp.sendRedirect("AgendadeConsultas.jsp?data="+dataC);
	    	 }
	    	 else resp.sendRedirect("erroBanco.jsp");
	    	 
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("erroBanco.jsp");
			}
	    	    
	    }	
	
}
