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

<title>SD Admin - Login</title>

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">
	<%
		if (request.getAttribute("mensagem") != null) {

			String msg = (String) request.getAttribute("mensagem");
	%>
	
	<div class="alert alert-danger" role="alert">
		<strong>Algo deu Errado! Parece que: </strong> <%=msg%>
	</div>


	<%
		}
	%>
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
				<form method="post" action="login">
					<div class="form-group">
						<div class="form-label-group">
							<input name="email" type="email" id="inputEmail"
								class="form-control" placeholder="EndereÃ§o de Email"
								required="required" autofocus="autofocus"> <label
								for="inputEmail">Endereço de Email</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input name="senha" type="password" id="inputPassword"
								class="form-control" placeholder="Senha" required="required">
							<label for="inputPassword">Senha</label>
						</div>
					</div>

					<button class="btn btn-primary btn-block" type="submit">Login</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="registro">Registrar Conta</a> <a
						class="d-block small" href="forgot-password.jsp">Esqueceu a
						senha?</a>
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
