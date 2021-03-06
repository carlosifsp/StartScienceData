package ifsp.StartScienceData.controle.projeto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.StartScienceData.modelo.animal.Animal;
import ifsp.StartScienceData.modelo.animal.AnimalDao;
import ifsp.StartScienceData.modelo.projeto.Projeto;
import ifsp.StartScienceData.modelo.projeto.ProjetoDao;
import ifsp.StartScienceData.modelo.universidade.Universidade;
import ifsp.StartScienceData.modelo.universidade.UniversidadeDao;
import ifsp.StartScienceData.modelo.usuario.Usuario;
import ifsp.StartScienceData.modelo.usuario.UsuarioDao;

@WebServlet(urlPatterns = { "/alterar" })
public class SeveltListarAlterarProjeto  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("alterar.jsp");
		
		String emailUsuario = req.getParameter("user");
		
		UsuarioDao verificar = new UsuarioDao();

		Usuario userTemp = verificar.verificarUsuario(emailUsuario);
		
		
		ProjetoDao consulta = new ProjetoDao();

		ArrayList<Projeto> listaEdit = consulta.consultaProjetoEditar(userTemp.getIdUsuario());
		
		UniversidadeDao dadosform = new UniversidadeDao();
		
		ArrayList<Universidade> listaUni = dadosform.consultaUniversidade();
		
		AnimalDao dadosAni = new AnimalDao();
		
		ArrayList<Animal> listAnimal = dadosAni.consultaAnimal();
		
		
		
		req.setAttribute("listaAnimal", listAnimal);
		req.setAttribute("listaUni", listaUni);
		req.setAttribute("lista", listaEdit);

		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}

}
