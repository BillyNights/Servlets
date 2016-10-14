package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.ConsultaControle;
import br.ifmg.trabalhopratico01.modelo.Consulta;

public class AdicionaConsultaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String configData(String data){
		int pos = 0;
		pos = data.indexOf(" ");
		int pos2 =0;
		String dia ="";
		dia = data.substring(0,pos);
		if(dia.length() == 1){
			dia="0"+dia;
		}
		pos++;
		pos2=data.indexOf(",");
		String mes=data.substring(pos,pos2);
		pos2++;
		pos2++;
		String ano= data.substring(pos2,data.length());
		
		String mesNum="";
		
		switch (mes) {
		   case "January": mesNum="01";
		                   break;
		   case "February": mesNum="02";
		                    break;
		   case "March": mesNum="03";
		                 break;
		   case "April": mesNum="04";
		                 break; 
		   case "May": mesNum="05";
	                   break;
		   case "June": mesNum="06";
		                break;
		   case "July": mesNum="07";
		                break;
		   case "August": mesNum="08";
		                  break;
		   case "September": mesNum="09";
		                     break;
		   case "October": mesNum="10";
		                   break;
		   case "November": mesNum="11";
		                    break;
		   case "December": mesNum="12";
		                    break;
		}
		
		String FinalDate = ano+"-"+mesNum+"-"+dia;
		
		return FinalDate;
	}
   
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  ConsultaControle con = new ConsultaControle();
	  String aux = "";
	  aux=req.getParameter("horas")+":"+req.getParameter("minutos");
	  try{
		  SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		  String data = configData(req.getParameter("Data"));  
		  java.util.Date dateDB = fmt.parse(data);
		  java.sql.Date dataSql = new java.sql.Date(dateDB.getTime());
		  Boolean erro = con.insertConsulta(new Consulta(-1,dataSql ,req.getParameter("Tipo") , aux, Integer.parseInt(req.getParameter("codm")), Integer.parseInt(req.getParameter("codp"))));
		  if(!erro){
    		  resp.setContentType("text/html");
    	      resp.sendRedirect("menuSecretaria.jsp");
    	 }
    	 else resp.sendRedirect("erroBanco.jsp");
    	 
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("erroBanco.jsp");
		}
	  }
}
