package ifsp.StartScienceData.controle.projeto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.StartScienceData.modelo.projeto.Projeto;
import ifsp.StartScienceData.modelo.projeto.ProjetoDao;

@WebServlet(urlPatterns = { "/listar" })
public class SeveltConsultaProjeto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("listar.jsp");

		ProjetoDao consulta = new ProjetoDao();

		ArrayList<Projeto> lista = consulta.consultaProjeto();

		req.setAttribute("lista", lista);

		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}

}
