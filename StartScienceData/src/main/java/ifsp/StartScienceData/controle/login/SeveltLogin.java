package ifsp.StartScienceData.controle.login;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.StartScienceData.modelo.usuario.Usuario;
import ifsp.StartScienceData.modelo.usuario.UsuarioDao;

@WebServlet(urlPatterns = { "/login" })
public class SeveltLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		String mensagemAoUsuario;

		String email = req.getParameter("email");
		String senhaDigitada = req.getParameter("senha");
		
		//transformando a senha digitada em md5
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(senhaDigitada.getBytes(),0,senhaDigitada.length());
			senhaDigitada = new BigInteger(1,m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			mensagemAoUsuario = "Ocorreu um erro!";
		}
		
		

		UsuarioDao verificar = new UsuarioDao();

		Usuario userTemp = verificar.verificarUsuario(email);

		if (userTemp != null) {
			if (userTemp.getSenha().equals(senhaDigitada)) {
				mensagemAoUsuario = "login Ok!";
				dispatcher = req.getRequestDispatcher("index.jsp");
			} else {
				mensagemAoUsuario = "Senha Errada!";
				dispatcher = req.getRequestDispatcher("login.jsp");
			}

		} else {
			mensagemAoUsuario = "Email não encotrado";
			dispatcher = req.getRequestDispatcher("login.jsp");
		}
		
		req.setAttribute("mensagem", mensagemAoUsuario);
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
		resp.setCharacterEncoding("UTF-8");
	}

}
