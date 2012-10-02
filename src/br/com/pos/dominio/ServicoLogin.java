package br.com.pos.dominio;

public class ServicoLogin {

	private Repositorio repositorioUsuario;

	public ServicoLogin(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	public Usuario logar(String user, String senha) throws Exception {	
		validarUserSenha(user, senha);
		return (Usuario) repositorioUsuario.buscar(criterio(user, senha));
	}

	private UsuarioCriterio criterio(String user, String senha) {
		UsuarioCriterio criterio = new UsuarioCriterio();
		criterio.setUser(user);
		criterio.setSenha(senha);
		return criterio;
	}

	private void validarUserSenha(String user, String senha) throws Exception {
		validarUser(user);
		validarSenha(senha);
	}

	private void validarSenha(String senha) throws Exception {
		if(senha == null || senha.equals("")){
			throw new Exception("Senha Invalida.");
		}
	}

	private void validarUser(String user) throws Exception {
		if(user == null || user.equals("")){
			throw new Exception("Usuario Invalido.");
		}
		
	}

}
