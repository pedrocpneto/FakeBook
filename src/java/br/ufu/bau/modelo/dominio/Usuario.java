/**
 * 
 */
package br.ufu.bau.modelo.dominio;

import java.io.Serializable; 
import java.util.List; 


import br.ufu.bau.modelo.repositorio.*;

/**
 * @author a99580
 *
 */


public class Usuario implements Serializable{
	

	private String nomeLogin;
	
	private Long id;

	private String senha;

	private String nomeUsuario;
	
	private List<Usuario> amigos;

	private List<Arquivo> arquivos;
	
	public Usuario(String nomeLogin, String senha, List<Usuario> amigos, List<Arquivo> arquivos)
	{
		this.nomeLogin = nomeLogin;
		this.senha = senha;
		this.amigos = amigos;
		this.arquivos = arquivos;
	}


	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeLogin() {
		return this.nomeLogin;
	}
	
	public void addAmigo(Usuario amigo)
	{
		RepositorioSpecifico<Usuario, Long> dao = new RepositorioSpecifico<Usuario, Long>(Usuario.class);
		if(!(this.listarAmigos().contains(amigo))){
			dao.insere(amigo);
			amigo.addAmigo(this);
		}
	}
	
	public void addArquivo(Arquivo arquivo)
	{
		RepositorioImp<Arquivo, Long> dao = new RepositorioImp<Arquivo, Long>(Arquivo.class);	
		dao.insere(arquivo);
		arquivo.setUs(this);
	}
	
	public String removeAmigo(Usuario amigo)
	{
		RepositorioSpecifico<Usuario, Long> dao = new RepositorioSpecifico<Usuario, Long>(Usuario.class);
		return dao.remove(amigo).getNomeUsuario();
	
	}
	
	public String removeArquivo(Arquivo arquivo)
	{
		RepositorioImp<Arquivo, Long> dao = new RepositorioImp<Arquivo, Long>(Arquivo.class);
		return dao.remove(arquivo).getCaminho();
	}
	
	public List<Usuario> listarAmigos()
	{
		RepositorioSpecifico<Usuario, Long> dao = new RepositorioSpecifico<Usuario, Long>(Usuario.class);
		this.amigos = dao.buscaEspecificaAmigos(this.getId());
		return this.amigos;
	}
	
	public List<Arquivo> listarArquivo()
	{
		RepositorioSpecifico<Usuario, Long> dao = new RepositorioSpecifico<Usuario, Long>(Usuario.class);
		this.arquivos = dao.buscaEspecificaArquivos(this.getId());
		return this.arquivos;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}
	
}
