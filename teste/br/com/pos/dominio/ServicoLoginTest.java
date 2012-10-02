package br.com.pos.dominio;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicoLoginTest {

	private static final String SENHA = "teste123";
	private static final String USER = "joleques";
	private static final Integer CD_USUARIO = new Integer(1);
	private static final String NOME_USUARIO = "Jorge Oleques";

	private ServicoLogin servicoLogin;
	private RepositorioUsuario repositorioUsuario;

	@Before
	public void setUp() throws Exception {
		repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
		servicoLogin = new ServicoLogin(repositorioUsuario);
	}

	@After
	public void tearDown() throws Exception {
		servicoLogin = null;
	}

	@Test
	public void deveRetornarUmUsuarioQuandoForPassadoUserSenhaExistentes() {
		try {
			// DADO QUE EU TENHA UM USER E UMA SENHA E EXISTA NA BASE
			String user = USER;
			String senha = SENHA;

			Usuario usuario = quandoExecutarLogin(user, senha, usuarioMocado());

			// ENTÃO VOU PODER ENTRAR NA APLICAÇÃO
			Assert.assertEquals(NOME_USUARIO, usuario.getNome());
			Assert.assertEquals(CD_USUARIO, usuario.getCodigo());
			Assert.assertEquals(USER, usuario.getUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void deveRetornarUmUsuarioNuloQuandoForPassadoUserSenhaInexistente() {
		try {
			// DADO QUE EU TENHA UM USER E UMA SENHA E NÃO REGISTRO EXISTA NA BASE
			String user = USER;
			String senha = SENHA;

			Usuario usuario = quandoExecutarLogin(user, senha, null);

			// ENTÃO NÃO VOU PODER ENTRAR NA APLICAÇÃO
			Assert.assertNull(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void deveRetornarUmaExcecaoQuandoForPassadoUserNulo() {
		try {
			// DADO QUE EU PASSE UM USER NULO
			String user = null;
			String senha = SENHA;

			quandoExecutarLogin(user, senha, null);
			
			Assert.fail("Teste falhou");
		} catch (Exception e) {
			// ENTÃO VAI TER UMA MENSAGEM PARA TELA
			Assert.assertEquals("Usuario Invalido.", e.getMessage());
		}
	}

	@Test
	public void deveRetornarUmaExcecaoQuandoForPassadoUserVazio() {
		try {
			// DADO QUE EU PASSE UM USER NULO
			String user = "";
			String senha = SENHA;

			quandoExecutarLogin(user, senha, null);
			
			Assert.fail("Teste falhou");
		} catch (Exception e) {
			// ENTÃO VAI TER UMA MENSAGEM PARA TELA
			Assert.assertEquals("Usuario Invalido.", e.getMessage());
		}
	}

	@Test
	public void deveRetornarUmaExcecaoQuandoForPassadoSenhaVazio() {
		try {
			// DADO QUE EU PASSE UM USER NULO
			String user = USER;
			String senha = "";

			quandoExecutarLogin(user, senha, null);
			
			Assert.fail("Teste falhou");
		} catch (Exception e) {
			// ENTÃO VAI TER UMA MENSAGEM PARA TELA
			Assert.assertEquals("Senha Invalida.", e.getMessage());
		}
	}

	@Test
	public void deveRetornarUmaExcecaoQuandoForPassadoSenhaNula() {
		try {
			// DADO QUE EU PASSE UM USER NULO
			String user = USER;
			String senha = null;

			quandoExecutarLogin(user, senha, null);
			
			Assert.fail("Teste falhou");
		} catch (Exception e) {
			// ENTÃO VAI TER UMA MENSAGEM PARA TELA
			Assert.assertEquals("Senha Invalida.", e.getMessage());
		}
	}

	private Usuario quandoExecutarLogin(String user, String senha, Usuario retorno) throws Exception {
		Mockito.when(repositorioUsuario.buscar(Mockito.any(UsuarioCriterio.class))).thenReturn(retorno);
		return servicoLogin.logar(user, senha);
	}

	private Usuario usuarioMocado() {
		Usuario usuario = new Usuario();
		usuario.setNome(NOME_USUARIO);
		usuario.setCodigo(CD_USUARIO);
		usuario.setUser(USER);
		return usuario;
	}

}
