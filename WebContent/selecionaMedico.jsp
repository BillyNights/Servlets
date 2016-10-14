<%@page import="br.ifmg.trabalhopratico01.modelo.Paciente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="br.ifmg.trabalhopratico01.controle.PacienteControle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link type="text/css" rel="stylesheet" href="css/style.css">

    <style type="text/css"> 
    
      .container{float: right;  	
	             width: 80%;
          
         }
    </style>
    
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Associação Mão Amiga</title>
</head>

  
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.min.js"></script>
  <script type="text/javascript">
    //custom JS code
  </script>

<header>
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
                  <li><a href="" class="waves-effect waves-light waves-red" >Lista de Espera</a></li>
                  <%
                     Date data1 = null;
                     SimpleDateFormat simpledf = new SimpleDateFormat("yyyy-MM-dd");
                     data1 = new Date(System.currentTimeMillis());  
                     String dataC = "";
               	     dataC = simpledf.format(data1);
               	     pageContext.setAttribute("dataC",dataC);
                  %>
                  <li><a href="AgendadeConsultas.jsp?data=${dataC }" class="waves-effect waves-light waves-red">Agenda de consulta</a></li>
                  <li><a href="" class="waves-effect waves-light waves-red">Buscas</a></li>
                </ul>
              </div>
            </li>
       
             <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Gerenciar Cadastros</a>
              <div class="collapsible-body">
                <ul>
                <li><a href="listadeusuarios.jsp" class="waves-effect waves-light waves-red">Usuário</a></li>
                 <li><a href="listademedicos.jsp" class="waves-effect waves-light waves-red">Médico</a></li>
                 <li><a href="listadepacientes.jsp" class="waves-effect waves-light waves-red">Paciente</a></li>
                 <li><a href="listademedicamentos.jsp" class="waves-effect waves-light waves-red">Medicamento</a></li>
           
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
 
 
 <jsp:useBean id="medicoControle" class="br.ifmg.trabalhopratico01.controle.MedicoControle"/>

 <%
   PacienteControle pac = new PacienteControle();
   Paciente paciente = new Paciente();
   paciente.setCodigo(0);
   if(!request.getParameter("codigop").equals("0")){
	   paciente = pac.getPaciente(Integer.parseInt(request.getParameter("codigop")));
   }
   
   pageContext.setAttribute("paciente", paciente);
 %>
 
 <div class="col container">
  <form class="col">    
     <table class="striped" >
        <thead>
          <tr>
              <th data-field="id">Nome</th>
              <th data-field="id">Endereço</th>
              <th data-field="id">Telefone</th>
              <th data-field="id">CRM</th>
              <th data-field="id">Especialidade</th>
          </tr>
        </thead>
        <tbody>
         <c:forEach var="medico" items="${medicoControle.medicos}" varStatus="status"> 
          <tr>
            <td><a href="agendarConsulta.jsp?codigo=${medico.codigo}&codigop=${paciente.codigo}">${medico.nome}</a></td>
            <td>${medico.endereco}</td>
            <td>${medico.telefone}</td>
            <td>${medico.crm}</td>
            <td>${medico.especialidade}</td>
          </tr>
                    
    
          </c:forEach>
      
        </tbody> 
      </table>   
   </form>
  </div>
 
</body>
</html> 