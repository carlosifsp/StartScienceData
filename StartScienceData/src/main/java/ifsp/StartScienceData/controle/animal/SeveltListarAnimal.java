package ifsp.StartScienceData.controle.animal;

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

@WebServlet(urlPatterns = { "/listarAnimal"})
public class SeveltListarAnimal  extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	AnimalDao dadosAni = new AnimalDao();
	ArrayList<Animal> listaAninmais = dadosAni.consultaAnimal();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("listarAnimal.jsp");
		
		
		req.setAttribute("listaAni", listaAninmais);
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}
}
