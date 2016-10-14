package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgendadeConsultaServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String aux = req.getParameter("DataPik");
	  if(aux == null){
		  System.out.println("entrei");
		  Date data = null;
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          data = new Date(System.currentTimeMillis());  
          aux = "";
    	  aux = sdf.format(data);
	  }
	  resp.sendRedirect("AgendadeConsultas.jsp?data="+aux);
   }
}
