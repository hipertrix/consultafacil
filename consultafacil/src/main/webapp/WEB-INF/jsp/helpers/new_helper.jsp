<%@ include file="/header.jsp" %> 
 

<h2>Novo Atendente</h2>

<hr />

<div class="row">
<div class="col-sm-6">

<form action="${linkTo[HelpersController].add}" method="post" class="form-horizontal">
				<div class="form-group">
					<label class="sr-only" for="login"><fmt:message key="user.login"/></label>
					<input type="text" class="form-control" id="newname" name="user.name" value="${user.name}" placeholder="<fmt:message key="user.name"/>" />
				</div>
				
				
				<div class="form-group">
					<label class="sr-only" for="login"><fmt:message key="user.login"/></label>
					<input type="text" class="form-control" id="newlogin" name="user.login" value="${user.login}" placeholder="<fmt:message key="user.login"/>" />
				</div>
				
				
				
				<div class="form-group">
					<label class="sr-only" for="pwd"><fmt:message key="user.pwd"/></label>
					<input type="password" class="form-control" name="user.pwd" value="${user.pwd}" placeholder="<fmt:message key="user.password"/>" />
				</div>							
				
				<div class="form-group">
					<label class="sr-only" for="phone"><fmt:message key="user.phone"/></label>
					<input type="text" class="form-control" id="newphone" name="user.phone" value="${user.phone}"
					 placeholder="<fmt:message key="user.phone"/>" />
				</div>		
				 
				<div class="form-group">
					<label class="sr-only" for="email"><fmt:message key="user.email"/></label>
					<input type="text" class="form-control" id="newemail" name="user.email" 
					value="${user.email}" placeholder="<fmt:message key="user.email"/>" />
				</div>				
				 
				
				
				
				
				<div class="form-group pull-right">					
					<button type="submit" class="btn btn-large btn-primary">
						<fmt:message key="send"/>
					</button>
				</div>
			</form>
</div>
<div class="col-sm-6">




</div>

</div>

<%@ include file="/footer.jsp" %> 