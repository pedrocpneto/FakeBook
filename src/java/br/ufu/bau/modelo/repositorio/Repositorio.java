/**
 * 
 */
package br.ufu.bau.modelo.repositorio;

import java.util.List;
import java.io.Serializable;
/**
 * @author a99580
 *
 */
public interface Repositorio<T, PK extends Serializable> {
	
	public void insere(T entidade);
	
	public T remove(T entidade);
	
	public void atualiza(T entidade);
	
	public List<T> listaTodos();
	
	public T buscaPorId(PK id);
		
}
