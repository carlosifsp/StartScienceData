package ifsp.StartScienceData.modelo.usuario;



public class Usuario {
	private int idUsuario;
	private String nome;
	private String sobreNome;
	private String email;
	private String senha;
	private String data;
	private String cpf;
	private int universidade;
	private int nivel;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nome,String sobreNome,String email,String senha,String data,String cpf, int universidade,int nivel) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.senha = senha;
		this.data = data;
		this.cpf = cpf;
		this.universidade = universidade;
		this.nivel = nivel;
	}
	
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getUniversidade() {
		return universidade;
	}
	public void setUniversidade(int universidade) {
		this.universidade = universidade;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	} 
	
	
}
