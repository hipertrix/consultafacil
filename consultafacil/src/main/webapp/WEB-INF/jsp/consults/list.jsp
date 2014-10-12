<%@ include file="/header.jsp" %> 

	<h2>Consultas 
	
	<span class="pull-right">
		<a href="new_consult" class="btn btn-primary">
		<span class="glyphicon glyphicon-plus"></span> Adicionar</a>
	
	</span>
	</h2>
	<hr />
 
 
 
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr class="info">
			<th></th>
			<th>Data Consutla</th>
			<th> </th>
		</tr>
  	</thead>
  	<tbody>
  	<c:forEach items="${consults}" var="consult">
		<tr>
			<td>
				<a href="#">
					<fmt:message key="view"/>
				</a>
			</td>
			<td>${consult.date}</td>
			<td>${consult.ini_time}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>


<%@ include file="/footer.jsp" %> 