<%@page import="java.util.ArrayList"
	import="ifsp.StartScienceData.modelo.projeto.Projeto"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="Science Data" content="">
    <meta name="Brunno Lemes" name="Carlos Mario" name="Mateus Roncon" content="">

    <title>SD Admin - Esqueceu a senha?</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Nova senha</div>
        <div class="card-body">
          <div class="text-center mb-4">
            <h4>Esqueceu sua senha?</h4>
            <p>Entre com seu e-mail e siga as instruções para renovar a senha.</p>
          </div>
          <form>
            <div class="form-group">
              
                <input type="email" id="inputEmail" name="email" value="" placeholder="E-mail"
							class="form-control"
								required="required" autofocus="autofocus" > 
                
              
            </div>
            <a class="btn btn-primary btn-block" href="login.html">Nova senha</a>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="register.jsp">Registrar uma conta</a>
            <a class="d-block small" href="login.jsp">Login</a>
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
