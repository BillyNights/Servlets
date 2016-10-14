<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="br.ifmg.trabalhopratico01.controle.PreconsultaControle"%>
<%@page import="br.ifmg.trabalhopratico01.modelo.Preconsulta"%>


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
  <script type="text/javascript">
    //custom JS code
  </script>
  
<body>



<header>
   <div class="container">
    <div class="section">
     <a href="menuMedico.jsp" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="mdi-navigation-menu"></i></a></div>
      <ul id="nav-mobile" class="side-nav fixed">
        <li class="logo">
               <img src="logo.jpg" class="circle responsive-img"> 
               <p class="blue-text"><b>Usuário:</b> ${user.nome}</p>
        </li>
      
        <li class="no-padding">
          <ul class="collapsible collapsible-accordion">
            <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Menu</a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="atendimentos.jsp?nome=${user.nome}" class="waves-effect waves-light waves-red" >Atendimentos</a></li>
                  <li><a href="buscamedicamento.jsp?buscar=todos" class="waves-effect waves-light waves-red">Buscar Medicamento</a></li>
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
  </div>
 </header>
 <%
    String nome = request.getParameter("nome");
    pageContext.setAttribute("nome", nome);
    
    String codigo = request.getParameter("codigo");
    pageContext.setAttribute("codigo", codigo);
 
    String codAgenda = request.getParameter("codAgenda");
    pageContext.setAttribute("codAgenda", codAgenda);
    
    Preconsulta preconsulta;
    
    PreconsultaControle pac = new PreconsultaControle();
    
    preconsulta = pac.verPreconsulta(Integer.parseInt(codigo));
    
    pageContext.setAttribute("preconsulta",preconsulta);
%> 
    
    
 <div class="col container">
	<form class="col container">

		<div class="row" align="center">
			<label for="login"><h5>Pré-Consulta</h5></label>
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
				<input id="idade" type="text"  name="idade" value="${preconsulta.idade}" > 
			</div>
		</div>


      <div class="row">
			<div class="input-field col s12">
			  <label for="sexo">Sexo</label> <br><br>
				<input id="sexo" type="text"  name="sexo"  value="${preconsulta.sexo}"> 
			</div>
		</div>
		
	   <div class="row">
			<div class="input-field col s6">
			    	<label> Peso </label>
				<input id="peso" type="text"  name="peso" value="${preconsulta.peso}" > 
			</div>
		
		
	
			<div class="input-field col s6">
			    	<label > Altura </label>
				<input id="altura" type="text"  name="altura" value="${preconsulta.altura}"> 
			</div>
		</div>
	
	   <div class="row">
			<div class="input-field col s6">
			    	<label > Tempetatura </label>
				<input id="temperatura" type="text"  name="temperatura" value="${preconsulta.temperatura}"> 
			</div>
		
		
	
			<div class="input-field col s6">
			    	<label > Pressão Arterial</label>
				<input id="pressao" type="text"  name="pressao"  value="${preconsulta.pressao}"> 
			</div>
		</div>
	     
	     <input type="hidden" name="codigo" value="${codigo}" >
	     <input type="hidden" name="nome" value="${nome}" >
	     <input type="hidden" name="codAgenda" value="${codAgenda}" >
		<div class="row">
			  <div class="input-field col s12" align="right">
				<a href="prontuario.jsp?codigo=${codigo}&nome=${nome}&codAgenda=${codAgenda}" class="waves-effect waves-light waves-green btn"
					onclick="$(this).closest('form').submit()"> <i
					class="mdi-content-send right"></i> Avançar
				</a>
			</div>
		</div>

	</form>
</div>

</body>
</html>
  
