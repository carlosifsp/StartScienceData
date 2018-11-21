package ifsp.StartScienceData.modelo.animal;

public class Animal {
	private int id;
	private String apelido;
	private String especie;
	private int idade;
	private int genero;
	private int drogras;
	private int exercicios;
	
	public Animal() {
		
	}
	
	public Animal(String apelido, String especie, int idade, int genero, int drogras, int exercicios) {
		this.apelido = apelido;
		this.especie = especie;
		this.idade = idade;
		this.genero = genero;
		this.drogras = drogras;
		this.exercicios = exercicios;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public int getDrogras() {
		return drogras;
	}
	public void setDrogras(int drogras) {
		this.drogras = drogras;
	}
	public int getExercicios() {
		return exercicios;
	}
	public void setExercicios(int exercicios) {
		this.exercicios = exercicios;
	}
	
	
}
