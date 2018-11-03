<%@page import="java.util.ArrayList"
	import="ifsp.StartScienceData.modelo.projeto.Projeto"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="Science Data" content="">
<meta name="Brunno Lemes" name="Carlos Mario" name="Mateus Roncon"
	content="">

<title>SD Admin - Registrar</title>

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">

	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Registrar conta</div>
			<div class="card-body">
				<form>
					<div class="form-group">

						
							<input type="text" id="firstName" name="nome" value="" placeholder="Nome" class="form-control"
								required="required"
								autofocus="autofocus">

						
					</div>

					<div class="form-group">
						
							<input type="text" id="secondName"  name="sobrenome" value="" placeholder="Sobrenome" class="form-control"
								 required="required"
								autofocus="autofocus">
						
					</div>

					<div class="form-group">
						
							<input type="text" id="cpf"  name="cpf" value="" placeholder="CPF" class="form-control"
								required="required"
								autofocus="autofocus">
						
					</div>
					
					<div class="form-group">
						
							<input type="text" id="data" name="data" value="" placeholder="Data de Nascimento" class="form-control"
								required="required"
								autofocus="autofocus">
						
					</div>
					
					<div class="form-group">
							<div class="form-row">
							<div class="col-md-5 mb-3">
							<label for="validationCustom02">Universidade</label> 
							<select name="universidade" class="form-control">
									<option>IFSP</option>
									<option>UNIFESP</option>
								</select>
						</div>
						</div>
								
						
							<div class="form-row">
					
						<div class="col-md-5 mb-3">
							<label for="validationCustom01">Nível</label>
								<select name="nivel" class="form-control">
									<option>Iniciação Científica</option>
									<option>Mestrado</option>
									<option>Doutorado</option>
									<option>Pós-Doutorado</option>
								</select>
						</div>	
					</div>
					</div>


					<div class="form-group">
						
							<input type="email" id="inputEmail" name="email" value="" placeholder="E-mail"
							class="form-control"
								required="required" > 
						
					</div>

					<div class="form-group">
						
							<input type="password" id="inputPassword" name= "senha" value="" placeholder="Senha"
							class="form-control"
							required="required">
						


					</div>
					<a class="btn btn-primary btn-block" href="login.jsp">Registrar</a>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.jsp">Login</a> <a
						class="d-block small" href="forgot-password.jsp">Esqueceu a
						senha ?</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
