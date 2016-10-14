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
                  <li><a href="" class="waves-effect waves-light waves-red">Buscas</a></li>
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

<!-- ---------------------------------------------------------- -->

<div class="col container">
	<form action="AdicionaPacienteServlet" method="post" class="col container">

		<div class="row" align="center">
			<label for="login"><h5>Cadastro Paciente</h5></label>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<input id="nome" type="text" name="nome" class="validate"> <label
					for="nome">Nome</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<input id="endereco" type="text" name="endereco" class="validate">
				<label for="endereco">Endereço</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s6">
			 <i class="material-icons prefix">phone</i>
				<input id="telefone" type="text"  name="telefone" > <label for="icon_telephone">Telefone</label>
			</div>
		</div>

		    <div class="row">
			<div class="input-field col s6">
				<input id="CPF" type="text" name="CPF" maxlength="11" size="11" length="11" >
			    <label for="CPF"> CPF (sem ponto) </label> <font  color="red">  ${param.erro}</font>
			</div>
			
			<div class="input-field col s6">
			
				<input id="RG" type="text" name="RG" class="RG" maxlength="11" size="11" length="11" >
				<label for="RG">RG (sem ponto)</label>
			</div>
			

		</div>
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