package ifsp.StartScienceData.modelo.projeto;

public class Projeto {
	private int id;
	private String titulo;
	private String ano;
	private String comite;
	private int nivel;
	private int universidade;

	
	
	

	
	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getTitulo() {
		return titulo;
	}






	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}






	public String getAno() {
		return ano;
	}






	public void setAno(String ano) {
		this.ano = ano;
	}






	public String getComite() {
		return comite;
	}






	public void setComite(String comite) {
		this.comite = comite;
	}






	public int getNivel() {
		return nivel;
	}






	public void setNivel(int nivel) {
		this.nivel = nivel;
	}






	public int getUniversidade() {
		return universidade;
	}






	public void setUniversidade(int universidade) {
		this.universidade = universidade;
	}






	@Override
	public String toString() {
		return super.toString();
	}
}
