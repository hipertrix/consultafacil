<%@ include file="/header.jsp" %> 

<h1>Novo Médico</h1>


<form action="${linkTo[DoctorsController].add}" method="post" class="form-horizontal">
				<div class="form-group">
					<label class="sr-only" for="login"><fmt:message key="user.login"/></label>
					<input type="text" class="form-control" id="login" name="login" placeholder="<fmt:message key="user.login"/>"/>
				</div>
				<div class="form-group">
					<label class="sr-only" for="pwd"><fmt:message key="user.pwd"/></label>
					<input type="password" class="form-control" name="pwd" placeholder="<fmt:message key="user.password"/>" />
				</div>
				<div class="form-group pull-right">	
					<button type="submit" id="submit" class="btn btn-large btn-primary">
						<fmt:message key="send"/>
					</button>
				</div>	
</form>




<%@ include file="/footer.jsp" %> 