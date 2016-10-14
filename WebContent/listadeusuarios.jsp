<%@page import="br.ifmg.trabalhopratico01.negocio.UsuarioDAO"%>
<%@page import="br.ifmg.trabalhopratico01.modelo.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
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
   
        UsuarioDAO dao = new  UsuarioDAO();
        List<Usuario> usuarios;   

   if (request.getParameter("buscar").equals("todos")) {
	     usuarios = dao.getUsuarios();
	     pageContext.setAttribute("usuarios",usuarios);
	  }
  else {
    	 usuarios = dao.getNomeUsuarios(request.getParameter("buscar"));
         pageContext.setAttribute("usuarios",usuarios);
      }
  
%> 
 
 <div class="col container ">
  <form class="col">    
     <table class="striped" >
        <thead>
          <tr>
              <th data-field="id">Nome </th>
              <th data-field="id">Login</th>
              <th data-field="id">Tipo</th>
              <th data-field="id">Editar</th>
              <th data-field="id">Excluir</th>
          </tr>
        </thead>
        <tbody>
         <c:forEach var="usuario" items="${usuarios}" varStatus="status"> 
          <tr>
            <td>${usuario.nome}</td>
            <td>${usuario.login}</td>
            <td>${usuario.tipo}</td>
            <td><a href="editarUsuario.jsp?codigo=${usuario.codigo}"
             onclick=" return confirm('Clique em Ok para editar.')"> <i class="small material-icons ">edit</i> </a></td>
            
            <td><a href="ExcluirUsuarioServlet?codigo=${usuario.codigo}"
	         onclick=" return confirm('Clique em Ok para excluir.')"> <i class="small material-icons">delete </i> </a> </td>
          </tr>
                    
    
          </c:forEach>
          <tr>
             <br> <br>
             <a class="waves-effect waves-light waves-green btn"  href="formUsuario.jsp">
     	     <i class="right large material-icons">add</i> Novo </a>  
     	  </tr>
     	  <tr>
     	     <br>
     	     <input id="buscar" type="text" name="buscar" class="validate">
				<label for="buscar">Buscar</label>
     	  </tr>
        </tbody> 
      </table>   
   </form>
  </div>
 
</body>
</html> 