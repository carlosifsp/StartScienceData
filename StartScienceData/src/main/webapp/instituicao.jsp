<%@page import="ifsp.StartScienceData.modelo.universidade.Universidade"%>
<%@page import="ifsp.StartScienceData.modelo.usuario.Usuario"%>
<%@page import="java.util.ArrayList"
	import="ifsp.StartScienceData.modelo.usuario.Usuario"
	%>
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

    <title>StartScienceData</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>

  <body id="page-top">
    <% 
  	Usuario user = null;
  	if(request.getAttribute("UserLogado")!=null){
  		user = (Usuario) request.getAttribute("UserLogado");
  	}else{
  		if(session.getAttribute("UserLogado")!=null){
  			user = (Usuario) session.getAttribute("UserLogado");
  		}
  	}
  			
  		
  	
  %>

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.jsp">Start Science Data</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Buscar por..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
        
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>  <%
          if(user!=null){
          	session.setAttribute("UserLogado", user); 
          %>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a type="text" class="dropdown-item" disable><%=user.getNome()%></a>
            <a class="dropdown-item" href="painel?user=<%=user.getEmail()%>">Editar</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="login" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
          <%}else{
        	  response.sendRedirect("login");
          }
       	
       	%>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Projetos</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Dados dos Projetos:</h6>
            <a class="dropdown-item" href="cadastro">Cadastrar</a>
            <a class="dropdown-item" href="listar">Listar</a>
            <%if(user!=null){ %>
            <a class="dropdown-item" href="alterar?user=<%=user.getEmail()%>">Alterar</a>
            <%} %>
            <div class="dropdown-divider"></div>

          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="instituicao">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Institui��es</span></a>
        </li>
 
    
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.jsp">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Institui��es</li>
          </ol>

          <!-- Page Content -->
          <h1>Institui��es<br></h1>
          <hr>
          
        
         <a class="btn btn-primary" href="cadastroinstituicao.jsp">Cadastrar</a>
      	<br>
      	<br>
     	
     	<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Tabela de Projetos
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
								
										
										
										<th>Instuti��o</th>
										
									</tr>
								</thead>

								<%
	
	ArrayList<Universidade> lista = (ArrayList<Universidade>) request.getAttribute("lista");

	if(lista!=null){
		for (Universidade u : lista) {
	

%>


								<tbody>
									<tr>
								
										<td><%=u.getNomeUniversidade()%></td>
										
										
									</tr>

								</tbody>

								<%		}
	}
%>



							</table>
						</div>
					</div>
					<div class="card-footer small text-muted">Atualizado</div>
				</div>

			</div>
        	
    

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Mario - Lemmes - Roncon Copyright � 2018</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Pronto para sair?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">X</span>
            </button>
          </div>
          <div class="modal-body">Selecione "Logout" para encerrar a sess�o.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="login.jsp">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

  </body>

</html>
