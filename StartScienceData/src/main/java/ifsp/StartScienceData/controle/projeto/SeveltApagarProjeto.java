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

@WebServlet(urlPatterns = { "/alterarExcluir" })
public class SeveltApagarProjeto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("alterar.jsp");
		String msg = "Não foi possivel apagar o Projeto!";
		ArrayList<Projeto> listaEdit = null;
		
		
		UniversidadeDao dadosform = new UniversidadeDao();
		
		ArrayList<Universidade> listaUni = dadosform.consultaUniversidade();
		
		
		if(req.getParameter("id")!=null) {
			
			int idProjeto = Integer.parseInt(req.getParameter("id"));
			
			ProjetoDao deleteProjeto = new ProjetoDao();
			String erro = deleteProjeto.deletarProjeto(idProjeto);
			
			if(erro==null) {
				msg = "Projeto Apagado com Sucesso!";
			}
			
			
			//recuperar o id do usuario 
			
			int idUsuario = deleteProjeto.recuperarUsuario(idProjeto);
			
			
			listaEdit = deleteProjeto.consultaProjetoEditar(idUsuario);
			
			
			
			req.setAttribute("listaUni", listaUni);

			req.setAttribute("lista", listaEdit);
			
			req.setAttribute("msg", msg);
			
			dispatcher.forward(req, resp);
			resp.setCharacterEncoding("UTF-8");
			
		}
		
		
			
		
		
		
	}
	
}
