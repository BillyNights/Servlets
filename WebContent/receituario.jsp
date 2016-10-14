<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link type="text/css" rel="stylesheet" href="css/style.css">

      <style type="text/css"> 
    
      .container{	
	             width: 78%;
          
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
      <div class="container"><a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only"><i class="mdi-navigation-menu"></i></a></div>
      <ul id="nav-mobile" class="side-nav fixed">
       <li class="logo">
              <a  href="menuMedico.jsp"> <img src="logo.jpg"  class="circle responsive-img"> </a> <br>
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
  </header>

<c:set var="data" value="<%=new java.util.Date()%>" />
<fmt:formatDate type="date" value="${data}" />
<%
   String nome = request.getParameter("nome");
   pageContext.setAttribute("nome", nome);
   
   
%>      
  <nav class="container">
    <div class="container">
      <ul class="hide-on-med-and-down" >
         
         
        <li><a href="atestado.jsp?nome=${nome }" class="waves-effect waves-light btn-large">Atestado Médico</a></li>

      </ul>
    </div>
  </nav>

<div class="col container">    
  <form class="container">
	
	    <div class="row">
		    <label >Paciente ${nome} </label>	
		</div>
		
		<div class="row">
			<div class="input-field col s12">
				    <center> <textarea id="queixa" name="queixa" class="materialize-textarea">
				 
	     			                  ASSOCIAÇÃO MÃO AMIGA 
      		             Associação no combate ao cancêr de Formiga-MG
Rua Lassance Cunha, 39 - Centro - Formiga - MG  TELEFAX : ( 37 ) 3322-3291/8816-7362
    
    	                
    	                                       RECEITUÁRIO MÉDICO 
    ${nome} 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
    
 
                                              
                               ${data}
       
             
             
             ________________________________________________________ 
                              ${user.nome} 	     	
				   </textarea> </center>
				 
			</div>
		</div>
	<div class="row">   
	   <div class="input-field col s6" align="right">
				<a class="waves-effect waves-light waves-green btn"
					onclick="window.print()"> <i
					class="mdi-content-send right"></i> Imprimir
				</a>
			</div>
			
        <div class="input-field col s6" align="right">
				<a href="atendimentos.jsp?nome=${user.nome }" class="waves-effect waves-light waves-green btn"
					> <i
					class="mdi-content-send right"></i> Finalizar
				</a>
		</div>		
		
     </div>			
			<BR><BR><BR><BR>
	   
   </form>
  </div>
 
</body>