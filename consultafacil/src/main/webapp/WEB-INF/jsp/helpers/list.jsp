<%@ include file="/header.jsp" %> 

	<h2>Lista de Atendentes
	
	<span class="pull-right">
		<a href="new_helper" class="btn btn-primary">
		<span class="glyphicon glyphicon-plus"></span> Adicionar</a>
	
	</span>
	</h2>
	<hr />

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr class="info">
			<th></th>
			<th><fmt:message key='user.name'/></th>
			<th><fmt:message key='user.login'/></th>
		</tr>
  	</thead>
  	<tbody>
  	<c:forEach items="${users}" var="user">
		<tr>
			<td>
				<a href="${linkTo[DoctorsController].show(user)}">
					<fmt:message key="view"/>
				</a>
			</td>
			<td>${user.name}</td>
			<td>${user.login}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@ include file="/footer.jsp" %> 