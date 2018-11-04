package ifsp.StartScienceData.modelo.universidade;

public class Universidade {
	private int idUniversidade;
	private String nomeUniversidade;
	
	
	public Universidade(int id, String nome) {
		this.idUniversidade = id;
		this.nomeUniversidade = nome;
	}


	public int getIdUniversidade() {
		return idUniversidade;
	}


	public String getNomeUniversidade() {
		return nomeUniversidade;
	}
	
}
