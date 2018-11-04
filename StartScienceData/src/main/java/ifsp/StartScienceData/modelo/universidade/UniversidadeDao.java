package ifsp.StartScienceData.modelo.universidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ifsp.StartScienceData.modelo.ConfigDao;



public class UniversidadeDao {
	private ConfigDao cfgDao;
	private String instrucaoSQL;
	private Connection conexao;
	private PreparedStatement comando;
	private ResultSet registros;
	
	
	
	public ArrayList<Universidade> consultaUniversidade() {
		cfgDao = new ConfigDao();
		
		Universidade universidade;

		ArrayList<Universidade> universidades = new ArrayList<Universidade>();

		try {
			String erro = cfgDao.conectaBD();
			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				instrucaoSQL = "SELECT * FROM `universidade`";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					registros.beforeFirst();
					while (registros.next()) {
						Integer idUni = Integer.parseInt(registros.getString("idUniversidade"));
						String nome = registros.getString("Nome");
						
						

						universidade = new Universidade(idUni, nome);
				


						universidades.add(universidade);

					}
				}
				cfgDao.desconectaBD();

			} else
				universidades = null;

		} catch (Exception e) {
			universidades = null;
		}
		if(universidades==null)
			System.out.println("é null");
		return universidades;
	}
	
}
