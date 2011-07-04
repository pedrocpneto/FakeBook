/**
 * 
 */
package br.ufu.bau.modelo.dominio;

import java.util.Calendar;
import java.io.Serializable;

import javax.persistence.*;

/**
 * @author a99580
 *
 */

public class Arquivo  {

	/**
	 * 
	 */
	
	private Long id;
	
	private String caminho;
	
	private Long tamanho;
	
	private String descricao;
	
	private Calendar dataUpload;
	
	private Usuario us;
	
	public Arquivo(String caminho, Long tamanho, String descricao)
	{
		super();
		this.caminho = caminho;
		this.tamanho = tamanho;
		this.descricao = descricao;
		this.dataUpload = Calendar.getInstance();
	}


	public String getDescricao()
	{
		return descricao;
	}


	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}


	public Long getId()
	{
		return id;
	}


	public Long getTamanho()
	{
		return tamanho;
	}


	public Calendar getDataUpload()
	{
		return dataUpload;
	}


	public void setCaminho(String caminho)
	{
		this.caminho = caminho;
	}
	

	public String getCaminho() {
	
		return caminho;
	}


	public void setUs(Usuario us) {
		this.us = us;
	}


	public Usuario getUs() {
		return us;
	}

}
