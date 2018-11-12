<%@page import="ifsp.StartScienceData.modelo.usuario.Usuario"%>
<%@page import="java.util.ArrayList"
	import="ifsp.StartScienceData.modelo.projeto.Projeto" 
	import="ifsp.StartScienceData.modelo.universidade.Universidade"%>
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

<title>StartScienceDate</title>

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

<!--    //////////////////////////// CPF          -->
<% 
  Usuario user1 = null;
  	if(request.getAttribute("UserLogado")!=null){
  		user1 = (Usuario) request.getAttribute("UserLogado");
  	}else{
  		if(session.getAttribute("UserLogado")!=null){
  			user1 = (Usuario) session.getAttribute("UserLogado");
  		}
  	}
  
 
    if(user1!=null){
    	session.setAttribute("UserLogado", user1); 
    
    }else{
  	  response.sendRedirect("login");
    }
%>
  		
  	



<script>

function formatar(mascara, documento){
	  var i = documento.value.length;
	  var saida = mascara.substring(0,1);
	  var texto = mascara.substring(i)
	  
	  if (texto.substring(0,1) != saida){
				documento.value += texto.substring(0,1);
	  }
	  

	}
	
	</script>


</head>

<body class="bg-dark">

<%
	Usuario user = new Usuario();
	if(request.getAttribute("user")!=null){
		user = (Usuario) request.getAttribute("user");
	}else{
		response.sendRedirect("index.jsp");
	}


%>

	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Alterar conta</div>
			<div class="card-body">
				<form method="post" action="painel">
					<div class="form-group">

						
						<div class="form-group">
						
							<input type="hidden" id="inputEmail" name="email" value="<%=user.getEmail()%>" placeholder="E-mail"
							class="form-control"
								required="required">
						
							<input type="email" id="inputEmail"  value="<%=user.getEmail()%>" placeholder="E-mail"
							class="form-control"
								required="required" disabled="disabled""> 
						
							</div>
						
							<input type="text" id="firstName" name="nome" value="<%=user.getNome()%>" placeholder="Nome" class="form-control"
								required="required"
								autofocus="autofocus">

						
					</div>

					<div class="form-group">
						
							<input type="text" id="secondName"  name="sobrenome" value="<%=user.getSobreNome()%>" placeholder="Sobrenome" class="form-control"
								 required="required"
								autofocus="autofocus">
						
					</div>

					<div class="form-row">
					
						<div class="col-md-6 mb-3">
						
							<input type="text" id="cpf"  name="cpf" value="<%=user.getCpf()%>" placeholder="CPF" maxlength="14" OnKeyPress="formatar('###.###.###-##', this);" class="form-control"
								required="required"
								autofocus="autofocus" disabled="disabled">
						
					</div>
					
					<div class="col-md-6 mb-3">
						
							<input type="date" id="data" name="data" value="<%=user.getData()%>" placeholder="Data de Nascimento" class="form-control"
								required="required"
								autofocus="autofocus">
						
					</div>
					</div>
					
					<div class="form-row">
					
						<%
						String nivel = "";
						switch(user.getNivel()){
						case 1:
							nivel = "Iniciação Cientifica";
							break;
						case 2:
							nivel = "Mestrado";
							break;
						case 3:
							nivel = "Doutorado";
							break;
						case 4:
							nivel = "Pós-Doutorado";
							break;
						}
						
						%>
					
						<div class="col-md-6 mb-3">
							<label for="validationCustom01">Nível</label>
								<select name="nivel" class="form-control">
									<option value="<%=user.getNivel()%>"><%=nivel%> </option>
									<option value="1">Iniciação Cientifica</option>
									<option value="2">Mestrado</option>
									<option value="3">Doutorado</option>
									<option value="4">Pós-Doutorado</option>
								</select>
						</div>	
						
						<div class="col-md-6 mb-3">
							<label for="validationCustom02">Universidade</label> 
							<select name="universidade" class="form-control">
							<%
							ArrayList<Universidade> lista = (ArrayList<Universidade>) request.getAttribute("lista");

							if(lista!=null){
								for (Universidade u : lista) {
									if(u.getIdUniversidade()==user.getUniversidade()){
									%>
										<option value="<%=u.getIdUniversidade()%>" selected="selected"> <%=u.getNomeUniversidade()%></option>
									<%continue;} %>
	
									<option value="<%=u.getIdUniversidade()%>"><%=u.getNomeUniversidade()%></option>
								
							<% } } %>	
								</select>
						</div>
						
					</div>


					<button name="registrarUsuario" class="btn btn-primary btn-block" type="submit" value="register">Salvar</button>
				</form>

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
