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

@WebServlet(urlPatterns = { "/registro" })
public class SeveltRegistroUsuario extends HttpServlet {

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
