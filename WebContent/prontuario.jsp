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

 
  <% 
  
  
    String nome = request.getParameter("nome");
    pageContext.setAttribute("nome", nome);
    
    String codigo = request.getParameter("codigo");
    pageContext.setAttribute("codigo", codigo);
  
    String codAgenda= request.getParameter("codAgenda");
    pageContext.setAttribute("codAgenda", codAgenda);
  %>
    
  <nav class="container">
    <div class="container">
      <ul class="hide-on-med-and-down" >
        
        
        
      </ul>
    </div>
  </nav>
  
  

  
  
<div class="col container">    
  <form action="AdicionaProntuarioServlet" method="post" class="container">
	
	    <div class="row">
		    <label >Paciente ::  ${nome} </label>	
		</div>
		
		<div class="row">
			<div class="input-field col s12">
				  <textarea id="queixa" name="queixa" class="materialize-textarea" length="1000" ></textarea> 
				  <label for="queixa">Principal Queixa</label>
			</div>
		</div>
		
	
		
        <div class="row">
			<div class="input-field col s6">
			 <label for="usoMedicamento">Uso Medicamentos</label><br><br>
				<select name="usoMedicamento" class="browser-default">
					<option  value="" disabled selected ">Selecione...</option>
					<option value="S">Sim</option>
					<option value="N">Não</option>
				</select>
			</div>
		
	
			<div class="input-field col s6">
			  <textarea id="pessoais" name="pessoais" class="materialize-textarea" length="50" ></textarea> 
				  <label for="pessoais">Pessoais</label>
			</div>
			
		</div>
		
		<div class="row">
			<div class="input-field col s12">
				  <textarea id="anotacoesFinais" name="anotacoesFinais" class="materialize-textarea" length="500" ></textarea> 
				  <label for="anotacoesFinais">Anotações Finais</label>
			</div>
		</div>
		<div class="row">
			  <div class="input-field col s6" align="right">
				<a href="verPreconsulta.jsp?codigo=${codigo}&nome=${nome}&codAgenda=${codAgenda}" class="waves-effect waves-light waves-green  btn"
					onclick="$(this).closest('form').submit()"> <i
					class="material-icons left"></i> Pré Consulta
				</a>
			</div>
			
			  <input type="hidden" name="codigo" value="${codigo}" >
			  <input type="hidden" name="nome" value="${nome}" >
			  <input type="hidden" name="codAgenda" value="${codAgenda}" >
			  
			  <div class="input-field col s6" align="right">
				<a class="waves-effect waves-light waves-green btn"
					onclick="$(this).closest('form').submit()"> <i
					class="mdi-content-send right"></i> Confirmar
				</a>
			</div>
			
		</div>
     
   </form>
  </div>
 
</body>
