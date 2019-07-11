<%@page import="com.everis.academia.java.agenda.digital.entity.Cidade"%>
<%@page
	import="com.everis.academia.agenda.digital.business.impl.CidadeBusiness"%>
<%@page
	import="com.everis.academia.agenda.digital.business.inter.ICidadeBusiness"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%!ICidadeBusiness cidadeBusiness = new CidadeBusiness();%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listagem de cidades - Agenda Digital</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css">
</head>
<body>
	<div class="container-fluid">

		<div class="row-fluid">
			<div class="span12">
				<h1>Academia Java</h1>
				<h2>Agenda Digital</h2>
			</div>
		</div>

		<div class="row-fluid">
			<div class="span12">
				<h3>Listagem de Cidades</h3>
				<table class="table">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Cidade</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Cidade cidadeActual : cidadeBusiness.read()) {
						%>
						<tr>
							<td><%=cidadeActual.getCodigo()%></td>
							<td><%=cidadeActual.getNome()%></td>
							<td><a
								href="<%=request.getContextPath()%>/jsp/cidade/update.jsp?codigo=<%=cidadeActual.getCodigo()%>&cidade=<%=cidadeActual.getNome()%>"
								class="btn btn-small btn-success" style="margin-right: 10px">Editar</a><a
								href="<%=request.getContextPath()%>/delete?codigo=1"
								class="btn btn-small btn-danger">Eliminar</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row-fluid">
			<div class="span12">
				<p>
					<a class="btn"
						href="<%=request.getContextPath()%>/jsp/cidade/create.jsp">Inserir
						nova cidade</a>
				</p>
			</div>
		</div>

	</div>
</body>
</html>
