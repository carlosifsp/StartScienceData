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
						projeto.getUniversidade() + "', null, null,'" +
						projeto.getNivel() +"')";

				comando = conexao.prepareStatement(instrucaoSQL);
				comando.execute();
				cfgDao.desconectaBD();

			} else
				return erro;

		} catch (Exception e) {
			return "Tipo de Excess�o: " + e.getClass().getSimpleName() + "\n *Mensagem: " + e.getMessage();
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
						//Integer nivel = Integer.parseInt(registros.getString("Nivel_idNivel"));
						//Integer universidade = Integer.parseInt(registros.getString("Universidade_idUniversidade"));
						

						projeto = new Projeto();
						
						projeto.setId(idProjeto);
						projeto.setTitulo(titulo);
						projeto.setAno(ano);
						projeto.setComite(comite);
						projeto.setNivel(1);
						projeto.setUniversidade(2);


						projetos.add(projeto);

					}
				}
				cfgDao.desconectaBD();

			} else
				projetos = null;

		} catch (Exception e) {
			projetos = null;
		}
		if(projetos==null)
			System.out.println("� null");
		return projetos;
	}

}
