package br.ufu.bau.modelo.dominio;

import br.ufu.bau.modelo.repositorio.Repositorio;
import java.util.List;

public class Login
{
	private Usuario usuario;
	private Repositorio<Usuario, Long> usuarios;
	
	public Login(Repositorio<Usuario, Long> usuarios)
	{
		this.usuarios = usuarios;
	}
	
	public Usuario loga(String nomeLogin, String senha)
	{
		if(usuario != null){
			return usuario;
		}
		
		List<Usuario> lista = usuarios.listaTodos();
		for(Usuario u : lista)
		{
			if(u.getNomeLogin().equals(nomeLogin) && u.getSenha().equals(senha))
			{
				this.usuario = u;
				return this.usuario;
			}
		}
		return null;
	}

}
