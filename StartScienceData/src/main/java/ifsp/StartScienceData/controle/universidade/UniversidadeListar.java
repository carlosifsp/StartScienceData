package ifsp.StartScienceData.controle.universidade;

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

@WebServlet(urlPatterns = {"/instituicao" })
public class UniversidadeListar extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UniversidadeDao dadosform = new UniversidadeDao();
		
		ArrayList<Universidade> lista = dadosform.consultaUniversidade();
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("instituicao.jsp");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
	}

}
