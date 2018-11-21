package ifsp.StartScienceData.modelo.animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ifsp.StartScienceData.modelo.ConfigDao;



public class AnimalDao {
	private ConfigDao cfgDao;
	private String instrucaoSQL;
	private Connection conexao;
	private PreparedStatement comando;
	private ResultSet registros;
	
	
	public String insereAnimal(Animal animal) {
		cfgDao = new ConfigDao();

		try {
			String erro = cfgDao.conectaBD();

			if (erro == null) {
				conexao = cfgDao.getConexaoBD();

				//INSERT INTO `animais` (`idAnimais`, `apelido`, `Especie`, `Idade`, `Genero`, `Drogas`, `Exercicio`) 
				//VALUES (NULL, 'Testando Apelido', 'T especie', '2', '1', '0', '1');
				String primeira = "INSERT INTO `animais` (`idAnimais`, `apelido`, `Especie`, `Idade`, `Genero`, `Drogas`, `Exercicio`) ";
				
				
				String segunda = "VALUES (NULL, '"
						+ animal.getApelido() + "','"
								+ animal.getEspecie() + "','"
										+animal.getIdade() + "','"
												+ animal.getGenero() + "','"
														+ animal.getDrogras() +"','"
																+ animal.getExercicios() +"')";
				
				
				
				instrucaoSQL = primeira + segunda;

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
	
	public ArrayList<Animal> consultaAnimal() {
		cfgDao = new ConfigDao();

		Animal animal;

		ArrayList<Animal> animais = new ArrayList<Animal>();

		try {
			String erro = cfgDao.conectaBD();
			if (erro == null) {
				conexao = cfgDao.getConexaoBD();
				instrucaoSQL = "SELECT * FROM `animais`";
				comando = conexao.prepareStatement(instrucaoSQL);

				registros = comando.executeQuery();
				if (registros.next()) {
					registros.beforeFirst();
					while (registros.next()) {
						Integer idAnimal = Integer.parseInt(registros.getString("idAnimais"));
						String apelido = registros.getString("apelido");
						String especie = registros.getString("Especie");
						int idade = Integer.parseInt(registros.getString("Idade"));
						int genero = Integer.parseInt(registros.getString("Genero"));
						int drogras = Integer.parseInt(registros.getString("Drogas"));
						int exercicios = Integer.parseInt(registros.getString("Exercicio"));
					
							animal = new Animal();
							
							animal.setId(idAnimal);
							animal.setApelido(apelido);
							animal.setEspecie(especie);
							animal.setIdade(idade);
							animal.setGenero(genero);
							animal.setDrogras(drogras);
							animal.setExercicios(exercicios);
							
							
	
	
							animais.add(animal);
						
					}
				}
				cfgDao.desconectaBD();

			} else
				animais = null;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			animais = null;
		}
		return animais;
	}
	
	

}
