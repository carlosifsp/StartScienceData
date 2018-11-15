package ifsp.StartScienceData.modelo.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ifsp.StartScienceData.modelo.ConfigDao;


public class UsuarioDao {
	private ConfigDao cfgDao;
	private String instrucaoSQL;
	private Connection conexao;
	private PreparedStatement comando;
	private ResultSet registros;

	public String insereUsuario(Usuario usuario) {
		cfgDao = new ConfigDao();

		try {
			String erro = cfgDao.conectaBD();

			if (erro == null) {
				conexao = cfgDao.getConexaoBD();

				// INSERT INTO `usuario` VALUES (NULL, 'Bruno Lemmes', 'Lemmes',
				// 'bruno@gmail.com', '123456', '20/02/1983', '12345678925', '1', '1');

				instrucaoSQL = "insert into usuario values(null,'" + usuario.getNome() + "','" + usuario.getSobreNome()
						+ "','" + usuario.getEmail() + "',MD5('" + usuario.getSenha() + "'),'" + usuario.getData()
						+ "','" + usuario.getCpf() + "','" + usuario.getUniversidade() + "','" + usuario.getNivel()
						+ "')";
				
				comando = conexao.prepareStatement(instrucaoSQL);
				comando.execute();
				cfgDao.desconectaBD();

			} else
				return erro;

		} catch (Exception e) {
			return "Tipo de Excessão: " + e.getClass().getSimpleName() + "\n *Mensagem: " + e.getMessage();
		}

		return null;
	}

	public Usuario verificarUsuario(String email) {
		cfgDao = new ConfigDao();

		Usuario usuario = new Usuario();

		try {
			String erro = cfgDao.conectaBD();
			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				instrucaoSQL = "SELECT `Senha`, `idUsuario`,  `Email`, `Nome` FROM `usuario` WHERE email = '" + email + "'";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					//registros.beforeFirst();
					
					String email1 = registros.getString("Email");
					String senha = registros.getString("Senha");
					String nome =  registros.getString("Nome");
					int idUsuario = Integer.parseInt(registros.getString("idUsuario"));

					usuario = new Usuario();
					
					usuario.setEmail(email1);
					usuario.setSenha(senha);
					usuario.setNome(nome);
					usuario.setIdUsuario(idUsuario);

				}else {
					usuario = null;
				}
				cfgDao.desconectaBD();

			} else
				usuario = null;

		} catch (Exception e) {
			usuario = null;
		}
		return usuario;
	}
	
	public Usuario dadosUsuario(String email) {
		cfgDao = new ConfigDao();

		Usuario usuario = new Usuario();

		try {
			String erro = cfgDao.conectaBD();
			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				instrucaoSQL = "SELECT * FROM `usuario` WHERE email = '" + email + "'";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					//registros.beforeFirst();
					
					String email1 = registros.getString("Email");
					String nome =  registros.getString("Nome");
					String sobrenome =  registros.getString("Sobrenome");
					String data =  registros.getString("DataNascimento");
					String cpf =  registros.getString("CPF");
					int universidade = Integer.parseInt(registros.getString("Universidade_idUniversidade"));
					int nivel = Integer.parseInt(registros.getString("Nivel_idNivel"));

					usuario = new Usuario();
					
					usuario.setEmail(email1);
					usuario.setNome(nome);
					usuario.setSobreNome(sobrenome);
					usuario.setData(data);
					usuario.setCpf(cpf);
					usuario.setUniversidade(universidade);
					usuario.setNivel(nivel);
					
					

				}else {
					usuario = null;
				}
				cfgDao.desconectaBD();

			} else
				usuario = null;

		} catch (Exception e) {
			usuario = null;
		}
		return usuario;
	}

	public String atualizaUsuario(Usuario usuario) {
		cfgDao = new ConfigDao();

		try {
			String erro = cfgDao.conectaBD();

			if (erro == null) {
				conexao = cfgDao.getConexaoBD();

				

				instrucaoSQL = "update usuario set Nome = '" + usuario.getNome() + "', Sobrenome = '"
						+ usuario.getSobreNome() + "', DataNascimento = '"
								+usuario.getData()+ "', Universidade_idUniversidade ='"
									+ usuario.getUniversidade()	+ "', Nivel_idNivel = '"
										+ usuario.getNivel() + "' WHERE Email = '"
											+usuario.getEmail()	+ "'";	
				
				System.out.println(instrucaoSQL);
				comando = conexao.prepareStatement(instrucaoSQL);
				comando.execute();
				cfgDao.desconectaBD();

			} else
				return erro;

		} catch (Exception e) {
			return "Tipo de Excessão: " + e.getClass().getSimpleName() + "\n *Mensagem: " + e.getMessage();
		}
		System.out.println("null");
		return null;
	}

}
