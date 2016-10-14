<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link type="text/css" rel="stylesheet" href="css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Associação Mão Amiga. </title>
</head>
<body>


  <!-- jQuery is required by Materialize to function -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="js/materialize.min.js"></script>
  <script type="text/javascript">
    //custom JS code
  </script>
  
 
<div class="container">
  <div class="section">

  <div class="row">
 <form action="LoginServlet" method="post" class="col s12" > 
   <div class="col s16 m2">
     <span class="flow-text">
        <img src="logo.jpg" alt="" class="circle responsive-img"> 
     </span>
  </div>
  
 <div class="col s16 m2">
     <span class="flow-text">
         <label for="login"><h1>Login <h1/></label>
     </span>
  </div>

 
  <div class="col l12 s12 m4">
    <span class="flow-text">
        <div class="row"> 
         <div class="input-field col s6">                                                    
         	<label for="login">Login</label>
      		<input  id="login" type="text" name="login" class="validate"> 
      	</div>
      	</div>
      	  
      	<div class="row"> 
    	 <div class="input-field col s6">   
      		<label for="senha">Senha</label>
      		<input  id="senha" type="password" name="senha" class="validate"> 
  		</div>
  		</div>
  			${param.erro}
  		<div class="row"> 
  		 <div class="input-field col s6">   
     		 <a class="waves-effect waves-light waves-green btn"  onclick="$(this).closest('form').submit()">
     	     <i class="mdi-content-send right"></i> Entrar </a>  	       
  		</div>
  	  </div>
    </form>
    </span>  
   </div>
  </div>
  </div>
 </div>
 
</body>
</html>