package br.com.pos.dominio;

public class UsuarioCriterio implements Criterio{

	private String user;
	private String senha;

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return this.user;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}
	
	

}
