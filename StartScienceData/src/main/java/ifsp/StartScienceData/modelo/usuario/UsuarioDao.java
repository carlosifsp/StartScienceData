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
	
	
	public String insereAluno(Usuario usuario) {
		cfgDao = new ConfigDao();

		try {
			String erro = cfgDao.conectaBD();

			if (erro == null) {
				conexao = cfgDao.getConexaoBD();

				//INSERT INTO `usuario`  VALUES (NULL, 'Bruno Lemmes', 'Lemmes', 'bruno@gmail.com', '123456', '20/02/1983', '12345678925', '1', '1');

				instrucaoSQL = "insert into projeto values(null, '"
						+usuario.getNome() + "','"
								+ usuario.getSobreNome() + "','"
										+ usuario.getEmail() + "',MD5('"
												+ usuario.getSenha() +"'),'"
														+ ")";
															
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
}
