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

@WebServlet(urlPatterns = { "/salvarEdicao" })
public class SeveltEditarProjeto extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	UniversidadeDao dadosform = new UniversidadeDao();
	ArrayList<Universidade> listaUni = dadosform.consultaUniversidade();
	
	AnimalDao dadosAni = new AnimalDao();
	ArrayList<Animal> listaAninmais = dadosAni.consultaAnimal();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unused")
		RequestDispatcher dispatcher = null;
		
		
		String idParaEdicao = req.getParameter("idProjeto");
		String titulo = req.getParameter("titulo");
		String ano = req.getParameter("ano");
		String comite = req.getParameter("comite");
		String nivel = req.getParameter("nivel");
		String universidade = req.getParameter("universidade");
		String animal = req.getParameter("animal");
		
		
		Projeto projetoParaEdit = new Projeto();
		
		projetoParaEdit.setId(Integer.parseInt(idParaEdicao));
		projetoParaEdit.setTitulo(titulo);
		projetoParaEdit.setAno(ano);
		projetoParaEdit.setComite(comite);
		projetoParaEdit.setNivel(Integer.parseInt(nivel));
		projetoParaEdit.setUniversidade(Integer.parseInt(universidade));
		projetoParaEdit.setIdAnimal(Integer.parseInt(animal));
		
		
		ProjetoDao editProjeto = new ProjetoDao();
		
		String erro = editProjeto.atualizarProjeto(projetoParaEdit);
		
		
		if(erro==null) {
			dispatcher = req.getRequestDispatcher("alterar.jsp");
			int msg = 1;
			
			String emailUsuario = req.getParameter("user");
			
			UsuarioDao verificar = new UsuarioDao();

			Usuario userTemp = verificar.verificarUsuario(emailUsuario);
			
			
			ProjetoDao consulta = new ProjetoDao();

			ArrayList<Projeto> listaEdit = consulta.consultaProjetoEditar(userTemp.getIdUsuario());
			
			
			req.setAttribute("lista", listaEdit);
			req.setAttribute("listaUni", listaUni);
			req.setAttribute("msg", msg);
		}else {
			dispatcher = req.getRequestDispatcher("edicaoprojeto.jsp");
			int msg = 0;
			req.setAttribute("mensagemAlteracao", msg);
			req.setAttribute("IdEdit", idParaEdicao);
			req.setAttribute("listaUni", listaUni);
			req.setAttribute("listaAni", listaAninmais);
		}
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("edicaoprojeto.jsp");
		
		String idParaEdicao = req.getParameter("idProjeto");
		
		
		
		
		req.setAttribute("IdEdit", idParaEdicao);
		req.setAttribute("listaUni", listaUni);
		req.setAttribute("listaAni", listaAninmais);
		
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}

}
