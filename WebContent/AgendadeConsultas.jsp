
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.ifmg.trabalhopratico01.modelo.TADListaConsulta"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="br.ifmg.trabalhopratico01.negocio.ConsultaDAO"%>
<%@page import="br.ifmg.trabalhopratico01.modelo.Paciente"%>
<%@page import="br.ifmg.trabalhopratico01.controle.PacienteControle"%>
<%@page import="br.ifmg.trabalhopratico01.modelo.Medico"%>
<%@page import="br.ifmg.trabalhopratico01.controle.MedicoControle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link type="text/css" rel="stylesheet" href="css/style.css">


    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Associação Mão Amiga</title>
</head>

  
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.min.js"></script>
  <script src="js/Style.js"></script>
  <script type="text/javascript">
    //custom JS code
  </script>
      <style type="text/css"> 
    
      .container{float: right;  	
	             width: 90%;
          
         }
    </style>
<header>
      <div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="mdi-navigation-menu"></i></a></div>
      <ul id="nav-mobile" class="side-nav fixed">
        <li class="logo">
               <img src="logo.jpg" alt=""  href="index.jsp" class="circle responsive-img"> 
               <p class="blue-text"><b>Usuário:</b> ${user.nome}</p>
        </li>
      
        <li class="no-padding">
          <ul class="collapsible collapsible-accordion">
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Ambulatório</a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="agendarConsulta.jsp?codigo=0&codigop=0" class="waves-effect waves-light waves-red" >Agendar consulta</a></li>
                  <%
                     Date data1 = null;
                     SimpleDateFormat simpledf = new SimpleDateFormat("yyyy-MM-dd");
                     data1 = new Date(System.currentTimeMillis());  
                     String dataC = "";
               	     dataC = simpledf.format(data1);
               	     pageContext.setAttribute("dataC",dataC);
                  %>
                  <li><a href="AgendadeConsultas.jsp?data=${dataC }" class="waves-effect waves-light waves-red">Agenda de consulta</a></li>
                </ul>
              </div>
            </li>
          
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Gerenciar Cadastros</a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="listadeusuarios.jsp?buscar=todos" class="waves-effect waves-light waves-red">Usuário</a></li>
                  <li><a href="listademedicos.jsp?buscar=todos" class="waves-effect waves-light waves-red">Médico</a></li>
                  <li><a href="listadepacientes.jsp?buscar=todos" class="waves-effect waves-light waves-red">Paciente</a></li>
                  <li><a href="" class="waves-effect waves-light waves-red">Medicamento</a></li>
           
                </ul>
              </div>
            </li>
            
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Logoff</a>
              <div class="collapsible-body">
                <ul>
                <li><a href="LogoffServlet" class="waves-effect waves-light waves-red">Sair</a></li>
                </ul>
              </div>
            </li>
            
          </ul>
        </li> 
      </ul>
 </header>
 <%
 String dataS = "";
 ConsultaDAO con = new ConsultaDAO();
 Date data = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
 dataS = request.getParameter("data");
 pageContext.setAttribute("dataS", dataS);	  
 List<TADListaConsulta> listahoje = con.getConsultasporD(dataS);
 pageContext.setAttribute("listahoje",listahoje);
	  
 data = sdf.parse(dataS);
 Calendar cal = Calendar.getInstance();
 cal.setTime(data);
 cal.add(Calendar.DATE, +1);
 data = cal.getTime();
 dataS = "";
 dataS = sdf.format(data);
	  
 List<TADListaConsulta> listaamanha = con.getConsultasporD(dataS);
 pageContext.setAttribute("listaamanha",listaamanha);
 cal.add(Calendar.DATE, -2);
 data = cal.getTime();
 dataS = "";
 dataS = sdf.format(data);
	  
 List<TADListaConsulta> listaontem = con.getConsultasporD(dataS);
 pageContext.setAttribute("listaontem",listaontem);
 %>
 <div class="col container">
  
  <form action="AgendadeConsultaServlet" method="post" class="col container">
     <div class="row" align="center">
        <label>Agenda de Consultas</label>
     </div>
     <div class="row">
        <div class="col s12">
           <label for="DataPik">Data</label>
           <input id="DataPik" type="date" class="datepicker" name="DataPik"  value="${dataS }">
        </div>
     </div>
     <div class="row">
			<div class="input-field col s12" align="right">
				<a class="waves-effect waves-light waves-green btn"
					onclick="$(this).closest('form').submit()"> <i
					class="mdi-content-send right"></i> Buscar
				</a>
			</div>
		</div>
     <div class="row" id="tables">
        <div class="col s4">
               <table>
                  <caption>Ontem</caption>
                  <thead>
                     <tr>
                        <th data-field="Codigo">Codigo</th>
                        <th data-field="Medico">Medico</th>
                        <th data-field="Paciente">Paciente</th>
                     </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="listaontem" items="${listaontem}" varStatus="status"> 
                        <tr><td>${listaontem.codigo }</td><td>${listaontem.medico }</td><td>${listaontem.paciente}</td></tr>
                     </c:forEach>
                  </tbody>
               </table>
        </div>
        <div class="col s4">
            <table>
                  <caption>Hoje</caption>
                  <thead>
                     <tr>
                        <th data-field="Codigo">Codigo</th>
                        <th data-field="Medico">Medico</th>
                        <th data-field="Paciente">Paciente</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="listahoje" items="${listahoje}" varStatus="status"> 
                        <tr><td>${listahoje.codigo }</td><td>${listahoje.medico }</td><td><a href="preconsulta.jsp?nome=${listahoje.paciente}&codigo=${listahoje.codigo}"/>${listahoje.paciente}</td></tr>
                     </c:forEach>
                  </tbody>
               </table>
        </div>
        <div class="col s4">
            <table>
                  <caption>Amanha</caption>
                  <thead>
                     <tr>
                        <th data-field="Codigo">Codigo</th>
                        <th data-field="Medico">Medico</th>
                        <th data-field="Paciente">Paciente</th>
                     </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="listaamanha" items="${listaamanha}" varStatus="status"> 
                        <tr><td>${listaamanha.codigo }</td><td>${listaamanha.medico }</td><td>${listaamanha.paciente}</td></tr>
                     </c:forEach>
                  </tbody>
               </table>
        </div>
     </div>
  </form>
 </div>   
 <body>
 

    
 </body>
 </html>