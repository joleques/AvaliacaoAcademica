package br.com.pos.dominio;

public class Usuario {

	private String nome;
	private Integer codigo;
	private String user;

	public String getNome() {
		return this.nome;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public String getUser() {
		return this.user;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
