<%@page import="br.ifmg.trabalhopratico01.modelo.Paciente"%>
<%@page import="br.ifmg.trabalhopratico01.controle.PacienteControle"%>
<%@page import="br.ifmg.trabalhopratico01.modelo.Medico"%>
<%@page import="br.ifmg.trabalhopratico01.controle.MedicoControle"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   MedicoControle med = new MedicoControle();
   Medico medico = new Medico();
   medico.setCodigo(0);
   if(!request.getParameter("codigo").equals("0")){
      medico = med.getMedico(Integer.parseInt(request.getParameter("codigo")));
   }
 
   pageContext.setAttribute("medico",medico);
   
   PacienteControle pac = new PacienteControle();
   Paciente paciente = new Paciente();
   paciente.setCodigo(0);
   if(!request.getParameter("codigop").equals("0")){
	   paciente = pac.getPaciente(Integer.parseInt(request.getParameter("codigop")));
   }
   
   pageContext.setAttribute("paciente", paciente);
%>
<div class="col container">
  
  <form action="AdicionaConsultaServlet" method="post" class="col container">
     <div class="row" align="center">
         <label><h5>Agendar Consulta<h5></label>
     </div>
     <div class="row"> 
        <div class="input-field col s6">
           <input id="Medico" type="text" class="validate" value="${medico.nome }" length="100">
           <label for="Medico">Medico</label>   
           <script type="text/javascript">
             document.getElementById("Medico").onclick = function () {
               location.href = "selecionaMedico.jsp?codigop=${paciente.codigo}";
             };
           </script>
        </div>
        
        <div class="input-field col s6">
           <input id="Paciente" type="text" class="validade" value="${paciente.nome }" length="100">
           <label for="Paciente">Paciente</label>
           <script type="text/javascript">
             document.getElementById("Paciente").onclick = function () {
            	 location.href = "selecionaPaciente.jsp?codigo=${medico.codigo}";
             };
           </script>
        </div>
     </div>
     <div class="row">
        <div class="col s12">
           <label for="Data">Data</label>
           <input id="Data" type="date" class="datepicker" name="Data">

           
         </div>
     </div>
     
     <div class="row">
        <div class="input-field col s3">
           
           <select id="horas" name="horas" class="browser-default">
			  <option  value="" disabled selected>Horas</option>
			  <option value="07">07</option>
			  <option value="08">08</option>
              <option value="09">09</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>   
		   </select>
        </div>
        
        <div class="input-field col s3">
           
           <select id="minutos" name="minutos" class="browser-default">
			  <option  value="" disabled selected>Minutos</option>
			  <option value="00">00</option>
			  <option value="01">01</option>
			  <option value="02">02</option>
			  <option value="03">03</option>
			  <option value="04">04</option>
			  <option value="05">05</option>
			  <option value="06">06</option>
			  <option value="07">07</option>
			  <option value="08">08</option>
              <option value="09">09</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>
              <option value="19">19</option>
              <option value="20">20</option>
              <option value="21">21</option>
              <option value="22">22</option>
              <option value="23">23</option>
              <option value="24">24</option>
              <option value="25">25</option>
              <option value="26">26</option>
              <option value="27">27</option>
              <option value="28">28</option>
              <option value="29">29</option>
              <option value="30">30</option>
              <option value="31">31</option>
              <option value="32">32</option>
              <option value="33">33</option>
              <option value="34">34</option>
              <option value="35">35</option>
              <option value="36">36</option>
              <option value="37">37</option>
              <option value="38">38</option>
              <option value="39">39</option>
              <option value="40">40</option>
              <option value="41">41</option>
              <option value="42">42</option>
              <option value="43">43</option>
              <option value="44">44</option>
              <option value="45">45</option>
              <option value="46">46</option>
              <option value="47">47</option>
              <option value="48">48</option>
              <option value="49">49</option>
              <option value="50">50</option>
              <option value="51">51</option>
              <option value="52">52</option>
              <option value="53">53</option>
              <option value="54">54</option>
              <option value="55">55</option>
              <option value="56">56</option>
              <option value="57">57</option>
              <option value="58">58</option>
              <option value="59">59</option>
                 
		   </select>
        </div>
  
        <div class="input-field col s6">
				<select name="Tipo" class="browser-default">
					<option  value="" disabled selected>Selecione Tipo...</option>
					<option value="C">Curativo</option>
					<option value="G">Consulta em Geral</option>
                    <option value="E">Entrega de Exames</option>
				</select>
	     </div>
     </div>
     <input type="hidden" name="codm" value="${medico.codigo }">
     <input type="hidden" name="codp" value="${paciente.codigo }">
     <input type="hidden" name="dataNormal" value="${daten }">
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

<script>
   $(document).ready(function(){
	   $('.datepicker').pickadate();
   }); 
</script>

</html>