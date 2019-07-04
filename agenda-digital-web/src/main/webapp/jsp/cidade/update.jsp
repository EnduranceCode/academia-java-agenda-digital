<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Editar cidade existente - Agenda Digital</title>
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
			<div class="offset4 span4">
			
				<form action="<%=request.getContextPath()%>/editar/cidade">
					<fieldset>
						<legend>Editar Cidade</legend>
						<input type="hidden" name="codigo" value="<%=request.getParameter("codigo") %>">
						<label>Cidade</label>
						<input type="text" name="cidade" value="<%=request.getParameter("cidade") %>"
							class="input-xlarge" style="height: 30px" /> <input
							type="submit" value="Enviar" class="btn btn-primary pull-right">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
