<%@page import="br.ifmg.trabalhopratico01.modelo.Produto"%>
<%@page import="br.ifmg.trabalhopratico01.negocio.ProdutoDAO"%>
<%@page import="br.ifmg.trabalhopratico01.controle.ProdutoControle"%>
<%@page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link type="text/css" rel="stylesheet" href="css/style.css">

  
    <style type="text/css"> 
    
      .container{
                 float: right;
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
   
        ProdutoDAO dao = new  ProdutoDAO();
        List<Produto> produtos;   

   if (request.getParameter("buscar").equals("todos")) {
	     produtos = dao.getProdutos();
	     pageContext.setAttribute("produtos",produtos);
	  }
  else {
    	 produtos = dao.getNomeProdutos(request.getParameter("buscar"));
         pageContext.setAttribute("produtos",produtos);
      }
  
%> 
 
 <div class="col container">
  <form class="col">    
  
       <div class="row">
			<div class="input-field col s12">
				<input id="buscar" type="text" name="buscar" class="validate">
				<label for="buscar">Buscar</label>
			</div>
		</div>
		
  <div class="row">
     <table class="striped" >
        <thead>
          <tr>
              <th data-field="id">Código</th>
              <th data-field="id">Nome</th>
              <th data-field="id">Status</th>
          </tr>
        </thead>
        <tbody>
       
          <c:forEach var="produto" items="${produtos}" varStatus="status"> 
          <tr>
            <td>${produto.codigo}</td>
            <td>${produto.nome}</td>
            <td>${produto.status}</td>
          </tr>
                    
    
          </c:forEach>
        </tbody> 
      </table>   
      </div>
   </form>
 </div>
 
</body>
</html> 
