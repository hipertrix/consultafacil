<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%  
request.setAttribute( "user_type", new String[]{"","Médico","Assistente","Paciente"} );  
%>  

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="author" content=" "/>
	<meta name="reply-to" content=" "/>
	<meta name="description" content="<fmt:message key="meta.description"/>"/>
	<meta name="keywords" content=" "/>

	<title>Consulta Fácil</title>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
      
       
	
    <!--[if lt IE 7]>
	    <script src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE7.js" 
	    	type="text/javascript"></script>
    <![endif]-->
</head>
<body>
    <c:set var="path"><c:url value="/"/></c:set>

	 <c:if test="${not empty userInfo.user}">
	 
	 
	 <nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
							<li class="active"><a href="${linkTo[UsersController].home()}"><span class="glyphicon glyphicon-heart"></span> Consultas</a></li> 
							<li><a href="#"><span class="glyphicon glyphicon-calendar"></span> Agenda</a></li>						
							
							<li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-list-alt"></span> Cadastro
						           <span class="caret"></span></a>
						          <ul class="dropdown-menu" role="menu">
						            <li><a href="${linkTo[DoctorsController].list}"> Médicos</a></li>
						            <li><a href="${linkTo[PatientsController].list}"> Pacientes</a></li>
						            <li><a href="${linkTo[HelpersController].list}"> Atendentes</a></li>						             
						          </ul>
						     </li>	 
							</li> 
						</ul>          
		
						<span class="pull-right ">
							<ul class="nav navbar-nav"> 					        
        					<li><a href=""> <strong>${user_type[userInfo.user.user_type]}</strong>
        					 <span class="glyphicon glyphicon-user"></span> ${userInfo.user.name}</a></li>
							<li><a href=""><span class="glyphicon glyphicon-cog"></span></a></li>
							<li><a href="${linkTo[HomeController].logout}">Sair</a></li>
						</ul>  
						
						 
						</span>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


	  
	
	 </c:if>
	
	
	<c:if test="${empty userInfo.user}">   	
	 </c:if>
	







	 
    
	<c:if test="${not empty errors}">
		<div class="alert alert-danger">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<c:forEach items="${errors}" var="error">
				<b><fmt:message key="${error.category}"/></b> - ${error.message} <br/>
			</c:forEach>
		</div>
	</c:if>
	
	<c:if test="${not empty notice}">
		<div class="alert alert-success"> 
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${notice} 
		</div>
	</c:if>
	
	<div id="contentWrap" class="container">