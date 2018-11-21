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
						 + projeto.getNivel() +"', '1')";

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
			System.out.println(e.getMessage());
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
						int usuario = Integer.parseInt(registros.getString("Usuario_idUsuario"));
						int ativo = Integer.parseInt(registros.getString("ativo"));
						
						int idAnimal = -1;
						try {
							idAnimal = Integer.parseInt(registros.getString("Animais_idAnimais"));
						}catch (Exception e) {
							idAnimal = -1;
						}
						
						
						
						if(ativo==1) {
							projeto = new Projeto();
							
							projeto.setId(idProjeto);
							projeto.setTitulo(titulo);
							projeto.setAno(ano);
							projeto.setComite(comite);
							projeto.setNivel(nivel);
							projeto.setUniversidade(universidade);
							projeto.setIdUsuario(usuario);
							projeto.setIdAnimal(idAnimal);
	
	
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

	public String deletarProjeto(int idProjeto) {
		cfgDao = new ConfigDao();

		try {
			String erro = cfgDao.conectaBD();

			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				

				instrucaoSQL = "UPDATE `projeto` SET `ativo` = '0' WHERE `projeto`.`idProjeto` ='"+ idProjeto + "'";

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

	public int recuperarUsuario(int idProjeto) {
		cfgDao = new ConfigDao();

		int  idUsuario = -1;

		

		try {
			String erro = cfgDao.conectaBD();
			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				instrucaoSQL = "SELECT Usuario_idUsuario FROM `projeto` WHERE idProjeto = '" + idProjeto + "'";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					registros.beforeFirst();
					while (registros.next()) {
						idUsuario = Integer.parseInt(registros.getString("Usuario_idUsuario"));
						
						
						

					}
				}
				cfgDao.desconectaBD();

			} else
				idUsuario = -1;

		} catch (Exception e) {
			idUsuario = -1;
		}
		return idUsuario;
	}

	public String atualizarProjeto(Projeto projetoParaEdit) {
		cfgDao = new ConfigDao();

		try {
			String erro = cfgDao.conectaBD();

			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
					
				
				
				String part1 = "UPDATE projeto SET Titulo = '" + projetoParaEdit.getTitulo() +"', Comite = '" + projetoParaEdit.getComite() + "', ";
				String part2 = "Ano = '" + projetoParaEdit.getAno() + "', Universidade_idUniversidade = '" + projetoParaEdit.getUniversidade() + "', ";
				String part3 = "Animais_idAnimais = '" + projetoParaEdit.getIdAnimal() + "', Nivel_idNivel = '" + projetoParaEdit.getNivel() + "' ";
				String part4 = "WHERE projeto.idProjeto = '" + projetoParaEdit.getId() + "' ";
				
				instrucaoSQL = part1 + part2 + part3 + part4;

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
