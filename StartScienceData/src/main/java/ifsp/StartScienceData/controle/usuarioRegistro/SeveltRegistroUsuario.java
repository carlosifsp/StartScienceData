package ifsp.StartScienceData.controle.usuarioRegistro;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.StartScienceData.modelo.universidade.Universidade;
import ifsp.StartScienceData.modelo.universidade.UniversidadeDao;
import ifsp.StartScienceData.modelo.usuario.Usuario;
import ifsp.StartScienceData.modelo.usuario.UsuarioDao;

@WebServlet(urlPatterns = { "/registro" })
public class SeveltRegistroUsuario extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		String cpf = req.getParameter("cpf");
		String data = req.getParameter("data");
		String nivel = req.getParameter("nivel");
		String universidade = req.getParameter("universidade");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		
		Usuario user = new Usuario(nome, sobrenome, email, senha, data, cpf, Integer.parseInt(universidade), Integer.parseInt(nivel));
		
		UsuarioDao bancoUsuario = new UsuarioDao();
		
		String erro = bancoUsuario.insereUsuario(user);
		
		if(erro==null) {
		
			dispatcher = req.getRequestDispatcher("login.jsp");
			
			
		}else {
			dispatcher = req.getRequestDispatcher("register.jsp");
		}
		
		System.out.println(erro);
		
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");

		UniversidadeDao dadosform = new UniversidadeDao();

		ArrayList<Universidade> lista = dadosform.consultaUniversidade();

		req.setAttribute("lista", lista);

		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
	}
}
