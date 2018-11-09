package ifsp.StartScienceData.controle.universidade;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.StartScienceData.modelo.universidade.Universidade;
import ifsp.StartScienceData.modelo.universidade.UniversidadeDao;


@WebServlet(urlPatterns = {"/cadastroUni" })
public class UniversidadeCadastro extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("Nome");
		
		Universidade uni = new  Universidade(32131, nome);
		
		UniversidadeDao uniDao = new UniversidadeDao();
		
		String erro = uniDao.insereUniversidade(uni);
		
		if(erro==null) {
			String msg = "Universidade Cadastrada!";
			req.setAttribute("mensagemCadastro", msg);
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastroinstituicao.jsp");
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastroinstituicao.jsp");
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}
	
}
