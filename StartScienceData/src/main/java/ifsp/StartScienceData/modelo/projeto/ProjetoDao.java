package ifsp.StartScienceData.modelo.projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ifsp.StartScienceData.modelo.ConfigDao;

public class ProjetoDao {

	private ConfigDao cfgDao;
	private String instrucaoSQL;
	private Connection conexao;
	private PreparedStatement comando;
	private ResultSet registros;

	public String insereProjeto(Projeto projeto) {
		cfgDao = new ConfigDao();

		try {
			String erro = cfgDao.conectaBD();

			if (erro == null) {
				conexao = cfgDao.getConexaoBD();

				//INSERT INTO `projeto` VALUES (NULL, 'Teste', '123456', '2018', '1', NULL, NULL, '2');

				instrucaoSQL = "insert into projeto values(NULL, '" + projeto.getTitulo() 
						+ "','" + projeto.getComite() + "','" +
						projeto.getAno() + "','"+
						projeto.getUniversidade() + "', null,'" + projeto.getIdUsuario() + "','"
						 + projeto.getNivel() +"', null)";

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

	public ArrayList<Projeto> consultaProjeto() {
		cfgDao = new ConfigDao();

		Projeto projeto;

		ArrayList<Projeto> projetos = new ArrayList<Projeto>();

		try {
			String erro = cfgDao.conectaBD();
			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				instrucaoSQL = "SELECT * FROM `projeto`";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					registros.beforeFirst();
					while (registros.next()) {
						Integer idProjeto = Integer.parseInt(registros.getString("idProjeto"));
						String titulo = registros.getString("Titulo");
						String ano = registros.getString("Ano");
						String comite = registros.getString("Comite");
						int nivel = Integer.parseInt(registros.getString("Nivel_idNivel"));
						int universidade = Integer.parseInt(registros.getString("Universidade_idUniversidade"));
						int ativo = Integer.parseInt(registros.getString("ativo"));
						
						if(ativo==1) {
							projeto = new Projeto();
							
							projeto.setId(idProjeto);
							projeto.setTitulo(titulo);
							projeto.setAno(ano);
							projeto.setComite(comite);
							projeto.setNivel(nivel);
							projeto.setUniversidade(universidade);
	
	
							projetos.add(projeto);
						}
					}
				}
				cfgDao.desconectaBD();

			} else
				projetos = null;

		} catch (Exception e) {
			projetos = null;
		}
		return projetos;
	}

	public ArrayList<Projeto> consultaProjetoEditar(int idUsuario) {
		cfgDao = new ConfigDao();

		Projeto projeto;

		ArrayList<Projeto> projetos = new ArrayList<Projeto>();

		try {
			String erro = cfgDao.conectaBD();
			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				instrucaoSQL = "SELECT * FROM `projeto` WHERE Usuario_idUsuario = '" + idUsuario + "'";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					registros.beforeFirst();
					while (registros.next()) {
						Integer idProjeto = Integer.parseInt(registros.getString("idProjeto"));
						String titulo = registros.getString("Titulo");
						String ano = registros.getString("Ano");
						String comite = registros.getString("Comite");
						int nivel = Integer.parseInt(registros.getString("Nivel_idNivel"));
						int universidade = Integer.parseInt(registros.getString("Universidade_idUniversidade"));
						int ativo = Integer.parseInt(registros.getString("ativo"));
						
						if(ativo==1) {
							projeto = new Projeto();
							
							projeto.setId(idProjeto);
							projeto.setTitulo(titulo);
							projeto.setAno(ano);
							projeto.setComite(comite);
							projeto.setNivel(nivel);
							projeto.setUniversidade(universidade);
	
	
							projetos.add(projeto);
						}

					}
				}
				cfgDao.desconectaBD();

			} else
				projetos = null;

		} catch (Exception e) {
			projetos = null;
		}
		return projetos;
	}

}
