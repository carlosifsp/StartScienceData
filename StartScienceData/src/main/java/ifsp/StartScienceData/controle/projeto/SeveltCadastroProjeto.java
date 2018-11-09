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
	
	UniversidadeDao dadosform = new UniversidadeDao();
	
	ArrayList<Universidade> lista = dadosform.consultaUniversidade();

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

		projetoNovo.setNivel(Integer.parseInt(nivel));

		projetoNovo.setUniversidade(Integer.parseInt(universidade));
		

		ProjetoDao bancoProjeto = new ProjetoDao();

	
		String erro = bancoProjeto.insereProjeto(projetoNovo);
		
		if(erro==null) {
			String msg = "Projeto Cadastrado!";
			req.setAttribute("mensagemCadastro", msg);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastroprojeto.jsp");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastroprojeto.jsp");
		
		
		
		
		req.setAttribute("lista", lista);
		

		dispatcher.forward(req, resp);

		resp.setCharacterEncoding("UTF-8");
	}

}
