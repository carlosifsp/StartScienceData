package ifsp.StartScienceData.modelo.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ifsp.StartScienceData.modelo.ConfigDao;
import ifsp.StartScienceData.modelo.projeto.Projeto;

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
				instrucaoSQL = "SELECT `Senha` FROM `usuario` WHERE email = '" + email + "'";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					//registros.beforeFirst();

					String senha = registros.getString("Senha");

					usuario = new Usuario();

					usuario.setSenha(senha);

				}else {
					usuario = null;
				}
				cfgDao.desconectaBD();

			} else
				usuario = null;

		} catch (Exception e) {
			usuario = null;
		}
		if (usuario == null)
			System.out.println("é null");
		return usuario;
	}

}
