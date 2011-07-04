/**
 * 
 */
package br.ufu.bau.modelo.repositorio;

import java.io.Serializable; 
import java.util.List;

import br.ufu.bau.modelo.dominio.Arquivo;
import br.ufu.bau.modelo.dominio.Usuario;


/**
 * @author Artur
 *
 */
public class RepositorioSpecifico<T, PK extends Serializable> extends RepositorioImp<T, PK> {

	public RepositorioSpecifico(Class<T> classe) {
		super(classe);

	}
	
	public List<Usuario> buscaEspecificaAmigos(Long PK){
		List<Usuario> lista = this.getSessions()
		.createSQLQuery("select * from amigos where FK_usuario = " + PK ).list();
		return lista;
		/*Transaction t = this.getSessions().beginTransaction();
		List<Usuario> c = this.getSessions()
		.createCriteria(entidade.getClass())
		.add(Restrictions.eqProperty("FK_usuario","codigoUsuario")).list();
		return c;*/
	}
	
	public List<Arquivo> buscaEspecificaArquivos(Long PK){
		List<Arquivo> lista = this.getSessions()
		.createSQLQuery("select * from arquivos where FK_usuario = " + PK ).list();
		return lista;
	}

}
