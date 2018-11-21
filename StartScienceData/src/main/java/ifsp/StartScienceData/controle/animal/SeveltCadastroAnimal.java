package ifsp.StartScienceData.controle.animal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.StartScienceData.modelo.animal.Animal;
import ifsp.StartScienceData.modelo.animal.AnimalDao;

@WebServlet(urlPatterns = { "/inserirAnimal"})
public class SeveltCadastroAnimal  extends HttpServlet{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String apelido = req.getParameter("apelido");
		String especie = req.getParameter("especie");
		int idade = Integer.parseInt(req.getParameter("idade"));
		int genero = Integer.parseInt(req.getParameter("genero"));
		String drogras1 = req.getParameter("drogras");
		String exercicios1 = req.getParameter("exercicios");
		
		int drogras = 0;
		int exercicios = 0;

		if(drogras1!=null) {
			drogras = 1;
		}
		
		if(exercicios1!=null) {
			exercicios = 1;
		}
		
		
		Animal animal = new Animal(apelido, especie, idade, genero, drogras, exercicios);
		
		AnimalDao gravaAnimal = new AnimalDao();
		
		String erro = gravaAnimal.insereAnimal(animal);
		
		
		if(erro==null) {
			int msg = 1;
			req.setAttribute("mensagemCadastro", msg);
		}else {
			int msg = 0;
			req.setAttribute("mensagemCadastro", msg);
		}
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("inseriranimal.jsp");
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
		
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
