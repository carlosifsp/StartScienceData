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
import ifsp.StartScienceData.modelo.universidade.Universidade;
import ifsp.StartScienceData.modelo.universidade.UniversidadeDao;

@WebServlet(urlPatterns = { "/cadastro", "/cadastroProjeto" })
public class SeveltCadastroProjeto extends HttpServlet {

	/**
	 * @author Carlos Mario, Bruno Lemmes, Matheus Roncon
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String ano = req.getParameter("ano");
		String comite = req.getParameter("comite");
		String nivel = req.getParameter("nivel");
		String universidade = req.getParameter("universidade");

		Projeto projetoNovo = new Projeto();

		projetoNovo.setTitulo(titulo);
		projetoNovo.setAno(ano);
		projetoNovo.setComite(comite);

		projetoNovo.setNivel(2);

		projetoNovo.setUniversidade(1);

		ProjetoDao bancoProjeto = new ProjetoDao();

		System.out.println("Chegou aqui");
		System.out.println(nivel);
		String erro = bancoProjeto.insereAluno(projetoNovo);
		System.out.println(erro);

		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastroprojeto.jsp");

		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastroprojeto.jsp");
		
		UniversidadeDao dadosform = new UniversidadeDao();
		
		ArrayList<Universidade> lista = dadosform.consultaUniversidade();
		
		
		req.setAttribute("lista", lista);
		

		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
	}

}