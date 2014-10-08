<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="author" content=" "/>
	<meta name="reply-to" content=" "/>
	<meta name="description" content="<fmt:message key="meta.description"/>"/>
	<meta name="keywords" content=" "/>

	<title>Consulta Fácil</title>
	<link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/> 
	
	<script type="text/javascript" src="<c:url value='/js/jquery.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>	
	
    <!--[if lt IE 7]>
	    <script src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE7.js" 
	    	type="text/javascript"></script>
    <![endif]-->
</head>
<body>
    <c:set var="path"><c:url value="/"/></c:set>

	 
	
	<div class="navbar navbar-default">
		<div class="navbar-inner">
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${path}"> Início</a></li>
					<li><a href="${path}"> Sobre o Sistema</a></li>
					<li>
						<a href="${linkTo[UsersController].list}"> 
							Usuários
						</a>
					</li> 
				</ul>
            

				<span class="pull-right ${not empty userInfo.user ? '' : 'hidden'}">
					${userInfo.user.name} (<a href="${linkTo[HomeController].logout}">Sair</a>)
				</span>
			</div>
		</div>
	</div>

	 
    
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
	
	<div id="contentWrap">