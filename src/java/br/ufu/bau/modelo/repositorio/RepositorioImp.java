package br.ufu.bau.modelo.repositorio;

import java.util.List;

import org.hibernate.*;
import java.io.*;

import br.ufu.bau.util.ConnectDB;

public class RepositorioImp<T, PK extends Serializable> implements Repositorio<T, PK> {
	
	private static Session session;
	private Class<T> classe;
	
	public RepositorioImp(Class<T> classe){
		this.setSessions(ConnectDB.getSession());
		this.setClasse(classe);
	}
	
	public void insere(T entidade){
		Transaction t = this.getSessions().beginTransaction();
		this.getSessions().save(entidade);
		t.commit();
	}
	
	public T remove(T entidade){
		Transaction t = this.getSessions().beginTransaction();
		this.getSessions().delete(entidade);
		t.commit();
		return entidade;
	}
	
	public void atualiza(T entidade){
		Transaction t = this.getSessions().beginTransaction();
		this.getSessions().update(entidade);
		t.commit();
	}
	
	public List<T> listaTodos(){
		List<T> lista = this.getSessions().createSQLQuery("select * from" + this.getClasse().getName()).list();
		return lista;
	}
	
	public T buscaPorId(PK id){
		T obj = (T)getSessions().createQuery("select from" + getClasse().getName());
		return obj;
		
	}

	public void setSessions(Session session) {
		this.session = session;
	}

	public Session getSessions() {
		return session;
	}

	public void setClasse(Class<T> classe) {
		this.classe = classe;
	}

	public Class<T> getClasse() {
		return classe;
	}

}
