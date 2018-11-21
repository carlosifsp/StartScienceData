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

@WebServlet(urlPatterns = { "/painel" })
public class EdicaoUsuario extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher; 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		String cpf = req.getParameter("cpf");
		String data = req.getParameter("data");
		String nivel = req.getParameter("nivel");
		String universidade = req.getParameter("universidade");
		String email = req.getParameter("email");
	
		Usuario userEdit = new Usuario();
		
		userEdit.setNome(nome);
		userEdit.setSobreNome(sobrenome);
		userEdit.setCpf(cpf);
		userEdit.setData(data);
		userEdit.setNivel(Integer.parseInt(nivel));
		userEdit.setUniversidade(Integer.parseInt(universidade));
		userEdit.setEmail(email);
		
		UsuarioDao userDao = new UsuarioDao();
		
		String erro = userDao.atualizaUsuario(userEdit);
		
		if(erro==null) {
			req.setAttribute("msg", 1);
			dispatcher = req.getRequestDispatcher("index.jsp");
		
		}else {
			dispatcher = req.getRequestDispatcher("painel.jsp?user=" + userEdit.getEmail());
		}
		
		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			dispatcher = req.getRequestDispatcher("index.jsp");
		
		
		if(req.getParameter("user")!=null) {
			dispatcher = req.getRequestDispatcher("painel.jsp");
		
			UniversidadeDao dadosform = new UniversidadeDao();
			
			ArrayList<Universidade> lista = dadosform.consultaUniversidade();

			req.setAttribute("lista", lista);
			
			String email = req.getParameter("user");
		
			UsuarioDao userDao = new UsuarioDao();
		
			Usuario userEdit = userDao.dadosUsuario(email);
		
			req.setAttribute("user", userEdit);
			
			
		
		}
		
		
		
		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
		
	}
}
