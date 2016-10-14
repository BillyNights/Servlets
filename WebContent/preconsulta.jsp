<%@page import="br.ifmg.trabalhopratico01.negocio.PacienteDAO"%>
<%@page import="br.ifmg.trabalhopratico01.controle.PacienteControle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1" />

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<link type="text/css" rel="stylesheet" href="css/style.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Associação Mão Amiga</title>
</head>


<script type="text/javascript"src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript">
	//custom JS code
</script>

<header>
      <div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="mdi-navigation-menu"></i></a></div>
      <ul id="nav-mobile" class="side-nav fixed">
       <li class="logo">
              <a  href="menuSecretaria.jsp"> <img src="logo.jpg"  class="circle responsive-img"> </a> <br>
               <p class="blue-text"><b>Usuário:</b> ${user.nome}</p> 
        </li>
      
        <li class="no-padding">
          <ul class="collapsible collapsible-accordion">
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Ambulatório</a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="agendarConsulta.jsp?codigo=0&codigop=0" class="waves-effect waves-light waves-red" >Agendar consulta</a></li>
 
                  <%
                     Date data = null;
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                     data = new Date(System.currentTimeMillis());  
                     String dataS = "";
               	     dataS = sdf.format(data);
               	     pageContext.setAttribute("dataS",dataS);
                  %>
                  <li><a href="AgendadeConsultas.jsp?data=${dataS }" class="waves-effect waves-light waves-red">Agenda de consulta</a></li>
                </ul>
              </div>
            </li>
                
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Gerenciar Cadastros</a>
              <div class="collapsible-body">
                <ul>
                <li><a href="listadeusuarios.jsp?buscar=todos" class="waves-effect waves-light waves-red">Usuário</a></li>
                  <li><a href="listademedicos.jsp?buscar=todos" class="waves-effect waves-light waves-red">Médico</a></li>
                  <li><a href="listadepacientes.jsp?buscar=todos" class="waves-effect waves-light waves-red">Paciente</a></li>
                  <li><a href="listademedicamentos.jsp?buscar=todos" class="waves-effect waves-light waves-red">Medicamento</a></li>
           
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
    String nome = request.getParameter("nome");
    pageContext.setAttribute("nome", nome);
    
    String codigo = request.getParameter("codigo");
    pageContext.setAttribute("codigo", codigo);
    
    PacienteDAO dao = new PacienteDAO();
    
    int codigoPac = dao.getPacienteNome(nome);
    
    pageContext.setAttribute("codigoPac", codigoPac);
 %>

<!-- ---------------------------------------------------------- -->

<div class="col container">
	<form action="AdicionaPreconsultaServlet" method="post" class="col container">

		<div class="row" align="center">
			<label for="login"><h5>Pré-Consulta</h5></label>
		</div>

		<div class="row">
			<div class="input-field col s12">
				 <label	for="codigo">Codigo Agendamento:  ${codigo} </label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<label >Nome: ${nome} </label>
			</div>
		</div>
        <br>
		<div class="row">
			<div class="input-field col s12">
			    	<label> Idade </label>
				<input id="idade" type="text"  name="idade" > 
			</div>
		</div>


      <div class="row">
			<div class="input-field col s12">
			  <label for="sexo">Sexo</label> <br><br>
				<select name="sexo" class="browser-default">
				
					<option value="" disabled selected>Selecione Status ...</option>
					<option value="M">Masculino</option>
					<option value="F">Feminino</option>
				</select>
			</div>
		</div>
		
	   <div class="row">
			<div class="input-field col s6">
			    	<label> Peso </label>
				<input id="peso" type="text"  name="peso" > 
			</div>
		
		
	
			<div class="input-field col s6">
			    	<label > Altura </label>
				<input id="altura" type="text"  name="altura" > 
			</div>
		</div>
	
	   <div class="row">
			<div class="input-field col s6">
			    	<label > Tempetatura </label>
				<input id="temperatura" type="text"  name="temperatura" > 
			</div>
		
		
	
			<div class="input-field col s6">
			    	<label > Pressão Arterial</label>
				<input id="pressao" type="text"  name="pressao" > 
			</div>
		</div>
	     
	     <input type="hidden" name="codigo" value="${codigo}" >
	     <input type="hidden" name="nome" value="${nome}" >
		<div class="row">
			  <div class="input-field col s12" align="right">
				<a class="waves-effect waves-light waves-green btn"
					onclick="$(this).closest('form').submit()"> <i
					class="mdi-content-send right"></i> Confirmar
				</a>
			</div>
		</div>

	</form>
</div>

</body>
</html>