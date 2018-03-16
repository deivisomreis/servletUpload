<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Declarações e Atestado</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="shortcut icon" type="image/png" href="https://vignette.wikia.nocookie.net/birdertainment/images/6/64/Favicon.ico/revision/latest?cb=20130412042344&path-prefix=th"/>
</head>
<body>
	<div class="container">
		<p>${error}${status}</p>
		
		<form action="/cadastrar/atestado" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>Cadastrar Atestado / Declaração</legend>
				
				<label>Colaborador</label><input type="text" name="colaborador" required="true" placeholder="Colaborador" class="form-control" ><br/>
				<label>Data do Evento:</label> <input type="date" name="dataEvento" required="true" placeholder="Data do Evento" class="form-control" ><br/>
				<label>Arquivo:</label> <input type="file" name="doc" required="true" placeholder="Atestado / Declaracao" multiple accept=".pdf" class="form-control"><br/>
				<button type="submit">Cadastrar</button>
			</fieldset>
		</form>
</div>
</body>
</html>